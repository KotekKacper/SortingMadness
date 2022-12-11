package pl.put.poznan.sorter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"pl.put.poznan.sorter.controller", "pl.put.poznan.sorter.factory"})
@SpringBootApplication
public class SortingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortingApplication.class, args);
    }
}
