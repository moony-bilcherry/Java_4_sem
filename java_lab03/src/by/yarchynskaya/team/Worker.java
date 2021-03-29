package by.yarchynskaya.team;

import org.apache.log4j.Logger;

public class Worker {
    private static final Logger LOG = Logger.getLogger(Worker.class);

    public String surname;
    public String name;
    public int age;
    public int salary;
    public int experience;

    public Worker(String surname, String name, int age, int salary, int experience) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.experience = experience;
        LOG.info("\t\n* Added worker");
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

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "\n\t* СОТРУДНИК " + surname + ' ' + name +
                ":\n\t\tВозраст: " + age + ", З/П: " + salary + ", стаж: " + experience;
    }
}
