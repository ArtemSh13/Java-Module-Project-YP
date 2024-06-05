import java.util.Scanner;

public class Calculator {
    public int enterNumberOfPersons() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = -1;

        while (numberOfPersons <= 1) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            String userInput = scanner.nextLine();

            if (!this.checkStringForNumber(userInput)) {
                System.out.println("Некорректное значение. Нужно ввести целое число больше 1");
            } else if (Integer.parseInt(userInput) == 1) {
                System.out.println("Нет смысла ничего считать и делить - вы ели в одиночку!");
            } else {
                numberOfPersons = Integer.parseInt(userInput);
            }
        }
        return numberOfPersons;
    }

    boolean checkStringForNumber(String input) {
        return input.matches("^[1-9][0-9]*$");
    }


}
