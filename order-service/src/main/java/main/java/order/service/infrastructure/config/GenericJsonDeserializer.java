package main.java.order.service.infrastructure.config;

import java.io.IOException;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import main.java.order.service.domain.model.OrderProduct;

@Slf4j
public class GenericJsonDeserializer implements Deserializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Configuration (if needed)
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        try {
            log.info("DESERIALIZATION INITIATED!!");
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(data, OrderProduct.class);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing message", e);
        }
    }

    @Override
    public void close() {
        // Clean up resources if needed
    }
}
