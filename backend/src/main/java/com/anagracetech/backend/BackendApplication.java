package com.anagracetech.backend;

import com.anagracetech.backend.customer.Customer;
import com.anagracetech.backend.customer.CustomerRepository;
import com.anagracetech.backend.customer.Gender;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

    }

    @Bean
    CommandLineRunner runner(
            CustomerRepository customerRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            createRandomCustomer(customerRepository, passwordEncoder);
            // testBucketUploadAndDownload(s3Service, s3Buckets);
        };
    }

//    private static void testBucketUploadAndDownload(S3Service s3Service,
//                                                    S3Buckets s3Buckets) {
//        s3Service.putObject(
//                s3Buckets.getCustomer(),
//                "foo/bar/jamila",
//                "Hello World".getBytes()
//        );
//
//        byte[] obj = s3Service.getObject(
//                s3Buckets.getCustomer(),
//                "foo/bar/jamila"
//        );
//
//        System.out.println("Hooray: " + new String(obj));
//    }

    private static void createRandomCustomer(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        var faker = new Faker();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            int age = random.nextInt(16, 99);
            Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@anagraceTech.com";
            Customer customer = new Customer(
                    firstName +  " " + lastName,
                    email,
                    passwordEncoder.encode("password"),
                    age,
                    gender);
            customerRepository.save(customer);
        }
    }


}
