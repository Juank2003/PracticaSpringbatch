package io.bootify.practica_springbatch.config;

import io.bootify.practica_springbatch.domain.Transacciones;
import io.bootify.practica_springbatch.repos.TransaccionesRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private TransaccionesRepository transaccionesRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Bean
    public FlatFileItemReader<Transacciones> reader() {
        FlatFileItemReader<Transacciones> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("path/to/your/csv/file.csv"));
        reader.setLineMapper(new DefaultLineMapper<Transacciones>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "id", "fecha", "cantidad", "tipoTrans", "cuentaOrigen", "cuentaDestino", "dateCreated", "lastUpdated" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Transacciones>() {{
                setTargetType(Transacciones.class);
            }});
        }});
        return reader;
    }

    @Bean
    public TransaccionesItemProcessor processor() {
        return new TransaccionesItemProcessor();
    }

    @Bean
    public RepositoryItemWriter<Transacciones> writer() {
        RepositoryItemWriter<Transacciones> writer = new RepositoryItemWriter<>();
        writer.setRepository(transaccionesRepository);
        writer.setMethodName("save");
        return writer;
    }

   @Bean
   public Job job (Step step1){
       return new JobBuilder("Importecsv", jobRepository).start(step1).build();
   }

    @Bean
    public Step step1(RepositoryItemWriter<Transacciones> transaccionesRepositoryItemWriter, ItemProcessor<Transacciones, Transacciones> itemProcessor, ItemReader<Transacciones> itemReader) {
        return new StepBuilder("ImportecsvStep", jobRepository).<Transacciones, Transacciones>chunk(100,platformTransactionManager).reader(itemReader).writer(transaccionesRepositoryItemWriter).processor(itemProcessor).build();
    }
}
