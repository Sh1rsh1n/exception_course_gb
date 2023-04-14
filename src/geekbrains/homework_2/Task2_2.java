package geekbrains.homework_2;
/* 
1. плохая практика пробрасывать исключения выше в методе main
2. 2ой и 3ий блоки catch не сработают, так как все исключения будут перехвачены в 1ом блоке
3. Throwable поменять на Exception, вполне достаточно
4. в методе printSum поменять типы аргументов на примитивные(int) для экономии памяти
5. метод printSum может выбрасывать икслючение FileNotFoundException, при этом в теле метода нет кода, который мог бы сгенерировать это исключение. 
6. В методе main нет обработки исключения FileNotFoundException, которое может сгенерировать метод printSum

public static void main(String args[]) throws Exception{
	
   	try {
       	int a = 90;
       	int b = 3;
       	System.out.println(a / b);
       	printSum(23, 234);
       	int[] abc = { 1, 2 };
       	abc[3] = 9;
   	} catch (Throwable ex) {
       	System.out.println("Что-то пошло не так...");
   	} catch (NullPointerException ex) {
       	System.out.println("Указатель не может указывать на null!");
   	} catch (IndexOutOfBoundsException ex) {
       	System.out.println("Массив выходит за пределы своего размера!");
   	}
}

public static void printSum(Integer a, Integer b) throws FileNotFoundException {
   	System.out.println(a + b);
}
*/

import java.io.FileNotFoundException;

public class Task2_2 {

	public static void printSum(int a, int b) throws FileNotFoundException {
   		System.out.println(a + b);
	}

	public static void main(String args[]) {

   		try {
       		int a = 90;
       		int b = 3;
       		System.out.println(a / b);
       		printSum(23, 234);
       		int[] abc = { 1, 2 };
       		abc[3] = 9;
   		} catch (FileNotFoundException ex) {
       		System.out.println("Файл не найден или не верно указан путь.");
   		} catch (NullPointerException ex) {
       		System.out.println("Указатель не может указывать на null!");
   		} catch (IndexOutOfBoundsException ex) {
       		System.out.println("Массив выходит за пределы своего размера!");
   		} catch (Exception ex) {
       		System.out.println("Что-то пошло не так...");
   		}
	}
}

