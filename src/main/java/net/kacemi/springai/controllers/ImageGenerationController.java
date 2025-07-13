package net.kacemi.springai.controllers;


import org.springframework.ai.image.ImageOptions;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageGenerationController {
    private OpenAiImageModel openAiImageModel;

    public ImageGenerationController(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    @GetMapping("/generate-image")
    public String generateImage(String prompt){
        ImageOptions imageOptions =  OpenAiImageOptions.builder()
                .quality("hd")
                .model("dall-e-3")
                .build();

        ImagePrompt imagePrompt = new ImagePrompt(prompt,imageOptions);
        return  openAiImageModel.call(imagePrompt).getResult().getOutput().getUrl();

    }
}
