package geekbrains.final_task.model;

/*
класс, описание пользователя
 */
public class User {

    private String firstName;
    private String lastName;
    private String middleName;
    private String birthday;
    private long phone;
    private char sex;

    public User(String firstName, String lastName, String middleName, String birthday, long phone, char sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.phone = phone;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getPhone() {
        return phone;
    }

    public char getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone=" + phone +
                ", sex=" + sex +
                '}';
    }
}
