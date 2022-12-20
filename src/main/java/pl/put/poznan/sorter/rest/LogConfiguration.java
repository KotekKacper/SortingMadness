package pl.put.poznan.sorter.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import pl.put.poznan.sorter.rest.LogInterceptor;

@Configuration
public class LogConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }

}