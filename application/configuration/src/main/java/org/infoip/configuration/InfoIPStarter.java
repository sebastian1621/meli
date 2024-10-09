package org.infoip.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.infoip")
public class InfoIPStarter {

    // 83.44.196.93 Spain
    // 206.71.50.230 USA
    public static void main(String[] args) {
        SpringApplication.run(InfoIPStarter.class, args);
    }
}