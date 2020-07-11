package com.data.neo4j.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostMessageResponseDTO {

    private Long messageId;
    private Long conversationId;
    private Long linkedMessageId;
}
