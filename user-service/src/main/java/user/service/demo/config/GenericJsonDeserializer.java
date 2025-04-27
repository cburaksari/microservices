package user.service.demo.config;

import java.io.IOException;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericJsonDeserializer implements Deserializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        try {
            JsonNode jsonNode = objectMapper.readTree(data);
            return jsonNode;
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing message", e);
        }
    }

    @Override
    public void close() {
    }
}
