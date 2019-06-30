package io.namjune.springbootconceptandutilization.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String hiResult = restTemplate.getForObject("http://localhost:8080/hi", String.class);
        log.info("/hi API Result : " + hiResult);

        String byeResult = restTemplate.getForObject("http://localhost:8080/bye", String.class);
        log.info("/bye API Result : " + byeResult);

        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }
}
