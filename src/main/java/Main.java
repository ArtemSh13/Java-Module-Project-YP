import java.util.HashMap;
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

        String userCommand = "Пока не завершили";
        HashMap<String, Double> goodsAndPrices = new HashMap<>();
        double total = 0;

        while (!userCommand.equals("завершить")) {
            System.out.println("Введите название товара и его стоимость в формате:\n<название товара> - <рубли>.<копейки>");
            scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            String[] goodAndPrice = userInput.split(" - ");
            double nextPrice = Double.parseDouble(goodAndPrice[1]);
            goodsAndPrices.put(goodAndPrice[0], nextPrice);
            System.out.println("Товар успешно добавлен");
            total += nextPrice;
            System.out.println("Введите \"завершить\", чтобы закончить ввод. Чтобы добавить ещё товар, введите любые другие символы");
            userCommand = scanner.nextLine().toLowerCase();
        }
    }
}