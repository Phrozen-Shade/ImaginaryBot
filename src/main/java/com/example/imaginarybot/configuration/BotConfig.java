package com.example.imaginarybot.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "telegram")
public class BotConfig {
    String botUserName;
    String token;
}
