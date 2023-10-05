import BookClass.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> allBooks = new ArrayList<>();
        createArray(allBooks);

        printStart(allBooks);
    }

    public static void createArray(ArrayList<Book> allBooks) {
        allBooks.add(new Book(1000, 300.2, "1984", "Джордж Орвелл", "Клуб сімейного дозвілля", 2020, 213));
        allBooks.add(new Book(1001, 254.75, "Який чудесний світ новий", "Олдос Гакслі", "Видавництво Ранок", 2016, 234));
        allBooks.add(new Book(1002, 167, "Теорії змов: як не стати конспірологом", "Максим Яковєв", "Клуб сімейного дозвілля", 2014, 150));
        allBooks.add(new Book(1003, 540.3, "Танці з кістками", "Андрій Сем'янків", "Клуб сімейного дозвілля", 2023, 333));
        allBooks.add(new Book(1004, 340, "Андрофаги", "Данило Клочко", "Підручники і посібники", 2012, 57));
        allBooks.add(new Book(1005, 234.5, "Я бачу, вас, цікавить пітьма", "Ілларіон Павлюк", "Видавництво Генеза", 2020, 234));
        allBooks.add(new Book(1006, 300, "Дев'ятий дім", "Лі Бардуґо", "Підручники і посібники", 1891, 123));
        allBooks.add(new Book(1007, 250, "Колекціонер", "Джон Фауз", "Клуб сімейного дозвілля", 2012, 321));
        allBooks.add(new Book(1008, 260.5, "Столітній чоловік, що виліз у вікно і зник", "Юнанс Юнассон", "Підручники і посібники", 2010, 450));
        allBooks.add(new Book(1009, 859.5, "Сад Гетсиманський", "Іван Багряний", "Видавництво Ранок", 2012, 450));
        allBooks.add(new Book(1010, 490, "Кобзар", "Тарас Шевченко", "Видавництво Генеза", 1840, 258));
        allBooks.add(new Book(1011, 145.5, "Катерина", "Тарас Шевченко", "Видавництво Ранок", 1840, 312));
        allBooks.add(new Book(1012, 240, "Гайдамаки", "Тарас Шевченко", "Видавництво Ранок", 1841, 443));
        allBooks.add(new Book(1013, 309.9, "Бояриня", "Леся Українка", "Видавництво Генеза", 1914, 341));
        allBooks.add(new Book(1014, 283.25, "Біда навчить", "Леся Українка", "Видавництво Генеза", 1891, 57));
    }

    public static void printStart(ArrayList<Book> allBooks) {
        Scanner scanner = new Scanner(System.in);

        int num;

        ArrayList<Book> sortedBooks = new ArrayList<>();;

        do{
            System.out.println("Виберіть один із пунктів нижче:");
            System.out.println("1. Список книг");
            System.out.println("2. Список книг за автором");
            System.out.println("3. Список книг за видавництвом");
            System.out.println("4. Список книг, що випущені після заданого року");
            System.out.println("5. Добавити книгу");
            System.out.println("6. Зарити програму");
            num = scanner.nextInt();
            scanner.nextLine();

            if (num == 1) {
                booksPrint(allBooks);
            }
            else if (num == 2) {
                sortedBooks.clear();
                booksByAuthor(allBooks, sortedBooks);
                booksPrint(sortedBooks);
            }
            else if (num == 3) {
                sortedBooks.clear();
                booksByPublication(allBooks, sortedBooks);
                booksPrint(sortedBooks);
            }
            else if (num == 4) {
                sortedBooks.clear();
                booksByYear(allBooks, sortedBooks);
                booksPrint(sortedBooks);
            }
            else if (num == 5) {
                createBook(allBooks);
            }
            else {
                System.out.println("Помилка введення");
            }
        }while(num!=6);
    }

    public static void booksPrint(ArrayList<Book> books){
        if (books.isEmpty()) {
            System.out.println("Такі книги відсутні\n");
            return;
        }
        int count=1;
        for(Book book:books){
            System.out.print(count + ". " + book + "\n\n");
            count++;
        }
    }

    public static void createBook(ArrayList<Book> allBooks){
        Scanner scanner = new Scanner(System.in);
        System.out.println("id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("price:");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("author:");
        String author = scanner.nextLine();
        System.out.println("publication:");
        String publication = scanner.nextLine();
        System.out.println("year:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("numPages:");
        int numPages = scanner.nextInt();
        scanner.nextLine();

        allBooks.add(new Book(id, price, name, author, publication, year, numPages));
    }

    public static void booksByAuthor(ArrayList<Book> allBooks, ArrayList<Book> sortedBooks) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть Автора: ");
        String inputAuthor = scanner.nextLine();

        for(Book book:allBooks){
            if(book.checkAuthor(inputAuthor)){
                sortedBooks.add(book);
            }
        }
    }

    public static void booksByPublication(ArrayList<Book> allBooks, ArrayList<Book> sortedBooks) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть видавництво: ");
        String inputPublication = scanner.nextLine();
        for(Book book:allBooks){
            if(book.checkPublication(inputPublication)){
                sortedBooks.add(book);
            }
        }
    }

    public static void booksByYear(ArrayList<Book> allBooks, ArrayList<Book> sortedBooks) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рік: ");
        int inputYear = scanner.nextInt();
        for(Book book:allBooks){
            if(book.checkYearAfter(inputYear)){
                sortedBooks.add(book);
            }
        }
    }
}