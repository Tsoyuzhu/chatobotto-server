package com.tsoyuzhu.chatobotto.service;

import com.tsoyuzhu.chatobotto.domain.ChatHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChatHandleService {

    private static final String HANDLES_FILE_NAME = "handles.txt";

    private List<ChatHandle> handles;

    SessionManager sessionManager;

    @Autowired
    public ChatHandleService(SessionManager sessionManager) throws IOException {
        // Get list of possible handles from file
        List<String> allHandles = Files.readAllLines(Paths.get(String.format("src/main/resources/%s",HANDLES_FILE_NAME)));
        this.handles = allHandles.stream().map(ChatHandle::new).collect(Collectors.toList());
        this.sessionManager = sessionManager;
    }

    public ChatHandle getRandomHandle() {
        Random rand = new Random();
        // Filter out handles which are currently in use
        Collection<ChatHandle> existingHandles = sessionManager.getHandlesInUse();
        List<ChatHandle> filtered = handles.stream().
                filter(h -> !existingHandles.contains(h))
                .collect(Collectors.toList());
        return filtered.get(rand.nextInt(filtered.size()));
    }

    public List<ChatHandle> getHandles() {
        return handles;
    }

    public void setHandles(List<ChatHandle> handles) {
        this.handles = handles;
    }
}
