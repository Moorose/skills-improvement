import directionallist.OneWayList;

import java.io.File;
import java.util.Arrays;

public class MockController {

    private TestData response = null;

    public MockController() {
        File filePath = new File("./exercise4/res/testdata.json");
        DataParser<TestData> dataParser = new DataParser();

        response = dataParser.readData(filePath, TestData.class);
    }

    public OneWayList<People> getPeople() {
        OneWayList<People> oneWayList = new OneWayList<>();
        Arrays.stream(response.people).forEach(oneWayList::add);
        return oneWayList;
    }

    public OneWayList<String> getProfessions() {
        OneWayList<String> oneWayList = new OneWayList<>();
        Arrays.stream(response.professions).forEach(oneWayList::add);
        return oneWayList;
    }

}
