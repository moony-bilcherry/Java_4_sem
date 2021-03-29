package by.yarchynskaya.team.professions;

import by.yarchynskaya.team.Worker;

public class Engineer extends Worker {

    public Engineer(String surname, String name, int age, int salary, int exprerience) {
        super(surname, name, age, salary, exprerience);
    }

    public Engineer() {
        super();
    }

    @Override
    public String toString() {
        return "\n\t* ИНЖЕНЕР " + surname + ' ' + name +
                ":\n\t\tВозраст: " + age + ", З/П: " + salary + ", стаж: " + experience;
    }
}
