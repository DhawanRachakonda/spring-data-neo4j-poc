package com.data.neo4j.repositories;

import com.data.neo4j.entities.Conversation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Long> {

    Optional<Conversation> findByTicketId(String ticketId);
}
