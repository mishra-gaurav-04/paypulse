package com.micronids.paypulse.shared.exceptions.exception;

import com.micronids.paypulse.shared.constants.AppConstants;

public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final Object identifier;

    public ResourceNotFoundException(String resourceName,Object identifier) {
        super(resourceName + AppConstants.NOT_FOUND + identifier);
        this.resourceName = resourceName;
        this.identifier = identifier;
    }
}
