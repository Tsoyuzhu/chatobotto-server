package com.tsoyuzhu.chatobotto.domain;

public class ConnectionRequest {

    private boolean connectionSuccessful;

    private ChatHandle chatHandle;

    public ConnectionRequest(boolean connectionSuccessful, ChatHandle chatHandle) {
        this.connectionSuccessful = connectionSuccessful;
        this.chatHandle = chatHandle;
    }

    public boolean isConnectionSuccessful() {
        return connectionSuccessful;
    }

    public void setConnectionSuccessful(boolean connectionSuccessful) {
        this.connectionSuccessful = connectionSuccessful;
    }

    public ChatHandle getChatHandle() {
        return chatHandle;
    }

    public void setChatHandle(ChatHandle chatHandle) {
        this.chatHandle = chatHandle;
    }
}
