package dataparser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataParser<T> {

    public void writeData(File filePath, T object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(filePath, object);
//
//        String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
//        System.out.println(jsonInString2);

    }

    public <T> T readData(File filePath, Class<T> valueType) {
        T object = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            object = mapper.readValue(filePath, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

}
