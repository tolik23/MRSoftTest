package com.liutorovichgmail.anatoliy.mrsofttest.Model;

import android.content.Context;


public class DataBaseFilling {

    Context mContext;
    public DataBaseFilling (Context context){
        mContext = context;
    }

    public void addAllContact (){
        DataBase db = new DataBase(mContext);
        if (db.checkNull()==true) {
            db.addContact("Василий", "Петров", "директор", 45);
            db.addContact("Иван", "Иванов", "заместитель директора", 48);
            db.addContact("Юрий", "Сидоров", "начальник отдела", 35);
            db.addContact("Александр", "Сидоров", "начальник отдела", 36);
            db.addContact("Анатолий", "Фролов", "программист", 30);
            db.addContact("Денис", "Сидоров", "программист", 28);
            db.addContact("Евгений", "Попов", "программист", 23);
            db.addContact("Юлия", "Попова", "дизайнер", 25);
            db.addContact("Анна", "Путин", "дизайнер", 29);
            db.addContact("Николай", "Петров", "программист", 32);
            db.addContact("Александр", "Петров", "программист", 40);
            db.addContact("Надежда", "Петров", "программист", 37);
            db.addContact("Алексей", "Попов", "программист", 25);
            db.addContact("Дмитрий", "Сидоров", "программист", 25);
            db.addContact("Владимир", "Попов", "программист", 35);
            db.addContact("Николай", "Петров", "программист", 28);
            db.addContact("Юлия", "Петров", "тестировщик", 22);
            db.addContact("Вячеслав", "Петров", "тестировщик", 19);
            db.addContact("Анатолий", "Петров", "тестировщик", 28);
            db.addContact("Вадим", "Петров", "бизнес аналитик", 34);
            db.addContact("Влада", "Путина", "тестировщик", 26);
            db.addContact("Василий", "Сидоров", "тестировщик", 35);
            db.addContact("Дмитрий", "Фролов", "тестировщик", 27);
            db.addContact("Алексей", "Петров", "программист", 35);
            db.addContact("Валерий", "Петров", "программист", 28);
            db.addContact("Денис", "Петров", "бизнес аналитик", 27);
            db.addContact("Виктор", "Иванов", "бизнес аналитик", 26);
            db.addContact("Александр", "Фролов", "дизайнер", 24);
            db.addContact("Валентина", "Фролова", "уборщица", 45);
            db.addContact("Александр", "Иванов", "служащий", 49);
        }
    }
}
