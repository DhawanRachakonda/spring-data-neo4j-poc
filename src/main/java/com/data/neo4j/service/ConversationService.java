package com.data.neo4j.service;

import com.data.neo4j.dto.PostConversationDTO;
import com.data.neo4j.dto.PostConversationResponseDTO;
import com.data.neo4j.dto.PostMessageDTO;
import com.data.neo4j.dto.PostMessageResponseDTO;
import com.data.neo4j.entities.Conversation;
import com.data.neo4j.entities.Message;
import com.data.neo4j.repositories.ConversationRepository;
import com.data.neo4j.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public ConversationService(final ConversationRepository conversationRepository,
                               final MessageRepository messageRepository) {
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
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

    public PostMessageResponseDTO postMessage(PostMessageDTO postMessageDTO) {
        Optional<Conversation> optionalConversation = this.conversationRepository
                .findByTicketId(postMessageDTO.getTicketId());
        Conversation conversation = optionalConversation.orElseThrow(() -> new RuntimeException("Invalid id"));
        Message previousMessage = conversation.getMessages().last();

        Message latestMessage = Message.builder()
                .content(postMessageDTO.getMessage())
                .attachments(postMessageDTO.getAttachments())
                .createdAt(LocalDateTime.now())
                .build();

        this.messageRepository.save(latestMessage);

        previousMessage.setMessage(latestMessage);

        conversation.getMessages().add(latestMessage);

        this.conversationRepository.save(conversation);

        return PostMessageResponseDTO.builder()
                .conversationId(conversation.getConversationId())
                .linkedMessageId(latestMessage.getMessageId())
                .build();

    }
}
