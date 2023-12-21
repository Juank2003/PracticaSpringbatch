package io.bootify.practica_springbatch.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TransaccionesDTO {

    private Long id;

    @NotNull
    private Date fecha;

    @NotNull
    private Double cantidad;

    @NotNull
    @Size(max = 255)
    private String tipotrans;

    @NotNull
    @Size(max = 255)
    private String cuentaorigen;

    @NotNull
    @Size(max = 255)
    private String cuentadestino;

}
