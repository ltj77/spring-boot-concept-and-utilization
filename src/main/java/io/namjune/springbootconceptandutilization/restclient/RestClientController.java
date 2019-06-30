package io.namjune.springbootconceptandutilization.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {

    @GetMapping("/hi")
    public String hi() throws InterruptedException {
        Thread.sleep(5000L);
        return "hi";
    }

    @GetMapping("/bye")
    public String bye() throws InterruptedException {
        Thread.sleep(3000L);
        return "bye";
    }
}
