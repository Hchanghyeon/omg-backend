package com.chang.omg.infrastructure.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.chang.omg.infrastructure.config.property.CorsProperties;
import com.chang.omg.infrastructure.config.property.MapleStoryMProperties;

@Configuration
@EnableConfigurationProperties(value = {MapleStoryMProperties.class, CorsProperties.class})
public class PropertyConfig {

}
