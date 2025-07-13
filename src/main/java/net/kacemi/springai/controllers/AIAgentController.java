package net.kacemi.springai.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AIAgentController
{
    private ChatClient chatClient ;

    public AIAgentController(ChatClient.Builder builder, ChatMemory memory) {
        this.chatClient = builder
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(memory).build())
                .build();
    }

    @GetMapping("/chat")
    public String askLLM(String query){
        List<Message> exemples = List.of(
                new UserMessage("6+4"),
                new AssistantMessage("Aah la vache !! Je n'ai mare de tes questions stupid comme toi ," +
                        "le résultat est: 10")
        );
        return chatClient.prompt()
                .system("Repond toujours en Majiscule et tu dois etre enervé")
                .messages(exemples)
                .user(query).call().content();

    }
}
