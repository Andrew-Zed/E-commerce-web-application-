package com.example.springbootwk8task.Spring;

import lombok.Builder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.annotation.Resource;
import javax.persistence.Entity;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig() {
        super();
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry){
        registry.addViewController("/addProduct");
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){

        registry.addResourceHandler(
          "/images/**",
          "/css/**",
          "/js/**"
        ).addResourceLocations(
                "classpath:/static/images/",
                "classpath:/static/css/",
                "classpath:/static/js/"

        );
    }
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer){

        //configurer.enable();

    }
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {

        final LocaleChangeInterceptor localeChangeInterceptor =
                new LocaleChangeInterceptor();
        registry.addInterceptor(localeChangeInterceptor);
    }

}
