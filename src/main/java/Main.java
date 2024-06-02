import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = -1;

        while (numberOfPersons <= 1) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            numberOfPersons = scanner.nextInt();
            if (numberOfPersons < 1) {
                System.out.println("Некорректное значение. Нужно ввести целое число больше 1");
            } else if (numberOfPersons == 1) {
                System.out.print("Нет смысла ничего считать и делить - вы ели в одиночку!");
            }
        }
    }
}