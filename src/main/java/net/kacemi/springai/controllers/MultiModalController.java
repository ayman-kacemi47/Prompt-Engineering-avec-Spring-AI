package net.kacemi.springai.controllers;

import net.kacemi.springai.outputs.CarteNationaleMarocaineResponse;
import net.kacemi.springai.outputs.SchengenVisaResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MultiModalController {
    ChatClient chatClient;

    public MultiModalController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping(value = "/multi-modal/cin-marocaine-ocr", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CarteNationaleMarocaineResponse multiModalCin(String query, @RequestParam(name = "file") MultipartFile file) {
        return chatClient.prompt().system("""
                Le client doit partagé une carte d'identité marocaine, et tu dois extraire les infos.
                Si le document ne correspond pas une carte marocine, extrait les infos partagé mais indique lui que sera mieux de partagé  CIN marocaine
                """)



                .user(u->
                        {
                            try {
                                u.text(query)
                                        .media(MediaType.IMAGE_JPEG,    new ByteArrayResource(file.getBytes()));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        ).call().entity(CarteNationaleMarocaineResponse.class);
    }

    @PostMapping(value = "/multi-modal/schengen-visa-ocr", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SchengenVisaResponse multiModalSchengen(String query, @RequestParam(name = "file") MultipartFile file) {
        return chatClient.prompt().system("""
                Le client doit partagé une visa schengen, et tu dois extraire les infos.
                Si le document ne correspond pas une visa schengen, extrait les infos partagé mais indique lui que sera mieux de partagé  visa schengen
                """)
                .user(u->
                        {
                            try {
                                u.text(query)
                                        .media(MediaType.IMAGE_JPEG,    new ByteArrayResource(file.getBytes()));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        ).call().entity(SchengenVisaResponse.class);
    }

}
