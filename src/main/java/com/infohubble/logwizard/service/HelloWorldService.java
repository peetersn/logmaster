package com.infohubble.logwizard.service;

import com.infohubble.logwizard.configuration.HelloWorldConfiguration;
import com.infohubble.logwizard.health.TemplateHealthCheck;
import com.infohubble.logwizard.resources.HelloWorldResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;

public class HelloWorldService extends Service<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    private HelloWorldService() {
        super("hello-world");
    }

    @Override
    protected void initialize(HelloWorldConfiguration configuration, Environment environment) {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }

}