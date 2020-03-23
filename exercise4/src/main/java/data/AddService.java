package data;

import dataparser.DataParser;
import service.People;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddService {

    static void writeData() throws IOException {
        ArrayList<People> people = new ArrayList<>();
        ArrayList<String> professions = new ArrayList<>();

        professions.add("Аналитик данных");
        professions.add("Медицинский специалист");
        professions.add("Физиотерапевт");
        professions.add("Специалист по продажам и маркетингу");
        professions.add("Клиентский менеджер");
        professions.add("Консультант по менеджменту предприятий");
        professions.add("Разработчик программного обеспечения");
        professions.add("Ветеринар");
        professions.add("Создатель и дизайнер продуктов");
        professions.add("Учитель");
        professions.add("Преподаватель");
        professions.add("Репетитор");
        professions.add("Тренер");
        professions.add("Бухгалтер");
        professions.add("Аудитор");

        people.add(new People("FN1", "LN1", "PT1", professions.get(1)));
        people.add(new People("FN2", "LN2", "PT2", professions.get(1)));
        people.add(new People("FN3", "LN3", "PT3", professions.get(2)));
        people.add(new People("FN4", "LN4", "PT4", professions.get(2)));
        people.add(new People("FN5", "LN5", "PT5", "Random_Prof_Name"));
        people.add(new People("FN6", "LN6", "PT6", professions.get(4)));

        TestData testData = new TestData(people.toArray(new People[people.size()]), professions.toArray(new String[professions.size()]));
        File filePath = new File("./exercise4/res/testdata.json");
        DataParser dataParser = new DataParser();

        dataParser.writeData(filePath, testData);
    }
}
