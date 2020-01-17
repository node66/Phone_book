import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class book {
    private static Hashtable<String, String> number = new Hashtable<String, String>();

    private static void add(String phoneNumber, String Name) {
        number.put(phoneNumber, Name);
        System.out.println("Контакт добавлен!");
    }

    private static void find(String phoneNumber) {
        if (number.containsKey(phoneNumber)) {
            System.out.println("Имя: " + number.get(phoneNumber));
        } else
            System.out.println("Такого контакта не существует!");
    }

    private static void del(String phoneNumber) {
        if (number.containsKey(phoneNumber)) {
            number.remove(phoneNumber);
            System.out.println("Контакт удален!");
        } else
            System.out.println("Такого контакта не существует!");
    }

    private static void list() {
        Set<Map.Entry<String, String>> set = number.entrySet();
        if (number.isEmpty())
            System.out.print("Список пуст!");
        for (Map.Entry<String, String> x : set) {
            System.out.println("Номер телефона: " + x.getKey());
            System.out.println("Имя: " + x.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Выбирите действие: ");
        System.out.println("add (добавить), find(найти номер), del(удалить номер), list(вывести список всех контактов), exit(выход)");

        Pattern PatName = Pattern.compile("^[a-zA-Z]+[0-9]");
        Pattern PatNum = Pattern.compile("[0-9]-");


        Scanner action = new Scanner(System.in);
        String act = action.nextLine();

        while (!act.equalsIgnoreCase("exit")) {
            if (act.equalsIgnoreCase("add")) {

                System.out.println("Введите номер телефона:");
                String phoneNumber = action.nextLine();
                Matcher MatNum = PatNum.matcher(phoneNumber);
                if (!MatNum.find()) {
                    System.out.println("Номер должен состоять только из чисел разделеных знаком \"-\" ");
                    continue;
                }

                System.out.println("Введите имя: ");
                String Name = action.nextLine();
                Matcher MatName = PatName.matcher(Name);
                if (!MatName.find()){
                    System.out.println("Имя должно состоять из латинских букв и начинаться с буквы");
                    continue;
                }
                add(phoneNumber, Name);
            }

            if (act.equalsIgnoreCase("list")) {
                list();
            }
            if (act.equalsIgnoreCase("del")) {
                System.out.println("Введите номер телефона: ");
                String phoneNumber = action.nextLine();
                del(phoneNumber);
            }
            if (act.equalsIgnoreCase("find")) {
                System.out.println("Введите номер телефона: ");
                String phoneNumber = action.nextLine();
                find(phoneNumber);
            }
            act = action.nextLine();
        }
    }
}