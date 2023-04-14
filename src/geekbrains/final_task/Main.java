package geekbrains.final_task;

import geekbrains.final_task.services.DataServices;
import geekbrains.final_task.services.DataWriterToFile;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DataServices ds;

        System.out.println("Введите ФИО, дату рождения, телефон и пол пользователя (через разделитель 'пробел'): ");

        while (true) {
            if (scanner.hasNextLine()) {            // проверяем входящую строку
                String input = scanner.nextLine();  // передаем входящую строку в переменную
                ds = new DataWriterToFile(input);   // передаем полученную строку в объект класса DataWriterToFile
                ds.writeUserData();                 // записываем данные в файл
            }
            System.out.println("Введите ФИО, дату рождения, телефон и пол пользователя (через разделитель 'пробел'): ");
        }
    }
}
