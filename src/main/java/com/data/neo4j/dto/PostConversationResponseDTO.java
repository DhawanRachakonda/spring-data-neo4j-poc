package com.data.neo4j.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostConversationResponseDTO {

    private Long id;
    private String message;
    private String ticketId;
}
