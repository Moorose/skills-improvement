package data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import service.People;

@JsonSerialize
public class TestData {

    People[] people;
    String[] professions;

    public TestData() {
    }

    public TestData(People[] people, String[] professions) {
        this.people = people;
        this.professions = professions;
    }

    public People[] getPeople() {
        return people;
    }

    public void setPeople(People[] people) {
        this.people = people;
    }

    public String[] getProfessions() {
        return professions;
    }

    public void setProfessions(String[] professions) {
        this.professions = professions;
    }

    @Override
    public String toString() {
        return "data.TestData{\n" +
                "people=" + people +
                ",\n professions=" + professions +
                '}';
    }
}
