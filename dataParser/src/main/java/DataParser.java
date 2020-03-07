import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataParser {

    void setData(File filePath, ) throws IOException {}

    void getData(File filePath) throws IOException {
        String response = readData(filePath);

        if (response.isEmpty()) throw new IOException("We can`t find any data on this way: " + filePath.toString());
        ObjectMapper mapper = new ObjectMapper();
//        JsonNode rootNode = mapper.readValue("{\"message\":\"Hi\",\"place\":{\"name\":\"World!\"}}", JsonNode.class); // парсинг текста
//        String message = rootNode.get("message").asText(); // получение строки из поля "message"
//        JsonNode childNode = rootNode.get("place"); // получаем объект Place
//        String place = childNode.get("name").asText(); // получаем строку из поля "name"
//        System.out.println(message + " " + place); // напечатает "Hi World!"
    }

    private String readData(File filePath) {
        StringBuffer str = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String s;
            while ((s = br.readLine()) != null) {
                str.append(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str.toString();
    }

}
