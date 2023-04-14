package geekbrains.final_task.services;


import geekbrains.final_task.exceptions.IncorrectBirthdayFormatException;
import geekbrains.final_task.exceptions.PhoneFormatException;
import geekbrains.final_task.exceptions.SexFormatException;
import geekbrains.final_task.model.User;

public class DataHandler {

    public User inputUserData(String value) {

        String[] array = value.split(" ");  // входящие данные переводим в массив строк, для дальнейшей обработки

        if (checkInput(array)) {    // проверяем массив строк, если все "ок" создаем нового пользователя
            return new User(array[1],   // имя
                    array[0],   // фамилия
                    array[2],   // отчество
                    array[3],   // дата рождения
                    Long.valueOf(array[4]),  // номер телефона
                    array[5].charAt(0)); // пол
        }
        throw new NullPointerException();
    }

    // коды ошибок, как по условию задания
    private int errorCodes(String[] array) {
        if (array == null) {
            return 1001;
        }
        if (array.length < 6) {
            return 1002;
        }
        if (array.length > 6) {
            return 1003;
        }
        return 0;
    }

    /*
     *   проверка входящих данных от пользователя
     */
    private boolean checkInput(String[] array) {

        int codeError = errorCodes(array); // в случае неверного формата входящей строки, получаем код ошибки

        // проверяем коды ошибок и соответствие входящих строк с данными пользователя
        if (codeError == 1001) {
            System.out.printf("Массив значений не был проинициализирован. Ошибка #%d", codeError);
            return false;
        }
        if (codeError == 1002) {
            System.out.printf("Некорректный формат входящих данных. Вы ввели не все данные. Ошибка #%d", codeError);
            return false;
        }
        if (codeError == 1003) {
            System.out.printf("Некорректный формат входящих данных. Вы ввели лишние данные. Ошибка #%d", codeError);
            return false;
        }
        // проверяем формат даты рождения типа: 01.01.2000
        if (!array[3].matches("(0[1-9]|[12][0-9]|3[01])[.](0[1-9]|1[0-2])[.]([12][0-9][0-9][0-9])")) {
            throw new IncorrectBirthdayFormatException("Некорректный формат даты рождения пользователя");
        }
        // проверяем формат номера телефона: 89876543210 первая цифра обязательно 7 или 8 вторая цифра только 9
        if (!array[4].matches("[78]9[0-9]{9}")) {
            throw new PhoneFormatException("Некорректный формат номера телефона");
        }
        // поверка формата указанного пола пользователя
        if (!array[5].matches("[fmFM]")) {
            throw new SexFormatException("Некорректно указан пол пользователя");
        }
        return true;
    }
}
