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
        double total = calculator.calculateTotalPrice();

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
        for (Map.Entry<String, Double> entry : calculator.getGoodsAndPrices().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " ₽");
        }
        System.out.println("Каждый человек должен заплатить " + String.format("%.2f", totalPerPerson) + " " + rublePostfix);
    }
}

