package com.quarkbyte.recoveryappjava;

import com.quarkbyte.recoveryappjava.model.*;
import com.quarkbyte.recoveryappjava.model.Case.Sinistro;
import com.quarkbyte.recoveryappjava.model.enums.Gender;
import com.quarkbyte.recoveryappjava.model.enums.StatusProduct;
import com.quarkbyte.recoveryappjava.model.enums.csj.*;
import com.quarkbyte.recoveryappjava.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {
    private final CustomerRepository customerRepository;
    private final BondsmanRepository bondsmanRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final PlanRepository planRepository;
    private final SinistroRepository sinistroRepository;
    private final UserRepository userRepository;

    public DataLoader(CustomerRepository repository, BondsmanRepository bondsmanRepository, AddressRepository addressRepository, ProductRepository productRepository, PlanRepository planRepository, SinistroRepository sinistroRepository, UserRepository userRepository) {
        this.customerRepository = repository;
        this.bondsmanRepository = bondsmanRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.planRepository = planRepository;
        this.sinistroRepository = sinistroRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //save address
        addressRepository.save(
                Address.builder()
                        .city("Berilo")
                        .state("MG")
                        .street("Ruas das flores")
                        .postalCode("1231-3123")
                        .build());

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
                        .address(addressRepository.findById(1L).get())
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
                        .address(addressRepository.findById(1L).get())
                        .email("pw@gmail.com")
                        .birthDay(new Date())
                        .gender(Gender.OUTRO)
                        .nationality("Brasil")
                        .build()
        );

        //save plantypes
        sinistroRepository.save(
                new Sinistro(
                        1L, new Date(), StepCSJ.ACORDO, new Date(),
                        20., 20., ResolutionType.CHARGEBACK_PAGO, false,
                        InternalStatus.ACOMPANHAR, ExternalStatus.EM_ABERTO,
                        new Date(), SinistroType.FURTO_QUALIFICADO,
                        true, true,
                        true, new Date(), 200.0f,
                        2222.0, 20.0, 200., false)
        );

        //save users
        userRepository.save(
                new UserApp(0L, "Paulera")
        );

        //save plan
        planRepository.save(
                Plan.builder()
                        .value(5000.00)
                        .planStatus(true)
                        .analist(userRepository.findAll().get(0))
                        .initialDate(LocalDateTime.now())
                        .finalDate(LocalDateTime.now())
                        .customer(customerRepository.findAll().get(0))
                        .bondsman(bondsmanRepository.findById(1L).get())
                        .caseCSJ(sinistroRepository.findById(1L).get())
                        .build()
        );


//
//        //save products
        productRepository.save(
                Product.builder()
                        .name("Iphone 13 Pro")
                        .imei("22345")
                        .imei2("4141-4141")
                        .statusProduct(StatusProduct.ADQUIRIDO)
                        .value(80000.)
                        .build()
        );

    }
}

