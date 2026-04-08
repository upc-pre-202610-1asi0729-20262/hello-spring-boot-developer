package com.acme.hello.platform.generic.interfaces.rest.controllers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.generic.interfaces.rest.assemblers.DeveloperAssembler;
import com.acme.hello.platform.generic.interfaces.rest.assemblers.GreetDeveloperAssembler;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperRequest;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingsController.class);

    @GetMapping
    public ResponseEntity<GreetDeveloperResponse> greetDeveloper(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        Developer developer = (Objects.isNull(firstName) || Objects.isNull(lastName))
                ? null
                : Developer.builder().firstName(firstName).lastName(lastName).build();
        LOGGER.info("Greeting request received: firstName: '{}', lastName: '{}'", firstName, lastName);
        GreetDeveloperResponse response = GreetDeveloperAssembler.toResourceFromEntity(developer);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GreetDeveloperResponse> createGreeting(
            @RequestBody GreetDeveloperRequest request) {
        Developer developer = DeveloperAssembler.toEntityFromRequest(request);
        GreetDeveloperResponse response = GreetDeveloperAssembler.toResourceFromEntity(developer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
