package com.tsoyuzhu.chatobotto.resource;

import com.tsoyuzhu.chatobotto.domain.ChatMessage;
import com.tsoyuzhu.chatobotto.domain.ConnectionRequest;
import com.tsoyuzhu.chatobotto.service.ChatroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatroomController {

    private static final Logger LOG = LoggerFactory.getLogger(ChatroomController.class);

    private static final String SIMP_SESSION_ID_HEADER_KEY = "simpSessionId";

    private List<ChatMessage> chatLogs = new ArrayList<>();

    @Autowired
    private ChatroomService chatroomService;

    // Send a randomised chatHandle upon connecting
    @SubscribeMapping("/getHandle")
    public ConnectionRequest getHandle(@Header(SIMP_SESSION_ID_HEADER_KEY) String sessionId) {
        try {
            return chatroomService.getHandle(sessionId);
        } catch (Exception e) {
            // Exception is thrown if the chat room is full
            LOG.info(e.getMessage());
            return null;
        }
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/allYourWeabooFriends")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }
}
