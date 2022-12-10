package pl.put.poznan.sorter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class SortingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortingApplication.class, args);
    }
}
