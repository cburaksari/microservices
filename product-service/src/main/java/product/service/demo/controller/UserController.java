package product.service.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import product.service.demo.models.ProductUser;
import product.service.demo.repository.UserRepository;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Transactional
    @KafkaListener(topics = "user-topic", groupId = "product-consumer")
    public void handleUserCreatedEvent(JsonNode userCreatedEvent) {
        logger.info("Received user event from Kafka: {}", userCreatedEvent);

        Long userId = userCreatedEvent.get("userId").asLong();
        String username = userCreatedEvent.get("username").asText();
        String email = userCreatedEvent.get("email").asText();
        userRepository.save(
                new ProductUser(userId, username, email));
    }
}
