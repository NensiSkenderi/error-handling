package com.nensi.superheroes.controller.errors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Now, we can add a Configuration class to override the default bean.
@Configuration
public class WebErrorConfig {

    @Value("${superheroes.api.version}")
    private String currentApiVersion;

    /**
     * We override the default {@link org.springframework.boot.web.servlet.error.DefaultErrorAttributes}
     *
     * @return A custom implementation of ErrorAttributes
     */
    @Bean
    public ErrorAttributes errorAttributes() {
        return new SuperHeroAppErrorAttributes(currentApiVersion, "sendReportUri");
    }

    /*
    What happens now is that our own implementation
    of ErrorAttributes is being injected in the context and used to build the error response
     */
}
