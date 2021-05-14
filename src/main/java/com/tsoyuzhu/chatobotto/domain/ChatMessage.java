package com.tsoyuzhu.chatobotto.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage {

    private String message;
    private String timestamp;
    private String creator;
    private String colorCode;
    private EnumChatMessageType type;

    public ChatMessage(String message, String creator, EnumChatMessageType type) {
        this.message = message;
        this.creator = creator;
        this.type = type;
        this.timestamp = formatTime(new Date());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public EnumChatMessageType getType() {
        return type;
    }

    public void setType(EnumChatMessageType type) {
        this.type = type;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    private String formatTime(Date date) {
        // We can use Jackson annotation for this but we can also
        // do it manually to keep the application lightweight
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        return sdf.format(date).toString();
    }
}
