package by.yarchynskaya;

import by.yarchynskaya.director.Director;
import by.yarchynskaya.team.*;
import by.yarchynskaya.company.*;
import by.yarchynskaya.team.professions.Engineer;
import by.yarchynskaya.team.professions.Programmer;
import by.yarchynskaya.team.professions.ProgrammerType;
import by.yarchynskaya.team.professions.SystemAdmin;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/*Определить иерархию сотрудников: инженер, сис админ,
программисты (junior, senior и т.п.). Набрать компанию по заданному плану
набора. Создать директора. Его функции: подсчитать сотрудников,
отсортировтаь по зарплате, найти сотрудников с заданным уровнем навыков*/

public class Main {
    static{
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Starting program_____________________________");

        Company SurveyCorps = new Company("SurveyCorps");
        System.out.println(SurveyCorps.toString());

        Director dir = new Director("Эрвин");

        Worker worker1 = new Worker("Ботт", "Марко", 27,450,2);
        Engineer engineer1 = new Engineer("Йегер", "Эрен", 19, 780, 1);
        SystemAdmin admin1 = new SystemAdmin("Браун", "Райнер", 21, 1450,4);
        Programmer progger1 = new Programmer("Арлерт", "Армин", 19, 1190, 2);
        progger1.setLevel(ProgrammerType.Junior);

        SurveyCorps.addWorker(worker1);
        SurveyCorps.addWorker(engineer1);
        SurveyCorps.addWorker(admin1);
        SurveyCorps.addWorker(progger1);
        System.out.println(SurveyCorps.toString());

        System.out.println("Количество сотрудников комании " + SurveyCorps.company_name + ": " + dir.countWorkers(SurveyCorps));
        dir.sortBySalary(SurveyCorps);
        System.out.println(SurveyCorps.toString());
        dir.searchByExp(SurveyCorps, 2);
    }
}
