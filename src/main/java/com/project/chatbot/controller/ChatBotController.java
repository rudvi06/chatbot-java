package com.project.chatbot.controller;

import com.project.chatbot.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@Controller
@RequestMapping(value = "/chat")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;

    @GetMapping("")
    public String home(){
        return "chat";
    }

    @PostMapping(value = "" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String home(@RequestParam Map<String,String> text){
        String response = text.get("messageText");
        System.out.println(response);
        response = chatBotService.chatBot(response);
        return response;
    }

}
