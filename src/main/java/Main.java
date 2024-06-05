public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        // 1. Входные параметры для счётчика
        calculator.enterNumberOfPersons();

        // 2. Добавление товаров в калькулятор
        calculator.enterGoodsAndPrices();

        // 3. Вывод результатов
        calculator.printGoodsAndPrices();
        calculator.printSumPerPerson();
    }
}

