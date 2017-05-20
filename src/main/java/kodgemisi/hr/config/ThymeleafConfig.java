package kodgemisi.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/*
 * THIS CLASS IS ABOUT MAPPING MY .HTML FILES TO THE PROJECT. 
 * I HAVE NEVER USED IT BEFORE THEN I HAD TO REUSE FROM
 * https://github.com/vonReany/kodgemisi16/blob/master/src/main/java/kg16/mvc/config/ThymeleafConfig.java
 * THANKS TO ENES CANKIRI
 */


@Configuration
public class ThymeleafConfig {

    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(1);
        return resolver;
    }

}