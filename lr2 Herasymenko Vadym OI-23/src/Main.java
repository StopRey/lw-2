import BookClass.Book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[15];
        createArray(books);

        printStart(books, scanner);
    }

    public static void createArray(Book[] books) {
        books[0] = new Book(1000, 300.2, "1984", "Джордж Орвелл", "Клуб сімейного дозвілля", 2020, 213);
        books[1] = new Book(1001, 254.75, "Який чудесний світ новий", "Олдос Гакслі", "Видавництво Ранок", 2016, 234);
        books[2] = new Book(1002, 167, "Теорії змов: як не стати конспірологом", "Максим Яковєв", "Клуб сімейного дозвілля", 2014, 150);
        books[3] = new Book(1003, 540.3, "Танці з кістками", "Андрій Сем'янків", "Клуб сімейного дозвілля", 2023, 333);
        books[4] = new Book(1004, 340, "Андрофаги", "Данило Клочко", "Підручники і посібники", 2012, 57);
        books[5] = new Book(1005, 234.5, "Я бачу, вас, цікавить пітьма", "Ілларіон Павлюк", "Видавництво Генеза", 2020, 234);
        books[6] = new Book(1006, 300, "Дев'ятий дім", "Лі Бардуґо", "Підручники і посібники", 1891, 123);
        books[7] = new Book(1007, 250, "Колекціонер", "Джон Фауз", "Клуб сімейного дозвілля", 2012, 321);
        books[8] = new Book(1008, 260.5, "Столітній чоловік, що виліз у вікно і зник", "Юнанс Юнассон", "Підручники і посібники", 2010, 450);
        books[9] = new Book(1009, 859.5, "Сад Гетсиманський", "Іван Багряний", "Видавництво Ранок", 2012, 450);
        books[10] = new Book(1010, 490, "Кобзар", "Тарас Шевченко", "Видавництво Генеза", 1840, 258);
        books[11] = new Book(1011, 145.5, "Катерина", "Тарас Шевченко", "Видавництво Ранок", 1840, 312);
        books[12] = new Book(1012, 240, "Гайдамаки", "Тарас Шевченко", "Видавництво Ранок", 1841, 443);
        books[13] = new Book(1013, 309.9, "Бояриня", "Леся Українка", "Видавництво Генеза", 1914, 341);
        books[14] = new Book(1014, 283.25, "Біда навчить", "Леся Українка", "Видавництво Генеза", 1891, 57);
    }

    public static void printStart(Book[] books, Scanner scanner) {
        System.out.println("Виберіть один із пунктів нижче:");
        System.out.println("1. Список книг за автором");
        System.out.println("2. Список книг за видавництвом");
        System.out.println("3. Список книг, що випущені після заданого року");

        int num = scanner.nextInt();
        scanner.nextLine();

        if (num == 1) {
            booksByAuthor(books, scanner);
        } else if (num == 2) {
            booksByPublication(books, scanner);
        } else if (num == 3) {
            booksByYear(books, scanner);
        } else {
            System.out.println("Помилка введення");
            printStart(books, scanner);
        }
    }

    public static void booksByAuthor(Book[] books, Scanner scanner) {
        System.out.print("Введіть Автора: ");
        String inputAuthor = scanner.nextLine();

        int count = 1;
        System.out.println("Список книг за автором:");
        for (int i = 0; i < 15; i++) {
            if (books[i].checkAuthor(inputAuthor)) {
                System.out.print(count + ". " + books[i] + "\n\n");
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Такі книги відсутні");
        }
    }

    public static void booksByPublication(Book[] books, Scanner scanner) {
        System.out.println("Список книг за видавництвом:");
        String inputPublication = scanner.nextLine();

        int count = 1;
        System.out.println("Список книг за видавництвом:");
        for (int i = 0; i < 15; i++) {
            if (books[i].checkPublication(inputPublication)) {
                System.out.print(count + ". " + books[i] + "\n\n");
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Такі книги відсутні");
        }
    }

    public static void booksByYear(Book[] books, Scanner scanner) {
        System.out.println("Список книг, що випущені після заданого року:");
        int inputYear = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Список книг за роком:");

        int count = 1;
        for (int i = 0; i < 15; i++) {
            if (books[i].checkYearAfter(inputYear)) {
                System.out.print(count + ". " + books[i] + "\n\n");
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Такі книги відсутні");
        }
    }
}