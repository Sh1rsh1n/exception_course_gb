/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
*/

package geekbrains.homework_2;

import java.util.Scanner;

public class Task2 {

    private static Scanner scan;

    private static float realNumberInput() {

        scan = new Scanner(System.in);

        while (true) {
			System.out.print("Введите дробное число: ");
			String input = scan.nextLine();
            if (input.matches("\\d+[.]\\d+")) {
                return Float.valueOf(input);
            } else {
                System.out.println("Некорректное значение.\nЗначение должно быть дробным, формата: 123.456");
            }
        }
    }


    public static void main(String args[]) {

        float value = realNumberInput();

        System.out.printf("Вы ввели число: %f", value);

        scan.close();
    }
}



