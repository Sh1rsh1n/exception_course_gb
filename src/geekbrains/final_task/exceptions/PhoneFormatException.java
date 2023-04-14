package geekbrains.final_task.exceptions;

/*
Исключение генерируется при некорректном формате телефона пользователя
 */
public class PhoneFormatException extends RuntimeException {
    public PhoneFormatException(String message) {
        super(message);
    }
}
