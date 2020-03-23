package service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class People {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String profession;

    public People() {
    }

    public People(String firstName, String lastName, String patronymic, String profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.profession = profession;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people = (People) o;
        return firstName.equals(people.firstName) &&
                lastName.equals(people.lastName) &&
                patronymic.equals(people.patronymic) &&
                profession.equals(people.profession);
    }

    @Override
    public String toString() {
        return "People{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
