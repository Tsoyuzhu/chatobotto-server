package com.tsoyuzhu.chatobotto.service;

import com.tsoyuzhu.chatobotto.domain.ChatHandle;
import com.tsoyuzhu.chatobotto.domain.ConnectionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatroomService {

    private ChatHandleService chatHandleService;

    private SessionManager sessionManager;

    private static final Logger LOG = LoggerFactory.getLogger(ChatroomService.class);

    @Autowired
    public ChatroomService(ChatHandleService chatHandleService, SessionManager sessionManager ) {
        this.chatHandleService = chatHandleService;
        this.sessionManager = sessionManager;
    }

    public ConnectionRequest getHandle(String sessionId) {
            try {
                ChatHandle randomisedHandle = chatHandleService.getRandomHandle();
                sessionManager.registerSession(sessionId, randomisedHandle);
                return new ConnectionRequest(true, randomisedHandle);
            } catch (Exception e) {
                return new ConnectionRequest(false, null);
            }
    }
}
