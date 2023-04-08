package geekbrains.homework_1;


import java.util.Random;
import java.util.Scanner;

/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.

* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */
public class Task1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr1 = fillArray();   // заполняем первый массив случайными числами
        int[] arr2 = fillArray();   // заполняем второй массив случайными числами

        printArray(arr1);     // выводим в консоль первый массив
        printArray(arr2);    // выводим в консоль второй массив

//        int[] nullArray = null;     // проверка на null

        int[] resultArr1 = subtractArrays(arr1, arr2); // вычисляем разность всех элементов на одинаковых индексах массивов
        int[] resultArr2 = divideArrays(arr1, arr2); // вычисляем частное всех элементов на одинаковых индексах массивов

        System.out.println("разность");
        printArray(resultArr1);  // выводим в консоль результат вычислений
        System.out.println("частное");
        printArray(resultArr2);  // выводим в консоль результат вычислений
    }

    /*
    метод принимает на вход два массива, вычисляет разность элементов на одинаковых индексах
    записывает результат в новый массив
    */
    private static int[] subtractArrays(int[] firstArray, int[] secondArray) {

        int size = checkArrays(firstArray, secondArray); // проверяем массивы

        int[] resultArray = new int[size];

        // выполняем вычисления, как в условии задачи
        for (int i = 0; i < size; i++) {
            resultArray[i] = firstArray[i] - secondArray[i];
        }

        return resultArray;
    }

    /*
    метод принимает на вход два массива, вычисляет частное элементов на одинаковых индексах
    записывает результат в новый массив
    */
    private static int[] divideArrays(int[] firstArray, int[] secondArray) {

        int size = checkArrays(firstArray, secondArray); // проверяем массивы

        int[] resultArray = new int[size];

        // выполняем вычисления, как в условии задачи
        for (int i = 0; i < size; i++) {
            float result = firstArray[i] / secondArray[i];
            resultArray[i] = Math.round(result);
        }

        return resultArray;
    }

    /*
    метод, возвращает массив случайных чисел от -10 до 10, размер массива задает пользователь
     */
    private static int[] fillArray() {

        int size = 0;
        System.out.print("Введите размер массива: ");

        if (scanner.hasNextInt()) {     // проверка на корректность ввода данных от пользователя
            size = scanner.nextInt();
        } else {
            throw new IncorrectInputException("Некорректный ввод данных");
        }

        int[] array = new int[size];

        // заполняем массив данными
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(21) - 10;
        }
        return array;
    }

    /*
    метод выводит результаты вычислений в консоль
     */
    private static void printArray(int[] resultArray) {
        for (int i : resultArray) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    /*
    метод, проверяет оба массив на null и одинаковые размеры массива
    если все проверки неудачны, вовзвращает размер массива
     */
    private static int checkArrays(int[] firstArray, int[] secondArray) {

        // проверка на случай, если пользователь добавляет свой массив(не сгенерированный)
        if (firstArray == null || secondArray == null)
            throw new NullPointerException("Некорректное значение одного из массивов");

        // проверка на нулевые размеры массивов
        if (firstArray.length == 0 || secondArray.length == 0)
            throw new IncorrectArraysSizeException(String.format("Недопустимый размер массива %d, %d", firstArray.length, secondArray.length));

        // проверка неодинаковых размеров массивов
        if (firstArray.length != secondArray.length)
            throw new IncorrectArraysSizeException(String.format("Размеры массивов разные %d, %d", firstArray.length, secondArray.length));

        // проверка деления на ноль, если один из элементов равен 0, то бросаем исключение
        for (int i = 0; i < secondArray.length; i++) {
            if (secondArray[i] == 0) {
                throw new ArithmeticException("Деление на ноль, недопустимо");
            }
        }

        return firstArray.length;
    }
}


/*
класс, описание исключения, которое выбрасывается программой, если массивы имеют разные размеры
 */
class IncorrectArraysSizeException extends RuntimeException {
    public IncorrectArraysSizeException(String message) {
        super(message);
    }
}

/*
класс, описание исключения, если пользователь ввел некорректные данные
 */
class IncorrectInputException extends RuntimeException {
    public IncorrectInputException(String message) {
        super(message);
    }
}