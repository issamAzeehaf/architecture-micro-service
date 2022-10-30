package ma.azehaf.openlabcustomerservice;

import ma.azehaf.openlabcustomerservice.dto.CustomerRequestDTO;
import ma.azehaf.openlabcustomerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenlabCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabCustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01","adria","adria@gmail.com"));
            customerService.save(new CustomerRequestDTO("C02","Sopra","sopra@gmail.com"));
            customerService.save(new CustomerRequestDTO("c03","EBS","ebs@gmail.com"));
        };
    }

}
