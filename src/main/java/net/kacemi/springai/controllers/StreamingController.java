package net.kacemi.springai.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StreamingController {
    private ChatClient chatClient;

    public StreamingController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/stream")
    public Flux<String> stream(String query) {
        return chatClient.prompt().system("for this you should answer in arabic, and verse from the quran, with a small explinaation , and make sure to tell the user what is quran and what is explination").user(query).stream().content();
    }

    @GetMapping("/nostream")
    public String nostream(String query) {
        return chatClient.prompt().system("for this you should answer in arabic, and verse from the quran, with a small explinaation , and make sure to tell the user what is quran and what is explination").user(query).call().content();
    }
}
