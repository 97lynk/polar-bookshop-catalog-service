package com.polarbookshop.catalogservice;

import com.polarbookshop.catalogservice.config.PolarProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HomeController {

    private final PolarProperties polarProperties;

    private final Environment environment;

    public HomeController(PolarProperties polarProperties, Environment environment) {
        this.polarProperties = polarProperties;
        this.environment = environment;
    }

    @GetMapping("/")
    public String getGreeting() {
        return polarProperties.getGreeting();
    }
}
