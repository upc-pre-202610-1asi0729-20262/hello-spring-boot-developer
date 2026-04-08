package com.acme.hello.platform.generic.interfaces.rest.assemblers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperResponse;
import org.apache.commons.lang3.ObjectUtils;

public class GreetDeveloperAssembler {
    public static GreetDeveloperResponse toResourceFromEntity(Developer entity) {
        if (isDeveloperNullOrEmptyNamed(entity))
            return new GreetDeveloperResponse("Welcome Anonymous Spring Boot Developer");
        return new GreetDeveloperResponse(entity.getId(), entity.getFullName(),
                "Congrats " + entity.getFullName() + "! You are a Spring Boot Developer");
    }

    private static boolean isDeveloperNullOrEmptyNamed(Developer developer) {
        return ObjectUtils.isEmpty(developer) ||
                developer.isAnyNameEmpty() ||
                developer.isAnyNameBlank();
    }
}
