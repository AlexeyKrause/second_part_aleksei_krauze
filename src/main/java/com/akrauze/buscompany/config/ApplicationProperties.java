package com.akrauze.buscompany.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties
public class ApplicationProperties {
    int maxNameLength;
    int minPasswordLength;
    int user_idle_timeout;
}