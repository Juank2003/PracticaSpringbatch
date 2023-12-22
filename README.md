# PracticaSpringbatch

## Mi repositorio: https://github.com/Juank2003/PracticaSpringbatch.git

## Enunciado:
### Objetivo:

El objetivo de esta práctica es desarrollar una aplicación de procesamiento por batchs, utilizando la programación concurrente para optimizar el rendimiento y minimizar el tiempo de procesamiento.

El programa deberá leer un gran volumen de datos, procesar estos datos de manera eficiente utilizando programación concurrente y, finalmente, almacenar los datos procesados. El contexto de los datos será definido a continuación.

### Contexto:

Imaginemos que somos parte de una gran organización que maneja una enorme cantidad de datos de transacciones bancarias. Estos datos son almacenados en archivos planos y se necesita un programa que pueda procesar estos datos por la noche, cuando la base de datos no está bloqueada por otras tareas.

Además, se necesita que el programa pueda reanudar el trabajo en caso de fallos y sea capaz de manejar transacciones. Cada transacción constará de un lote de procesamiento de datos, por ejemplo, una confirmación cada 5,000 inserciones.

El programa deberá estar construido de tal manera que pueda dividirse en pequeñas tareas que se ejecuten en secuencia, generando flujos de trabajo, de modo similar a los microservicios.

### Detalles del Proyecto:

El programa deberá implementar las siguientes funciones:

Leer los datos del archivo de transacciones bancarias.
- Procesar los datos utilizando programación concurrente. Esta etapa deberá incluir la validación de datos y el procesamiento y cálculos sobre los datos.
- Almacenar los datos procesados en la base de datos.
- Implementar un programador que encadene las tareas y administre las operaciones de flujo.
### Recursos:

Para realizar esta práctica, se sugiere utilizar Java con el framework Spring Batch debido a su eficacia para el procesamiento por batchs. No obstante, puedes elegir el lenguaje de programación y las herramientas que prefieras, siempre que permitan la programación concurrente y sean adecuados para el procesamiento por batchs.

Se proporcionará un conjunto de datos de transacciones bancarias ficticias para fines de prueba.

This app was created with Bootify.io - tips on working with the code [can be found here](https://bootify.io/next-steps/).
Feel free to contact us for further questions.

## Development

When starting the application `docker compose up` is called and the app will connect to the contained services.
[Docker](https://www.docker.com/get-started/) must be available on the current system.

During development it is recommended to use the profile `local`. In IntelliJ `-Dspring.profiles.active=local` can be
added in the VM options of the Run Configuration after enabling this property in "Modify options". Create your own
`application-local.yml` file to override settings for development.

Lombok must be supported by your IDE. For IntelliJ install the Lombok plugin and enable annotation processing -
[learn more](https://bootify.io/next-steps/spring-boot-with-lombok.html).

In addition to the Spring Boot application, the DevServer must also be started. [Node.js](https://nodejs.org/) has to be
available on the system - the latest LTS version is recommended. On first usage and after updates the dependencies have to be installed:

```
npm install
```

The DevServer can now be started as follows:

```
npm run devserver
```

Using a proxy the whole application is now accessible under `localhost:8081`. All changes to the templates and JS/CSS
files are immediately visible in the browser.

## Build

The application can be built using the following command:

```
mvnw clean package
```

Node.js is automatically downloaded using the `frontend-maven-plugin` and the final JS/CSS files are integrated into the jar.

Start your application with the following command - here with the profile `production`:

```
java -Dspring.profiles.active=production -jar ./target/PracticaSpringbatch-0.0.1-SNAPSHOT.jar
```

If required, a Docker image can be created with the Spring Boot plugin. Add `SPRING_PROFILES_ACTIVE=production` as
environment variable when running the container.

```
mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=io.bootify/practica-springbatch
```

## Further readings

* [Maven docs](https://maven.apache.org/guides/index.html)  
* [Spring Boot reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)  
* [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)  
* [Thymeleaf docs](https://www.thymeleaf.org/documentation.html)  
* [Webpack concepts](https://webpack.js.org/concepts/)  
* [npm docs](https://docs.npmjs.com/)  
* [Bootstrap docs](https://getbootstrap.com/docs/5.3/getting-started/introduction/)  
* [Htmx in a nutshell](https://htmx.org/docs/)  
* [Learn Spring Boot with Thymeleaf](https://www.wimdeblauwe.com/books/taming-thymeleaf/)  
