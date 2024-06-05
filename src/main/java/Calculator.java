import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    private int numberOfPersons;
    private HashMap<String, Double> goodsAndPrices;

    // Метод проверяет, что строка - целое положительное число
    private boolean isThisNumber(String input) {
        return input.matches("^[1-9][0-9]*$");
    }

    public void enterNumberOfPersons() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = -1;

        while (numberOfPersons <= 1) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            String userInput = scanner.nextLine();

            if (!this.isThisNumber(userInput)) {
                System.out.println("Некорректное значение. Нужно ввести целое число больше 1");
            } else if (Integer.parseInt(userInput) == 1) {
                System.out.println("Нет смысла ничего считать и делить - вы ели в одиночку!");
            } else {
                numberOfPersons = Integer.parseInt(userInput);
            }
        }
        this.numberOfPersons = numberOfPersons;
    }

    // Метод проверяет, что строка - шаблонная пара "товар - цена"
    // Цена считается корректной в том числе для
    // - цен меньше 1 рубля
    // - цены в 0 рублей 0 копеек (например, подарок от заведения)
    private boolean isThisGoodAndPrice(String input) {
        return input.matches("^.+ - (([1-9][0-9]*)|0)\\.[0-9]{2}$");
    }

    public void enterGoodsAndPrices() {

        String stopTotalPriceCommand = "завершить";
        this.goodsAndPrices = new HashMap<>();
        String userCommand = "пока не завершили";


        while (!userCommand.equals(stopTotalPriceCommand)) {
            System.out.println("Введите название товара и его стоимость в формате:\n<название товара> - <рубли>.<копейки>\nДля копеек всегда используйте ДВЕ цифры");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            if (this.isThisGoodAndPrice(userInput)) {
                String[] goodAndPrice = userInput.split(" - ");
                double nextPrice = Double.parseDouble(goodAndPrice[1]);
                this.goodsAndPrices.put(goodAndPrice[0], nextPrice);
                System.out.println("Товар успешно добавлен");

                System.out.println("Введите \"завершить\", чтобы закончить ввод. Чтобы добавить ещё товар, введите любые другие символы");
                userCommand = scanner.nextLine().toLowerCase();
            } else {
                System.out.println("Ввод некорректен. Пожалуйста, следуйте инструкции");
            }
        }
    }

    // По числу определяет, в каком падеже должно быть слово "рубли"
    private String getRublePostfix(double sum) {
        String rublePostfix;

        if (sum  >= 5 && sum < 21) {
            rublePostfix = "рублей";
        } else {
            int sumRemainder = (int) sum / 10;
            rublePostfix = switch (sumRemainder) {
                case 1 -> "рубль";
                case 2, 3, 4 -> "рубля";
                default -> "рублей";
            };
        }
        return rublePostfix;
    }

    // Проверяет, что в объекте есть и количество персон, и список товаров с ценами
    private boolean isAllFieldsFilled() {
        if (this.numberOfPersons == 0) {
            System.out.println("Список товаров пуст!");
        }
        if (this.goodsAndPrices == null) {
            System.out.println("Список товаров пуст!");
        }
        return this.numberOfPersons != 0 && this.goodsAndPrices != null;
    }

    public void printGoodsAndPrices() {
        if (this.isAllFieldsFilled()) {
            System.out.println("Добавленные товары:");
            for (Map.Entry<String, Double> entry : this.goodsAndPrices.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " " + this.getRublePostfix(entry.getValue()));
            }
        }
    }

    private double getSumPerPerson() {
        double total = 0.0;
        if (this.isAllFieldsFilled()) {
            for (Map.Entry<String, Double> entry : this.goodsAndPrices.entrySet()) {
                total += entry.getValue();
            }
            return total / this.numberOfPersons;
        }
        return total;
    }

    public void printSumPerPerson() {
        if (this.isAllFieldsFilled()) {
            double sumPerPerson = this.getSumPerPerson();
            System.out.println("Каждый человек должен заплатить " + String.format("%.2f", sumPerPerson) + " " + this.getRublePostfix(sumPerPerson));
        }
    }

}
