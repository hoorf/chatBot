package org.github.hoorf;

import org.github.hoorf.ai.LacClient;
import org.github.hoorf.ai.LacRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ChatBotApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ChatBotApplication.class, args);
    }
}
