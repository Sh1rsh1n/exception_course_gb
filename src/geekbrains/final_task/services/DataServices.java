package geekbrains.final_task.services;

import geekbrains.final_task.model.UserData;

/*
интерфейс, на случай если нужно будет отправлять данные в другое хранилище
*/
public interface DataServices {

    void writeUserData(UserData user);

}