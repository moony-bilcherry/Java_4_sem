package by.yarchynskaya.director;

import by.yarchynskaya.company.Company;
import by.yarchynskaya.team.Worker;

public interface IDirector {
    int countWorkers(Company com);
    void sortBySalary(Company com);
    void searchByExp(Company com, int exp);
}
