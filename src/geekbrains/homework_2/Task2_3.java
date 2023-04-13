/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/

package geekbrains.homework_2; 

import java.util.Scanner;

public class Task2_3{

	private static Scanner scanner;
	
	/* 
	метод, ввод данных пользователем
	в случае ввода пустой строки, генерирует исключение EmptyStringException
	*/
	private static String userInput() throws EmptyStringException {
	
		scanner = new Scanner(System.in);
		System.out.print("Введите любую строку: ");
		String input = scanner.nextLine();
	
		if (input.equals("")) { // проверка ввод пустой строки
			throw new EmptyStringException();
		}
		
		return input;
	}

    public static void main(String args[]){
	
    		String value = userInput();
		
		System.out.printf("вы ввели: %s", value);
		
		scanner.close();
    	}
}

/*
для информативности, создаем свой класс-исключение, наследник не проверяемого исключения RuntimeException
*/
class EmptyStringException extends RuntimeException {
	
	// если код выбросит исключение, просто выводим в консоль сообщение
	public EmptyStringException() {
		System.out.println("пустая строка");
	}
}
