package BookClass;

public class Book {
    private int id;
    private double price;

    public String name;
    public String author;
    public String publication;
    public int year;
    public int numPages;

    public Book(int id, double price, String name, String author, String publication, int year, int numPages) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.year = year;
        this.numPages = numPages;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean checkAuthor(String inputAuthor) {
        return this.author.equalsIgnoreCase(inputAuthor);
    }

    public boolean checkPublication(String inputPublication) {
        return this.publication.equalsIgnoreCase(inputPublication);
    }

    public boolean checkYearAfter(int inputYear) {
        return this.year >= inputYear;
    }

    public String toString() {
        return "Назва: " + this.name + ", Автор: " + this.author + ", Рік: " + this.year + ", Ціна: " + this.price + "\nID: " + this.id + ", Кількість сторінок: " + this.numPages + ", Видавництво: " + this.publication;
    }
}
