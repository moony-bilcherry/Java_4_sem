package by.yarchynskaya;

public class Author {
    public String id;
    public String fio;
    public String country;

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", fio='" + fio + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
