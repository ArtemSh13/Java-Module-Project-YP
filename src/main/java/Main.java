import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        // 1. Входные параметры для счётчика
        int numberOfPersons = calculator.enterNumberOfPersons();

        // 2. Добавление товаров в калькулятор
        String userCommand = "Пока не завершили";
        HashMap<String, Double> goodsAndPrices = new HashMap<>();
        double total = 0;

        while (!userCommand.equals("завершить")) {
            System.out.println("Введите название товара и его стоимость в формате:\n<название товара> - <рубли>.<копейки>");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            String[] goodAndPrice = userInput.split(" - ");
            double nextPrice = Double.parseDouble(goodAndPrice[1]);

            goodsAndPrices.put(goodAndPrice[0], nextPrice);
            System.out.println("Товар успешно добавлен");

            total += nextPrice;

            System.out.println("Введите \"завершить\", чтобы закончить ввод. Чтобы добавить ещё товар, введите любые другие символы");
            userCommand = scanner.nextLine().toLowerCase();
        }

        // 3. Вывод результатов
        double totalPerPerson = total / numberOfPersons;
        int totalPerPersonRemainder = (int) totalPerPerson / 10;
        String rublePostfix;

        if (totalPerPerson  >= 5 && totalPerPerson < 21) {
            rublePostfix = "рублей";
        } else {
            rublePostfix = switch (totalPerPersonRemainder) {
                case 1 -> "рубль";
                case 2, 3, 4 -> "рубля";
                default -> "рублей";
            };
        }

        System.out.println("Добавленные товары:");
        for (Map.Entry<String, Double> entry : goodsAndPrices.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " ₽");
        }
        System.out.println("Каждый человек должен заплатить " + String.format("%.2f", totalPerPerson) + " " + rublePostfix);
    }
}

