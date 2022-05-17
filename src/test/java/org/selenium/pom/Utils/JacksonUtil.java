package org.selenium.pom.Utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtil {

    public static <T> T deserialize(String filename,Class<T> T) throws IOException {
        InputStream is=JacksonUtil.class.getClassLoader().getResourceAsStream(filename);
        ObjectMapper objectMapper=new ObjectMapper().
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return objectMapper.readValue(is,T);
    }
}
