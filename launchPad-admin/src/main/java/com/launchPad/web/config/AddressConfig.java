package com.launchPad.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/8/25  15:02
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "address")
public class AddressConfig {

    private String generateAddress;

    private String wnuls;


}
