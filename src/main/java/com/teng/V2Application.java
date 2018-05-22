package com.teng;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class V2Application {

    public static void main(String[] args) {
        SpringApplication.run(V2Application.class,args);
    }

    @Autowired
    private SpringResourceTemplateResolver templateResolver;


//    @Autowired
//    private SpringTemplateEngine springTemplateEngine;
//
//
//    @Bean
//    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine);
//        return resolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver){
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver);
//        return engine;
//    }

    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        engine.setEnableSpringELCompiler(true);
        engine.addDialect(layoutDialect());
        return engine;
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }


//    @Bean
//    public TemplateResolver templateResolver(){
//        TemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setPrefix("classpath:/templates/");//设置地址前缀
//        resolver.setSuffix(".html");//设置后缀
//        resolver.setCacheable(false);//设置不缓存
//        resolver.setTemplateMode("HTML5");
//        return resolver;
//
//    }

}
