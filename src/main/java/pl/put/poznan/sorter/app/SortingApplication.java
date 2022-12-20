package pl.put.poznan.sorter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import pl.put.poznan.sorter.rest.LogConfiguration;


@ComponentScan(basePackages = {"pl.put.poznan.sorter.rest", "pl.put.poznan.sorter.factory"})
@SpringBootApplication
public class SortingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(LogConfiguration.class)
                .sources(SortingApplication.class)
                .run(args);
    }
}
