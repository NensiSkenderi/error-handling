package com.nensi.superheroes.controller.errors;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/*
We want to avoid creating exception handlers
for each exception in Java so let’s
see how we can override the defaults
in Spring Boot to customize the REST API error format returned.
 */
public class SuperHeroAppErrorAttributes extends DefaultErrorAttributes {

    private final String currentApiVersion;
    private final String sendUrlReport;

    public SuperHeroAppErrorAttributes(final String currentApiVersion, final String sendUrlReport) {
        this.currentApiVersion = currentApiVersion;
        this.sendUrlReport = sendUrlReport;
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        final Map<String, Object> defaultErrorAttributes = super.getErrorAttributes(webRequest, false);
        final ErrorResponse errorResponse = ErrorResponse.fromDefaultAttributeMap(
                currentApiVersion, defaultErrorAttributes, sendUrlReport
        );
        return errorResponse.toAttributeMap();
    }


    /*
    What we’re doing here is a kind of wrapper
    that overrides the default implementation
    of getErrorAttributes and replaces the
    default values by our own ones, using the
    mapper method we created in ErrorResponse.
    Note that the method signature in the
    interface ErrorAttributes requires us
    to return a Map; that’s why we created
    that method toAttributeMap() in ErrorResponse
    instead of serializing the complete object in JSON.
     */
}
