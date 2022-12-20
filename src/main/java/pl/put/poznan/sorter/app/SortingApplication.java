package pl.put.poznan.sorter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import pl.put.poznan.sorter.rest.LogConfiguration;

/**
 * Main class of the application
 */
@ComponentScan(basePackages = {"pl.put.poznan.sorter.rest", "pl.put.poznan.sorter.factory"})
@SpringBootApplication
public class SortingApplication {
    /**
     * Main method of the application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(LogConfiguration.class)
                .sources(SortingApplication.class)
                .run(args);
    }
}
