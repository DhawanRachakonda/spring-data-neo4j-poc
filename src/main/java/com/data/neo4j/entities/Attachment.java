package com.data.neo4j.entities;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "Attachment")
@Data
@Builder
public class Attachment {

    @Id
    @GeneratedValue
    @Property(name="attachment_id")
    private Long attachmentId;
    private String url;
    private String key;
}
