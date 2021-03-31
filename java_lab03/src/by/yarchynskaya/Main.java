package by.yarchynskaya;

import by.yarchynskaya.director.Director;
import by.yarchynskaya.lab04.SaxParser;
import by.yarchynskaya.team.*;
import by.yarchynskaya.company.*;
import by.yarchynskaya.team.professions.Engineer;
import by.yarchynskaya.team.professions.Programmer;
import by.yarchynskaya.team.professions.ProgrammerType;
import by.yarchynskaya.team.professions.SystemAdmin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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
        Programmer progger1 = new Programmer("Арлерт", "Армин", 19, 1190, 2);
        Engineer engineer1 = new Engineer("Йегер", "Эрен", 19, 780, 1);
        SystemAdmin admin1 = new SystemAdmin("Браун", "Райнер", 21, 1450,4);
        Programmer progger2 = new Programmer("Кирштейн", "Жан", 20, 2320, 4, ProgrammerType.Middle);
        Programmer progger3 = new Programmer("Аккерман", "Леви", 35, 5500, 9, ProgrammerType.Senior);
        progger1.setLevel(ProgrammerType.Junior);

        SurveyCorps.addWorker(worker1);
        SurveyCorps.addWorker(engineer1);
        SurveyCorps.addWorker(admin1);
        SurveyCorps.addWorker(progger1);
        SurveyCorps.addWorker(progger2);
        SurveyCorps.addWorker(progger3);
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

        System.out.println("\n\t* Парс объектов из XML:");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxParser saxp = new SaxParser();
        parser.parse(new File(pathXml), saxp);

        Worker workerXML = saxp.getResult();
        System.out.println(workerXML.toString());
        SurveyCorps.addWorker(workerXML);

        System.out.println("\n\t* Сериализация в XML");
        FileOutputStream out = new FileOutputStream("files/Serialize.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(out);
        xmlEncoder.writeObject(workerXML);
        xmlEncoder.close();

        System.out.println("\n\t* Десериализация из XML");
        FileInputStream in = new FileInputStream("files/Serialize.xml");
        XMLDecoder xmlDecoder = new XMLDecoder(in);
        Worker workerXML2 = (Worker) xmlDecoder.readObject();
        xmlDecoder.close();
        System.out.println(workerXML2);

        System.out.println("\n\t* Сериализация в JSON");
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(workerXML);
        System.out.println(json);
        FileOutputStream jsonOut = new FileOutputStream("files/Serialize.json");
        byte[] outText = json.getBytes(StandardCharsets.UTF_8);
        jsonOut.write(outText, 0, outText.length);

        System.out.println("\n\t* Десериализация из JSON");
        Scanner scanner = new Scanner(new File("files/Serialize.json"));
        String result = "";
        while(scanner.hasNext())
            result += scanner.nextLine();
        scanner.close();
        Worker workerXML3 = gson.fromJson(result, Worker.class);
        System.out.println(workerXML3);


    }
}
