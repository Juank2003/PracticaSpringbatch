package io.bootify.practica_springbatch.config;
import io.bootify.practica_springbatch.domain.Transacciones;
import org.springframework.batch.item.ItemProcessor;

public class TransaccionesItemProcessor implements ItemProcessor<Transacciones, Transacciones> {

    @Override
    public Transacciones process(Transacciones item) throws Exception {
        // Aquí puedes agregar cualquier lógica de procesamiento necesaria.
        // Por ahora, simplemente estamos pasando la entidad sin cambios.
        return item;
    }

}
