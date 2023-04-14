package geekbrains.final_task.services;

import geekbrains.final_task.model.UserData;
import java.io.FileWriter;


public class DataWriterToFile implements DataServices {
    
    private final static UserData user = new DataHandler().inputUserData(input);
    private final static String path = user.getLastName();
    
    @Override
    public void writeUserData(UserData user) {
        boolean value  = checkExistsFile();
        StringBuilder sb = new StringBuilder();
        
        // если файл существует, дописываем в него данные, иначе создаем новый
        try(FileWriter fw = new FileWriter(String.format("./dataFiles/%s.txt", path), value)) {
        
            if (value) { // если файл существует, записываем данные с новой строки
                fw.write("\n");
            }
            // помещаем все данные о пользователе в объект StringBuilder
            sb.append(user.getLastName() + " ");
            sb.append(user.getLastName() + " ");
            sb.append(user.getFirstName() + " ");
            sb.append(user.getMiddleName() + " ");
            sb.append(user.getBirthday() + " ");
            sb.append(String.valueOf(user.getPhone()) + " ");
            sb.append(user.getSex());
            
            fw.write(sb.toString()); // записываем данные в файл
            fw.flush();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    // проверка существования файла
    private boolean checkExistsFile(String path) {
        return new File(path).exists();
    }
    
}