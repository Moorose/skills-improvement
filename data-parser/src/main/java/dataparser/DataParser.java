package dataparser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataParser<T> {

    public void writeData(File filePath, T object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(filePath, object);

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


    public static String readString(File filePath) {
        StringBuffer str = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String s;
            while ((s = br.readLine()) != null) {
                str.append(s);
                str.append('\n');
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str.toString();
    }
}
