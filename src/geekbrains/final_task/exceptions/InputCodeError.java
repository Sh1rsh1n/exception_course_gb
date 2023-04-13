package geekbrains.final_task.exceptions;

public class InputCodeError extends RuntimeException{

    public InputCodeError(String message, int number) {
        super(String.format("Ошибка #%d: %s", number, message));
    }
}
