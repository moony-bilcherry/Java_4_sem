package by.yarchynskaya;

public class Book {
    public String id;
    public String title;
    public String author;
    public int released;
    public String publisher;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", released=" + released +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
