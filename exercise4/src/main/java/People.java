import java.util.Objects;

public class People {
    private String firstName;

    public People(String firstName, String lastName, String patronymic, Profession profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.profession = profession;
    }

    private String lastName;
    private String patronymic;
    private Profession profession;

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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people = (People) o;
        return Objects.equals(firstName, people.firstName) &&
                Objects.equals(lastName, people.lastName) &&
                Objects.equals(patronymic, people.patronymic) &&
                Objects.equals(profession, people.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, profession);
    }
}
