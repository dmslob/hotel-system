package com.dmslob.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@EntityScan(basePackageClasses = {ReservationServiceApplication.class, Jsr310JpaConverters.class})
public class ReservationServiceApplication {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Reservations").select()
                .apis(RequestHandlerSelectors.basePackage("com.dmslob.reservation"))
                .paths(any()).build().apiInfo(new ApiInfo("Reservation Service",
                        "A service to provide data access to reservations", "1.0.0", null,
                        new Contact("Dmytro Slobodenyuk", "https://twitter.com/dmslob", null), null, null));
    }

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }
}
