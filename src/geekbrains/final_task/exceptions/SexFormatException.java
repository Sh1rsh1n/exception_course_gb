package geekbrains.final_task.exceptions;

/*
Исключение генерируется при некорректном вводе пола пользователя
 */
public class SexFormatException extends RuntimeException {
    public SexFormatException(String message) {
        super(message);
    }
}
