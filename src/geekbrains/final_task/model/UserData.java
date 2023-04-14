package geekbrains.final_task.model;

/*
класс, описание пользователя
 */
public class UserData {

    private String firstName;
    private String lastName;
    private String middleName;
    private String birthday;
    private int phone;
    private char sex;

    public UserData(String firstName, String lastName, String middleName, String birthday, int phone, char sex) {
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

    public int getPhone() {
        return phone;
    }

    public char getSex() {
        return sex;
    }
}
