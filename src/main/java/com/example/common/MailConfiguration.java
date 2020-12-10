package com.example.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 問合せに対してメールを送付する際使用する情報.
 *
 */
@Component
@ConfigurationProperties(prefix="mailtouser")
@Data
public class MailConfiguration {

    private String mailAddress;
}
