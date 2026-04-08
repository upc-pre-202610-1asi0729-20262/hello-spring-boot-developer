package com.acme.hello.platform.generic.interfaces.rest.assemblers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Assembler class to convert a {@link GreetDeveloperRequest} into a {@link Developer} entity.
 * @version 1.0.0
 */
public class DeveloperAssembler {

    /**
     * Converts a {@link GreetDeveloperRequest} into a {@link Developer} entity.
     * @param request   the request object containing the developer's information.
     * @return          a {@link Developer} entity populated with the information from the request, or null if the request is invalid.
     */
    public static Developer toEntityFromRequest(GreetDeveloperRequest request) {
        if (ObjectUtils.isEmpty(request) || StringUtils.isAnyBlank(request.firstName(), request.lastName()))
            return null;
        return Developer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();
    }
}
