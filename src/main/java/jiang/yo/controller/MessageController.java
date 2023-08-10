package jiang.yo.controller;

import jiang.yo.config.MessagePublisher;
import jiang.yo.dto.query.MessageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessagePublisher messagePublisher;

    public MessageController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody MessageRequest messageRequest) {
        String channel = messageRequest.getChannel();
        String message = messageRequest.getMessage();

        messagePublisher.publishMessage(channel, message);
        return "Message published to channel " + channel + " successfully!";
    }
}

