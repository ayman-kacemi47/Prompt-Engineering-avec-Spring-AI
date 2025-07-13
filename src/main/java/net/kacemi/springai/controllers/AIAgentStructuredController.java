package net.kacemi.springai.controllers;

import net.kacemi.springai.outputs.MovieList;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIAgentStructuredController {
    private ChatClient chatClient;

    public AIAgentStructuredController(ChatClient.Builder builder, ChatMemory memory) {
        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(memory).build())
                .build();
    }

    @GetMapping("/askAgent")
    public MovieList askLLM(String query) {
        return  chatClient.prompt()

                .system("""
                        vous êtes un spécialiste dans le domaine de cinéma, reponds la question d'utilisateur a ce propos
                        et merci de repondre en arabe
                        """)
                .user(query).call().entity(MovieList.class);
    }
}
