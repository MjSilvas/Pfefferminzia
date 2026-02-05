import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOError;
import java.io.IOException;
import java.nio.file.Path;

public class JsonLoader {
    ObjectMapper mapper = new ObjectMapper();

    public <T> T read(Path file, Class<T> type) {
        try {
            return mapper.readValue(file.toFile(), type);
        } catch (IOException e) {
            throw new JsonLoadingException("Konnte JSON nicht laden: " + file, e);
        }
    }

    public static final class JsonLoadingException extends RuntimeException {
        public JsonLoadingException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
