package com.data.neo4j.web;

import com.data.neo4j.ConversationService;
import com.data.neo4j.dto.PostConversationResponseDTO;
import com.data.neo4j.dto.PostMessageDTO;
import com.data.neo4j.dto.PostMessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final ConversationService conversationService;

    @Autowired
    public MessageController(final ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/")
    public ResponseEntity<?> postMessage(@RequestBody PostMessageDTO postMessage) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.conversationService.postMessage(postMessage));
    }
}
