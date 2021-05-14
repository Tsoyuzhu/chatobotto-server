package com.tsoyuzhu.chatobotto.service;

import com.tsoyuzhu.chatobotto.domain.ChatHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SessionManager {

    @Value("${configuration.chatroom_capacity:25}")
    private int chatroomCapacity;

    // This class tracks the existing chatroom connections
    private Map<String,ChatHandle> connections = new HashMap<>();

    private static final Logger LOG = LoggerFactory.getLogger(SessionManager.class);

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
        // Use Simp to parse the connection message
        SimpMessageHeaderAccessor headers =  SimpMessageHeaderAccessor.wrap(event.getMessage());
        LOG.info("CONNECTED!");
        LOG.info(headers.getSessionId());

        // The user has established a connection but is not registered to the chat room. This connection will be terminated if the chat room is full
        // We do not have the chatHandle at this point. We will set it below when the user subscribes to the chatHandle topic
        connections.put(headers.getSessionId(), null);
    }

    @EventListener
    private void handleSessionDisconnected(SessionDisconnectEvent event) {
        SimpMessageHeaderAccessor headers =  SimpMessageHeaderAccessor.wrap(event.getMessage());
        LOG.info("DISCONNECTED!");
        LOG.info(headers.getSessionId());

        connections.remove(headers.getSessionId());
    }

    public void registerSession(String sessionId, ChatHandle handle) throws Exception {
        // Associate the user handle with the session so we can determine when the nickname is available to be reassigned
        if (connections.size() > chatroomCapacity) {
            connections.remove(sessionId);
            throw new Exception("Cannot connect. Chat room is at maximum capacity.");
        } else {
            // Register handle associated with session Id
            connections.put(sessionId, handle);
        }
    }

    public Collection<ChatHandle> getHandlesInUse() {
        return connections.values();
    }
}

