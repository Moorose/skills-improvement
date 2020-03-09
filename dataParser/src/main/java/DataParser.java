import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataParser<T> {

    void writeData(File filePath, T object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(filePath, object);

        String jsonString = mapper.writeValueAsString(object);
        System.out.println(jsonString);

        String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        System.out.println(jsonInString2);

    }

    T getData(File filePath) {
        T object = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            object = mapper.readValue(filePath, T.class);

            System.out.println(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

}
