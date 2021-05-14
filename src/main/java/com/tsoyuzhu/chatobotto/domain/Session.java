package com.tsoyuzhu.chatobotto.domain;

public class Session {
    private String sessionId;

    // Chat handle of user that established the connection
    private String chatHandle;

    public Session(String sessionId, String chatHandle) {
        this.sessionId = sessionId;
        this.chatHandle = chatHandle;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getChatHandle() {
        return chatHandle;
    }

    public void setChatHandle(String chatHandle) {
        this.chatHandle = chatHandle;
    }
}
