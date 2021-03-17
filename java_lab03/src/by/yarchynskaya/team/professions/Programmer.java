package by.yarchynskaya.team.professions;

import by.yarchynskaya.team.Worker;

public class Programmer extends Worker {
    ProgrammerType level;

    public Programmer(String surname, String name, int age, int salary, int exprerience) {
        super(surname, name, age, salary, exprerience);
    }

    public Programmer(String surname, String name, int age, int salary, int exprerience, ProgrammerType level) {
        super(surname, name, age, salary, exprerience);
        this.level = level;
    }

    public Programmer(ProgrammerType level) {
        super();
        this.level = level;
    }

    public Programmer() {
        super();
    }

    public ProgrammerType getLevel() {
        return level;
    }

    public void setLevel(ProgrammerType level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "\n\t* ПРОГРАММИСТ " + surname + ' ' + name +
                ":\n\t\tУровень: " + level +
                "\n\t\tВозраст: " + age + ", З/П: " + salary + ", стаж: " + exprerience;
    }
}
