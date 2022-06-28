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
    int max_name_length;
    int min_password_length;
    int user_idle_timeout;
}