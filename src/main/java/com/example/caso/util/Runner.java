package com.example.caso.util;

import com.example.caso.entities.Roles;
import com.example.caso.entities.Useror;
import com.example.caso.repositories.ITypeUserRepository;
import com.example.caso.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    private final IUserRepository userRepository;
    private final ITypeUserRepository typeUserRepository;

    public Runner(IUserRepository userRepository, ITypeUserRepository typeUserRepository) {
        this.userRepository = userRepository;
        this.typeUserRepository = typeUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Useror useror = new Useror();
        useror.setUserName("ADMIN");
        useror.setUserPassword("$2a$12$kfo6Az5ZfFRSoY9WMJAASeXycMsPVPhLlzCsJ4TwU3WDPUlio694C");
        useror.setUserEmail("admin@gmail.com");
        useror.setUserAge(LocalDate.ofEpochDay(20020905));
        useror.setEnabled(true);
        userRepository.save(useror);

        Roles roles = new Roles();
        roles.setStateType(true);
        roles.setTypeAccount("Administrativos");
        roles.setUseror(useror);
        typeUserRepository.save(roles);

        Useror useror2 = new Useror();
        useror2.setUserName("WEB");
        useror2.setUserPassword("$2a$12$kfo6Az5ZfFRSoY9WMJAASeXycMsPVPhLlzCsJ4TwU3WDPUlio694C");
        useror2.setUserEmail("WEB@gmail.com");
        useror2.setUserAge(LocalDate.ofEpochDay(20020904));
        useror2.setEnabled(true);
        userRepository.save(useror2);

        Roles roles2 = new Roles();
        roles2.setStateType(true);
        roles2.setTypeAccount("Tecnicos");
        roles2.setUseror(useror2);
        typeUserRepository.save(roles2);
    }
}
