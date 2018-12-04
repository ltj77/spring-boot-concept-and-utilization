package io.namjune.springbootconceptandutilization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    NamjuneProperties namjuneProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==========================");
        System.out.println(namjuneProperties.getName());
        System.out.println(namjuneProperties.getAge());
        System.out.println(namjuneProperties.getFullName());
        System.out.println(namjuneProperties.getSessionTimeout());
        System.out.println("==========================");
    }
}
