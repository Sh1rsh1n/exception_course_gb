package geekbrains.homework_2;

public class Task2_1{

    public static void main(String args[]){
	
	int[] intArray = new int[]{5,8,9,8,8,6,5,7};	// инициализируем массив, без него код не запустится
	
       try {
   		int d = 0;
   		double catchedRes1 = intArray[8] / d;
   		System.out.println("catchedRes1 = " + catchedRes1);
	} catch (RuntimeException e) {	// поменяли ArithmeticException на общий класс RuntimeException, так как данный код может генерировать много разных исключений: ArrayIndexOutOfBoundException, NPE, ArithmeticException
   		System.out.println("Catching exception: " + e);
	}
    }
}



