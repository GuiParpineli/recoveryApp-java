package com.quarkbyte.recoveryappjava;

import com.quarkbyte.recoveryappjava.model.*;
import com.quarkbyte.recoveryappjava.model.Case.Sinistro;
import com.quarkbyte.recoveryappjava.model.enums.Gender;
import com.quarkbyte.recoveryappjava.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Date;

public class DataLoader implements ApplicationRunner {
    private final CustomerRepository customerRepository;
    private final BondsmanRepository bondsmanRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final PlanRepository planRepository;
    private final SinistroRepository sinistroRepository;

    public DataLoader(CustomerRepository repository, BondsmanRepository bondsmanRepository, AddressRepository addressRepository, ProductRepository productRepository, PlanRepository planRepository, SinistroRepository sinistroRepository) {
        this.customerRepository = repository;
        this.bondsmanRepository = bondsmanRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.planRepository = planRepository;
        this.sinistroRepository = sinistroRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //saving customers
        customerRepository.save(
                Customer.builder()
                        .name("Alberto")
                        .lastName("Robson")
                        .cpf("123.123.134-22")
                        .email("albert@gmail.com")
                        .birthDay(new Date())
                        .gender(Gender.MASCULINO)
                        .nationality("Uganda")
                        .build()
        );
        customerRepository.save(
                Customer.builder()
                        .name("Jorge")
                        .lastName("Ventura")
                        .cpf("343.123.134-22")
                        .email("jorge@gmail.com")
                        .birthDay(new Date())
                        .gender(Gender.MASCULINO)
                        .nationality("Jamaica")
                        .build()
        );
        customerRepository.save(
                Customer.builder()
                        .name("Paulo")
                        .lastName("Wilson")
                        .cpf("553.123.134-22")
                        .email("pw@gmail.com")
                        .birthDay(new Date())
                        .gender(Gender.OUTRO)
                        .nationality("Brasil")
                        .build()
        );

        //saving Bondsman
        bondsmanRepository.save(
                Bondsman.builder()
                        .name("Paulo")
                        .lastName("Wilson")
                        .cpf("553.123.134-22")
                        .phone("1231-12312")
                        .address(new Address())
                        .email("pw@gmail.com")
                        .birthDay(new Date())
                        .gender(Gender.OUTRO)
                        .nationality("Brasil")
                        .build()
        );

        //save Address
        addressRepository.save(
                Address.builder()
                        .city("Berilo")
                        .state("MG")
                        .street("Ruas das flores")
                        .postalCode("1231-3123")
                        .build()
        );

        //save plan
        planRepository.save(
                Plan.builder()
                        .build()
        );

        //save plantypes
        sinistroRepository.save(
                Sinistro.builder()
                        .build()
        );

        //save users

        //save products
        productRepository.save(
                Product.builder()
                        .build()
        );

    }
}

