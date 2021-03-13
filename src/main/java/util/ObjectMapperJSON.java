package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ObjectMapperJSON {
    ObjectMapper objectMapper = new ObjectMapper();

    public <T> T readMapperObjectToPath(String path,Class<T> object) throws IOException {
        return objectMapper.readValue(new File(path),object);
    }
}
