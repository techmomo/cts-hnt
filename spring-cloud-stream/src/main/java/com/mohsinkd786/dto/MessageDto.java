package com.mohsinkd786.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String key;
    private List<String> messages = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
