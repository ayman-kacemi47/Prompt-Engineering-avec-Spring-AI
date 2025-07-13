package net.kacemi.springai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner   commandLineRunner(ApplicationContext ctx) {
//
//
//        return args->{
//            String apikey = ctx.getEnvironment().getProperty("YOUSSFI_API_KEY");
//            System.out.println("Hello World " + apikey);
//
//        };
//    }

}
