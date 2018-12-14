package io.namjune.springbootconceptandutilization.sample;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    private final SampleService sampleService;

    @GetMapping("/hello")
    public String hello() {
        logger.info("hello logger");
        System.out.println("hello sout");
        return "hello " + sampleService.getName();
    }
}
