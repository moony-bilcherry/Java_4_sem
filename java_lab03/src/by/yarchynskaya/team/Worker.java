package by.yarchynskaya.team;

public class Worker {
    public String surname;
    public String name;
    public int age;
    public int salary;
    public int exprerience;

    public Worker(String surname, String name, int age, int salary, int exprerience) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.exprerience = exprerience;
    }

    public Worker() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExprerience() {
        return exprerience;
    }
    public void setExprerience(int exprerience) {
        this.exprerience = exprerience;
    }

    @Override
    public String toString() {
        return "\n\t* СОТРУДНИК " + surname + ' ' + name +
                ":\n\t\tВозраст: " + age + ", З/П: " + salary + ", стаж: " + exprerience;
    }
}
