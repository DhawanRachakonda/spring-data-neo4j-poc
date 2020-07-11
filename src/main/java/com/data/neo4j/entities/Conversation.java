package com.data.neo4j.entities;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.SortedSet;

@NodeEntity
@Data
@Builder
public class Conversation {
    @Id
    @GeneratedValue
    @Property(name="conversation_id")
    private Long conversationId;
    @Property(name="ticket_id")
    private String ticketId;
    @Property("created_by")
    private String createdBy;
    @Property("created_at")
    private LocalDateTime createdAt;
    @Relationship(type = "CONTAINS_MESSAGES")
    private SortedSet<Message> messages;

}
