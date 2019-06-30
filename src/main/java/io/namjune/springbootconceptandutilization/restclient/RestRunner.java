package io.namjune.springbootconceptandutilization.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    WebClient.Builder builder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        WebClient webClient = builder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 이 라인이 실행되도 아무런 동작을 하지 않는다.
        Mono<String> hiMono = webClient.get().uri("http://localhost:8080/hi")
            .retrieve()
            .bodyToMono(String.class);

        // subscribe를 해줘야 스트리밍이 일어난다.
        hiMono.subscribe(hiResult -> {
            log.info("/hi API Result : " + hiResult);

            // Asynchronus 이므로 어느것이 먼저 끝날지 모른다. 스탑워치가 돌고있으면 멈추고,
            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }

            // 로그를 찍고, 스탑워치를 다시 돌려줘야 한다. Asynchronus 이므로 순서보장이 안되기 때문에.
            log.info(stopWatch.prettyPrint());
            stopWatch.start();
        });

        Mono<String> byeMono = webClient.get().uri("http://localhost:8080/bye")
            .retrieve()
            .bodyToMono(String.class);

        byeMono.subscribe(byeResult -> {
            log.info("/bye API Result : " + byeResult);

            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }

            log.info(stopWatch.prettyPrint());
            stopWatch.start();
        });
    }
}
