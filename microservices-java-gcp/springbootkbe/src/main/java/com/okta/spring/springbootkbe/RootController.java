package com.okta.spring.springbootkbe;

/*
RootController is required because k8s performs health checks on the root endpoint of our services
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
public class RootController {

    @GetMapping("/")
    @ResponseBody
    public Flux<String> getRoot() {
        return Flux.just("Alive");
    }
}
