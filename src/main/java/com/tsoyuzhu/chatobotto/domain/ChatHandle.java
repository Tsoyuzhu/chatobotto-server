package com.tsoyuzhu.chatobotto.domain;

import java.util.Objects;

public class ChatHandle {

    private String handle;

    public ChatHandle(String handle) {
        this.handle = handle;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatHandle that = (ChatHandle) o;
        return handle.equals(that.handle);
    }
}
