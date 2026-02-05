import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


public class JsonLoader {
    private ObjectMapper mapper = new ObjectMapper();


    public <T> List<T> readJson(Path jsonFile, Class<T> recordClass) {
        try {
            JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, recordClass);
            return mapper.readValue(jsonFile.toFile(), listType);
        } catch (IOException e) {
            throw new JsonLoadingException("Konnte JSON nicht laden: " + jsonFile, e);
        }
    }


    public static final class JsonLoadingException extends RuntimeException {
        public JsonLoadingException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
