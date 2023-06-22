import java.util.Scanner;
public class Praktika {

    public static void main(String[] args){
        double[] expenses = new double[7]; // создание массива дней недели, куда будут занесены траты

        Scanner scanner = new Scanner(System.in); // объявление ввода с помощью клавиатуры

        System.out.println("Сколько денег у вас осталось?:");

        double moneyBeforeSalary = scanner.nextDouble(); //Ввод

        System.out.println("Сколько дней до зарплаты?");

        int daysBeforeSalary = scanner.nextInt(); //Ввод

        Converter converter = new Converter(78.5,88.7,0.75); // объявляем создангие конвертера

        DinnerAdvisor dinnerAdvisor = new DinnerAdvisor();

        ExpensesManager expensesManager = new ExpensesManager();

        while(true) {
            printMenu(); // Выводим меню
            int command = scanner.nextInt();

            if (command == 1){

                System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");

                System.out.println (" В какую валюту вы хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR"
                        + "3-JPY.");
                int currency = scanner.nextInt(); // объявляем ввод числа
                converter.convert(moneyBeforeSalary, daysBeforeSalary); // Объявляем класс конвертер с методом конверт, с аргументами.
            } else if (command == 2) {
                dinnerAdvisor.getAdvice(moneyBeforeSalary, daysBeforeSalary);
            } else if (command ==3){
                System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
                int day = scanner.nextInt();
                System.out.println("Введите размер траты:");
                double expense = scanner.nextDouble();

                moneyBeforeSalary = expensesManager.saveExpense(moneyBeforeSalary,expense,day); // Объявляем объекь трат
            } else if ( command == 4) {
                expensesManager.printAllExpenses(); // вызываем метод распечатки трат
            } else if (command == 5) {
                System.out.println("Самая большая сумма расходов на этой неделе составила "
                        + expensesManager.findMaxExpense() + " руб.");
            } else if (command == 0) {
                System.out.println("Выход");
            } else {
                System.out.println(" Извините, такой команды пока нет.");
            }

        }
    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Конвертировать валюту");
        System.out.println("2 - Получить совет");
        System.out.println("3 - Ввести трату");
        System.out.println("4 - Показать траты за неделю");
        System.out.println("5 - Показать самую большую сумму расходов за неделю");
        System.out.println("0 - Выход");
    }
}



