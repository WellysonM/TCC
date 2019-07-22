/*package com.backend.api.config;

import com.backend.api.documents.Cliente;
import com.backend.api.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = ClienteRepository.class)
@Configuration
public class MongoDBConfig {


    @Bean
    CommandLineRunner commandLineRunner(ClienteRepository clienteRepository) {
        return strings -> {
            clienteRepository.save(new Cliente(32l, "Peter", "teste@teste.com", "1234"));
            clienteRepository.save(new Cliente(31l, "Sam", "Operations@teste.com", "2000L"));
        };
    }

}
*/