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
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

/* 3 лаба:
Определить иерархию сотрудников: инженер, сис админ,
программисты (junior, senior и т.п.). Набрать компанию по заданному плану
набора. Создать директора. Его функции: подсчитать сотрудников,
отсортировтаь по зарплате, найти сотрудников с заданным уровнем навыков*/

public class Main {
    static{
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    /**
     * @param pathXml - путь к XML
     * @param pathXsd - путь к XSD
     */
    public static boolean checkXMLforXSD(String pathXml, String pathXsd)
            throws Exception {

        try {
            File xml = new File(pathXml);
            File xsd = new File(pathXsd);

            if (!xml.exists()) {
                System.out.println("Не найден XML " + pathXml);
            }

            if (!xsd.exists()) {
                System.out.println("Не найден XSD " + pathXsd);
            }

            if (!xml.exists() || !xsd.exists()) {
                return false;
            }

            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(pathXsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(pathXml));
            return true;
        } catch (SAXException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static void main(String[] args) throws Exception {
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

        System.out.println("\n======== 4 ЛАБА");

        System.out.println("\n\t* Валидация XML по схеме:");
        String pathXml = new String("files/example.xml");
        String pathXsd = new String("files/example.xsd");
        System.out.println("XML соответствует XSD : " + (Main.checkXMLforXSD(pathXml, pathXsd)));


    }
}
