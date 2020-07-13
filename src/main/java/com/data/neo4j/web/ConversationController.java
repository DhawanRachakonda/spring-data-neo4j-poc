package com.data.neo4j.web;

import com.data.neo4j.service.ConversationService;
import com.data.neo4j.dto.PostConversationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversation")
public class ConversationController {

    private final ConversationService conversationService;

    @Autowired
    public ConversationController(final ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveConversation(@RequestBody PostConversationDTO conversation) {
        return ResponseEntity
                .status(HttpStatus.CREATED).
                body(this.conversationService.createConversation(conversation));
    }
}
