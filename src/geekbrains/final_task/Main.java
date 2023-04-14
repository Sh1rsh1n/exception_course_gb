package geekbrains.final_task;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        DataServices ds = new DataWriterToFile();
        
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            ds.writeUserData(input);
        } else {
            System.out.println("Некорректный ввод данных");
        }
        
    }
}
