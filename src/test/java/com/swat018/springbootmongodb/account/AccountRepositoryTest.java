package com.swat018.springbootmongodb.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByEmail() {
        Account account = new Account();
        account.setUsername("jinwoo");
        account.setEmail("swat018@gmail.com");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        assertThat(byId).isNotEmpty();
/*
        Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
        assertThat(byEmail).isNotEmpty();
        assertThat(byEmail.get().getUsername()).isEqualTo("jinwoo");
*/

    }
}


