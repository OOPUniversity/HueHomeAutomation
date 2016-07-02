package com.jdluke.home_automation.services;

import com.jdluke.home_automation.config.AppConfiguration;
import com.jdluke.home_automation.interfaces.HubLookup;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * Created by OOPUniversity on 6/24/2016.
 */
public class HubDiscoveryService implements HubLookup {
    private AppConfiguration appConfiguration;
    public HubDiscoveryService(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public String getHubIpAddress() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(appConfiguration.getHubDiscoveryUrl()).request().get();
        return (String) response.getEntity();
    }

    public Response lookupHubInfo() {
        return Response.ok().entity(getHubIpAddress()).build();
    }
}
