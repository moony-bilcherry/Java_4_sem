package by.yarchynskaya.team.professions;

import by.yarchynskaya.team.Worker;

public class SystemAdmin extends Worker {

    public SystemAdmin(String surname, String name, int age, int salary, int exprerience) {
        super(surname, name, age, salary, exprerience);
    }

    public SystemAdmin() {
        super();
    }

    @Override
    public String toString() {
        return "\n\t* СИС АДМИН " + surname + ' ' + name +
                ":\n\t\tВозраст: " + age + ", З/П: " + salary + ", стаж: " + experience;
    }
}
