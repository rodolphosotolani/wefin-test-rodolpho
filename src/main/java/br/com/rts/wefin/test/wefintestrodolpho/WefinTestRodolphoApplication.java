package br.com.rts.wefin.test.wefintestrodolpho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableWebSecurity
public class WefinTestRodolphoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WefinTestRodolphoApplication.class, args);
    }

}
