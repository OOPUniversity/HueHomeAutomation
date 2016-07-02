package com.jdluke.home_automation;

import com.jdluke.home_automation.config.AppConfiguration;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.Path;
import java.util.Map;

/**
 * Created by OOPUniversity on 6/24/2016.
 */
public class App extends Application<AppConfiguration> {
    public static void main(String [] args) throws Exception {
        App app = new App();
        app.run(args);
    }

    public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
        AnnotationConfigApplicationContext rootctx = new AnnotationConfigApplicationContext();
        rootctx.registerShutdownHook();
        rootctx.scan("com.jdluke.home_automation");
        rootctx.refresh();

        for(Map.Entry<String, Object> entry: rootctx.getBeansWithAnnotation(Path.class).entrySet()) {
            environment.jersey().register(entry.getValue());
        }
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<AppConfiguration>() {

            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(AppConfiguration appConfiguration) {
                return appConfiguration.swaggerBundleConfiguration;
            }
        });
    }
}
