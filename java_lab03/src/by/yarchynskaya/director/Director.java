package by.yarchynskaya.director;

import by.yarchynskaya.company.Company;
import by.yarchynskaya.team.Worker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

public class Director implements IDirector {
    private static final Logger LOG = Logger.getLogger(Director.class);
    public String name;

    public Director(String name) {
        this.name = name;
        System.out.println("\t* Добавлен ДИРЕКТОР: " + this.name);
    }

    public Director() {
        System.out.println("\t* Добавлен ДИРЕКТОР");
    }

    @Override
    public int countWorkers(Company com) {
        ArrayList<Worker> arr = com.getStaff();
        return arr.size();
    }

    @Override
    public void sortBySalary(Company com) {
        ArrayList<Worker> arr = com.getStaff();
        if(arr == null)
            System.out.println("Сотрудники отсутствуют");
        else {
            arr.sort(new Comparator<Worker>() {
                @Override
                public int compare(Worker o1, Worker o2) {
                    return o1.getSalary() > o2.getSalary() ? -1 : o1.getSalary() < o1.getSalary() ? 1 : 0;
                }
            });
        }
        LOG.info("\n====== Sorted by salary");
    }

    @Override
    public void searchByExp(Company com, int exp) {
        System.out.println("Поиск сотрудников с опытом работы " + exp + " лет: ");
        if(com == null)
            throw new NullPointerException("Null pointer");
        ArrayList<Worker> arr = com.getStaff();
        for (Worker worker: arr) {
            if(worker.getExperience() == exp)
                System.out.println(worker.toString());
        }
    }
}
