package com.acme.hello.platform.generic.interfaces.rest.resources;

import java.util.UUID;

/**
 * REST resource representing Greet Developer response data.
 * @param id        the unique identifier of the greeting message.
 * @param fullName  the full name of the developer being greeted.
 * @param message   the greeting message to be sent to the developer.
 */
public record GreetDeveloperResponse(UUID id,String fullName, String message) {

    /**
     * Constructs a new GreetDeveloperResponse instance with the specified message, and generates a unique identifier for the greeting.
     * @param message   the greeting message to be sent to the developer.
     */
    public GreetDeveloperResponse(String message) {
        this(null, null, message);
    }
}
