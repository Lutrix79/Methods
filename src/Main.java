import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void countAndPrintLeapYear(int currentYear) {
//        if (currentYear < 1584) {
//            System.out.println("Начиная с 1584 года, в григорианском календаре были введены високосные года");
        if ((currentYear % 100 == 0) &&  (currentYear % 400 != 0) || (currentYear < 1584)) {
            System.out.println(currentYear + " год - невисокосный год");
        } else if (currentYear % 4 == 0) {
            System.out.println(currentYear + " год - високосный год");
        } else System.out.println(currentYear + " год - невисокосный год");
    }

    public static void printRecommendationsForClients(int clientOS, int clientDeviceYear) {
        if (clientDeviceYear >= 2015  && clientDeviceYear <= 2025) {
            if (clientOS == 0) {
                System.out.println("Установите версию приложения для iOS по ссылке");
            } else if (clientOS == 1) {
                System.out.println("Установите версию приложения для Android по ссылке");
            } else {
                System.out.println("Для такой ОС у нас нет приложения (((");
            }
        } else if (clientDeviceYear >= 2000 && clientDeviceYear < 2015) {
            if (clientOS == 0)  {
                System.out.println("Установите облегченную версию приложения для iOS по ссылке");
            } else if (clientOS == 1) {
                System.out.println("Установите облегченную версию приложения для Android по ссылке");
            } else {
                System.out.println("Для такой ОС у нас нет приложения (((");
            }
        } else {
            System.out.println("Неверная дата выпуска");
        }
    }

    public static int countDaysForDelivery(int distance) {
        //Требуемые дни для доставки без учета доп суток:
        int days = distance / 20;
        if (distance <= 20 && distance >= 0) {
            days += 1;
        } else if (distance > 20 && distance <= 60) {
            days += 2;
        } else if (distance > 60 && distance <= 100) {
            days += 3;
        } else return  -1 ;
        return days;
    }

    public static void main(String[] args) {
        //Задача №1
        System.out.println("Задача 1");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите интересующий Вас год, чтобы узнать, является ли он високосным ");
        int year = scanner.nextInt();
        countAndPrintLeapYear(year);

        System.out.println();
        //Задача №2
        System.out.println("Задача 2");
        System.out.print("Введите операционную систему (0 - iOS, 1 - Android) ");
        int clientOS = scanner.nextInt();
        System.out.print("Введите год создания смартфона (если введёте 0, тогда будет использована текущая дата) ");
        int clientDeviceYear = scanner.nextInt();
        if (clientDeviceYear == 0){
            clientDeviceYear = LocalDate.now().getYear();
        }
        printRecommendationsForClients(clientOS, clientDeviceYear);

        System.out.println();
        //Задача №3
        System.out.println("Задача 3");
        System.out.print("Введите расстояние до адреса доставки клиенту карты банка в км ");
        int deliveryDistance = scanner.nextInt();
        int requireDays = countDaysForDelivery(deliveryDistance); //Требуемые дни для доставки
        if (requireDays == -1) {
            System.out.println("Непозволительная дистанция доставки (доставка производится от 0 до 100 км)");
        } else {
            System.out.println("Доставка займет " + requireDays + " дней");
        }
    }
}