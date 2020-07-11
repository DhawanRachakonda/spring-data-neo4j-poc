package com.data.neo4j.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostConversationDTO {

    private String ticketId;
    private String message;
    private List<String> attachments;
}
