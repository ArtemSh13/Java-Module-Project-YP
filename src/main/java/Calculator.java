import java.util.HashMap;
import java.util.Scanner;

public class Calculator {
    private HashMap<String, Double> goodsAndPrices;

    public int enterNumberOfPersons() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = -1;

        while (numberOfPersons <= 1) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            String userInput = scanner.nextLine();

            if (!this.isNumber(userInput)) {
                System.out.println("Некорректное значение. Нужно ввести целое число больше 1");
            } else if (Integer.parseInt(userInput) == 1) {
                System.out.println("Нет смысла ничего считать и делить - вы ели в одиночку!");
            } else {
                numberOfPersons = Integer.parseInt(userInput);
            }
        }
        return numberOfPersons;
    }

    public double calculateTotalPrice() {

        String stopTotalPriceCommand = "завершить";
        this.goodsAndPrices = new HashMap<>();
        double total = 0;
        String userCommand = "пока не завершили";


        while (!userCommand.equals(stopTotalPriceCommand)) {
            System.out.println("Введите название товара и его стоимость в формате:\n<название товара> - <рубли>.<копейки>\nДля копеек всегда используйте ДВЕ цифры");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            if (this.isGoodAndPrice(userInput)) {
                String[] goodAndPrice = userInput.split(" - ");
                double nextPrice = Double.parseDouble(goodAndPrice[1]);
                this.goodsAndPrices.put(goodAndPrice[0], nextPrice);
                System.out.println("Товар успешно добавлен");
                total += nextPrice;
                System.out.println("Введите \"завершить\", чтобы закончить ввод. Чтобы добавить ещё товар, введите любые другие символы");
                userCommand = scanner.nextLine().toLowerCase();
            } else {
                System.out.println("Ввод некорректен. Пожалуйста, следуйте инструкции");
            }
        }
        return total;
    }

    public HashMap<String, Double> getGoodsAndPrices() {
        return goodsAndPrices;
    }

    private boolean isNumber(String input) {
        return input.matches("^[1-9][0-9]*$");
    }

    private boolean isGoodAndPrice(String input) {
        return input.matches("^.+ - [1-9][0-9]*\\.[0-9]{2}$");
    }

}
