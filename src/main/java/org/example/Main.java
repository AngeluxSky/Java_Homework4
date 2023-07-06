package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
//1. Организовать ввод и хранение данных пользователей. 2. ФИО возраст, пол и выход из режима ввода информации.
//2. Вывод в формате Фамилия И.О. возраст пол.
//3. Добавить возможность выхода или вывода списка отсортированного по возрасту!).
//4. Реализовать сортировку по возрасту с использованием индексов.
//5. Реализовать сортировку по возрасту и полу с использованием индексов.
public class Main {
    static Scanner scanner;
    public static void firstSort(ArrayList<String> surname, ArrayList<String> name, ArrayList<String> middleName,
                                 ArrayList<Integer> age, ArrayList<Boolean> gender, ArrayList<Integer> id) {
        ArrayList<Integer> sortedId = new ArrayList<>(id);

        sortedId.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return age.get(o1) - age.get(o2);
            }
        });
        for (Integer i : sortedId) {
            System.out.println(surname.get(i) + " " + name.get(i).toUpperCase().charAt(0) + "." +
                    middleName.get(i).toUpperCase().charAt(0) + "." + " " + age.get(i) + " " +
                    (gender.get(i) ? "Ж" : "М"));
        }
    }

    public static void secondSort(ArrayList<String> surname, ArrayList<String> name, ArrayList<String> middleName,
                                  ArrayList<Integer> age, ArrayList<Boolean> gender, ArrayList<Integer> id) {
        ArrayList<Integer> sortedId = new ArrayList<>(id);

        sortedId.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (gender.get(o1) == gender.get(o2)) {
                    return age.get(o1) - age.get(o2);
                } else {
                    if (gender.get(o1)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        for (Integer i : sortedId) {
            System.out.println(surname.get(i) + " " + name.get(i).toUpperCase().charAt(0) + "." +
                    middleName.get(i).toUpperCase().charAt(0) + "." + " " + age.get(i) + " " +
                    (gender.get(i) ? "Ж" : "М"));
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> middleName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();

        while (true) {
            System.out.println("Введите фамилию -> ");
            surname.add(scanner.nextLine());

            System.out.println("Введите имя -> ");
            name.add(scanner.nextLine());

            System.out.println("Введите отчество -> ");
            middleName.add(scanner.nextLine());

            System.out.println("Введите возраст -> ");
            age.add(Integer.valueOf(scanner.nextLine()));

            System.out.println("Введите пол (м/ж) -> ");
            gender.add(scanner.nextLine().equalsIgnoreCase("ж"));

            id.add(gender.size() - 1);

            System.out.println("Продолжить ввод (да/нет)? -> ");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("да")) break;
        }

        System.out.println("Список пользователей:\n");
        for (int i = 0; i < surname.size(); i++) {
            System.out.println(surname.get(i) + " " + name.get(i).toUpperCase().charAt(0) + "." +
                    middleName.get(i).toUpperCase().charAt(0) + "." + " " + age.get(i) + " " +
                    (gender.get(i) ? "Ж" : "М"));
        }

        System.out.println("\nСортировать по возрасту (да/нет)? -> ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("да")) {
            firstSort(surname, name, middleName, age, gender, id);
        }

        System.out.println("\nСортировать по возрасту и полу (да/нет)? -> ");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("да")) {
            secondSort(surname, name, middleName, age, gender, id);
        }
    }
}