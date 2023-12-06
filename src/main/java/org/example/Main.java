package org.example;

import java.io.*;
import java.awt.print.Book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner=new Scanner(System.in);
        int a=0; Menu.mainMenu();
        do {

            a= scanner.nextInt();
            switch (a) {
                case (1)->{
                    try {

                        BufferedWriter writer = new BufferedWriter(new FileWriter("./text.txt", true));


                        String marhryt1 = scanner.nextLine();
                        System.out.print("Введите маршрут: ");
                        String marhryt = scanner.nextLine();

                        System.out.print("Введите номер рейса ");
                        String nomer = scanner.nextLine();
                        System.out.print("Введите пункты промежуточной посадки: ");
                        String posadca = scanner.nextLine();
                        System.out.print("Введите время отправления: ");
                        String vrem = scanner.nextLine();

                        System.out.print("Введите дни отправления : ");
                        String dni = scanner.nextLine();

                        System.out.print("Введите Количество свободных : ");
                        String kol = scanner.nextLine();
                        writer.write("marhryt1"+" номер рейса" + nomer + ", маршрут: " + marhryt + ", посадки: " + posadca + ", время: "+ vrem + ", дни: "+ dni + ", Количество: "+ kol );
                        writer.newLine();

                        writer.close();
                        System.out.println(" Добавлена в библиотеку");



                    } catch (IOException e) {
                        System.out.println("Ошибка при записи в файл");
                    }
                }



                case (2)->


                    { String searchAuthor = scanner.nextLine();
                        System.out.print("Введите для поиска: ");
                        Scanner reader = new Scanner(new File("./text.txt"));
                        while (reader.hasNext()) {
                            String line = reader.nextLine();
                            String[] fields = line.split(", ");

                            for (String field : fields) {
                                if (field.startsWith("uyi:")) {
                                    String author = field.substring(7);
                                    if (author.equalsIgnoreCase(searchAuthor)) {
                                        System.out.println(line);

                                    }
                                }
                            }
                        }

                    }

                case(3)->
                {System.out.print("Введите для удаления: ");int deleteYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите  для удаления: ");
                    String deletePublisher = scanner.nextLine();
                    String deleteAuthor = scanner.nextLine();

                    File inputFile = new File("./text.txt");
                    File tempFile = new File("./temp.txt");
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] fields = line.split(", ");
                            boolean delete = false;

                            for (String field : fields) {
                                if (field.startsWith("uhk")) {
                                    int year = Integer.parseInt(field.substring(13));
                                    if (year == deleteYear) {
                                        delete = true;
                                        break;
                                    }
                                } else if (field.startsWith("Издательство:")) {
                                    String publisher = field.substring(15);
                                    if (publisher.equalsIgnoreCase(deletePublisher)) {
                                        delete = true;
                                        break;
                                    }
                                } else if (field.startsWith("Автор:")) {
                                    String author = field.substring(7);
                                    if (author.equalsIgnoreCase(deleteAuthor)) {
                                        delete = true;
                                        break;
                                    }
                                }
                            }

                            if (!delete) {
                                writer.write(line);
                                writer.newLine();
                            }
                        }

                        writer.close();
                        reader.close();

                        // Удаляем исходный файл
                        if (!inputFile.delete()) {
                            System.out.println("Ошибка при удалении файла");
                        }

                        // Переименовываем временный файл в исходный
                        if (!tempFile.renameTo(inputFile)) {
                            System.out.println("Ошибка при переименовании файла");
                        }

                        System.out.println("Книга успешно удалена из библиотеки");
                    } catch (IOException e) {
                        System.out.println("Ошибка при чтении файла");
                    }}
                }





        }while (a !=5 );

    }}
