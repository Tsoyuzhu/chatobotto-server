package com.tsoyuzhu.chatobotto.domain;

public class ChatroomCapacity {
    private int capacity;
    private int currentMembers;

    public ChatroomCapacity(int capacity, int currentMembers) {
        this.capacity = capacity;
        this.currentMembers = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentMembers() {
        return currentMembers;
    }

    public void setCurrentMembers(int currentMembers) {
        this.currentMembers = currentMembers;
    }
}
