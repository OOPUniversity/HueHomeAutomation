package com.jdluke.home_automation.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by OOPUniversity on 6/24/2016.
 */
@Component
@Path("/manage")
@Consumes({"application/json"})
@Produces({"application/json"})
@Api("HomeAutomation")
public interface HubLookup {
    @GET
    @ApiOperation("lookupHubInfo")
    Response lookupHubInfo();
}
