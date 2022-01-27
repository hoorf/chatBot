package org.github.hoorf.controller;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.github.hoorf.ai.LacClient;
import org.github.hoorf.ai.LacRequest;
import org.github.hoorf.ai.LacResponse;
import org.github.hoorf.context.ChatContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ChatController {

    @Autowired
    private LacClient lacClient;

    @PostMapping("/chat")
    public Response chat(@RequestBody String content){
        ChatContext chatContext = new ChatContext();
        LacResponse response = lacClient.request(new LacRequest(UUID.randomUUID().toString(), content.trim()));
        return SingleResponse.of(chatContext.input(response));
    }
}
