package geekbrains.final_task.model;

/*
класс, описание пользователя
 */
public class UserData {

    private String fullName;
    private String birthday;
    private int phone;
    private char sex;

    public UserData(String fullName, String birthday, int phone, char sex) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.phone = phone;
        this.sex = sex;
    }

    public String getFullName() {
        return fullName;
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

    @Override
    public String toString() {
        return "UserData{" +
                "fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone=" + phone +
                ", sex=" + sex +
                '}';
    }
}
