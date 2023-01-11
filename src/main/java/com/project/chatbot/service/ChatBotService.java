package com.project.chatbot.service;

import org.alicebot.ab.*;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ChatBotService {

    public String chatBot(String text){
        String botName="super";
        String path=getResourcesPath();
        Bot bot = new Bot(botName,path);
        Chat chatSession = new Chat(bot);
        String request = text;
        String response = chatSession.multisentenceRespond(request);
        System.out.println(response);
        return response;
    }
    public String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }

}
