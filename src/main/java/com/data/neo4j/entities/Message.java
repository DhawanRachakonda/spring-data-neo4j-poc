package com.data.neo4j.entities;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@NodeEntity(label = "Message")
@Data
@Builder
public class Message implements Comparable<Message> {

    @Id
    @GeneratedValue
    @Property(name="message-id")
    private Long messageId;
    private String content;
    @Relationship(type = "HAS_ATTACHMENTS")
    private List<String> attachments;
    @Relationship(type = "IS_LINKED_TO")
    private Message message;
    @Property("created_at")
    private LocalDateTime createdAt;

    @Override
    public int compareTo(Message o) {
        return this.getCreatedAt().isBefore(o.getCreatedAt()) ? -1 : 1;
    }
}
