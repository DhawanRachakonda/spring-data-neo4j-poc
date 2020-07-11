package com.data.neo4j;

import com.data.neo4j.dto.PostConversationDTO;
import com.data.neo4j.dto.PostConversationResponseDTO;
import com.data.neo4j.entities.Conversation;
import com.data.neo4j.entities.Message;
import com.data.neo4j.repositories.ConversationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    public ConversationService(final ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public PostConversationResponseDTO createConversation(PostConversationDTO conversationDTO) {
        Message message = Message.builder()
                .attachments(conversationDTO.getAttachments())
                .content(conversationDTO.getMessage())
                .createdAt(LocalDateTime.now())
                .build();

        SortedSet<Message> messages = new TreeSet();
        messages.add(message);

        Conversation conversation = Conversation.builder()
                .createdAt(LocalDateTime.now())
                .ticketId(conversationDTO.getTicketId())
                .messages(messages)
                .build();
        Conversation postConversation = this.conversationRepository.save(conversation);

        return PostConversationResponseDTO.builder()
                .id(postConversation.getConversationId())
                .message(postConversation.getMessages().first().getMessage().getContent())
                .ticketId((postConversation.getTicketId())).build();
    }
}
