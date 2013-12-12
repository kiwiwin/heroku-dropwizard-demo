package org.kiwi.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class HelloService extends Service<HelloConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloConfiguration> bootstrap) {
        bootstrap.setName("hello");
    }

    @Override
    public void run(HelloConfiguration configuration, Environment environment) throws Exception {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloResource(template, defaultName));
    }
}
