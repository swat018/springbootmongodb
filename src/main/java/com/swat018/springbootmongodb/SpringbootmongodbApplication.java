package com.swat018.springbootmongodb;

import com.swat018.springbootmongodb.account.Account;
import com.swat018.springbootmongodb.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootmongodbApplication {

//    @Autowired
//    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmongodbApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return  args -> {
            Account account = new Account();
            account.setEmail("swat018@gmail.com");
            account.setUsername("jinwoo");
            accountRepository.insert(account);

            System.out.println("finished");
        };
    }

}
