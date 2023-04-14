package geekbrains.final_task.exceptions;

/*
Исключение генерируется при некорректном формате даты рождения
 */
public class IncorrectBirthdayFormatException extends RuntimeException {
    public IncorrectBirthdayFormatException(String message) {
        super(message);
    }
}
