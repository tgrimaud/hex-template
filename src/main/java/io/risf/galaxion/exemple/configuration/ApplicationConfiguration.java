package io.risf.galaxion.exemple.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class ApplicationConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfiguration.class);

    private final BuildProperties buildProperties;

    public ApplicationConfiguration(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }


}

