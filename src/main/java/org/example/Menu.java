package org.example;

public class Menu {
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void mainMenu(){
        System.out.println("Выбор Действий\n"+
                "1 Добавить \n"+
                "2 ПОИСК\n"+
                "3 УДАЛИТЬ \n"+
                "5 Закрыть \n");
    }

}