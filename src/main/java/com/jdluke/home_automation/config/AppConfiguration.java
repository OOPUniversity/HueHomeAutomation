package com.jdluke.home_automation.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Created by OOPUniversity on 6/24/2016.
 */
public class AppConfiguration extends Configuration {
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @JsonProperty("hubDiscoveryUrl")
    public String getHubDiscoveryUrl() {
        return hubDiscoveryUrl;
    }

    private String hubDiscoveryUrl;

}
