package geekbrains.final_task.services;


import geekbrains.final_task.exceptions.IncorrectBirthdayFormatException;
import geekbrains.final_task.exceptions.InputCodeError;
import geekbrains.final_task.exceptions.PhoneFormatException;
import geekbrains.final_task.exceptions.SexFormatException;

import geekbrains.final_task.model.UserData;

public class DataHandler {

    public UserData inputUserData(String value) {

        String[] array = value.split(" ");

        if (checkInput(array)) {
            return new UserData(array[1],   // имя
                                array[0],   // фамилия
                                array[2],   // отчество
                                array[3],   // дата рождения
                                Integer.valueOf(array[4]),  // номер телефона
                                array[5].charAt(0); // пол
        }
        throw new NullPointerException();
    }

    // коды ошибок
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

        int codeError = errorCodes(array);

        if (codeError == 1001) {
            throw new InputCodeError("Массив значений не был проинициализирован", codeError);
        }
        if (codeError == 1002) {
            throw new InputCodeError("Некорректный формат входящих данных. Вы ввели не все данные", codeError);
        }
        if (codeError == 1003) {
            throw new InputCodeError("Некорректный формат входящих данных. Вы ввели лишние данные", codeError);
        }
        if (!array[3].matches("([1-9]|[12][0-9]|3[01])[.]([1-9]|1[0-2])[.]([12][0-9][0-9][0-9])")) {
            throw new IncorrectBirthdayFormatException("Некорректный формат даты рождения пользователя");
        }
        if (!array[4].matches("[78]9[0-9]{2}[0-9]{7}")) {
            throw new PhoneFormatException("Некорректный формат номера телефона");
        }
        if (!array[5].matches("[fmFM]")) {
            throw new SexFormatException("Некорректно указан пол пользователя");
        }
        return true;
    }

}
