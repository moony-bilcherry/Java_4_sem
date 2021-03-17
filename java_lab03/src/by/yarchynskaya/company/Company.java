package by.yarchynskaya.company;

import by.yarchynskaya.team.*;

import java.util.ArrayList;

public class Company {
    public String company_name;

    public Company(String company_name) {
        this.company_name = company_name;
    }

    ArrayList<Worker> staff = new ArrayList<>();

    public ArrayList<Worker> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Worker> staff) {
        if(staff == null)
            throw new NullPointerException("Null pointer");
        this.staff = staff;
    }

    public void addWorker(Worker worker) {
        if(worker == null)
            throw new NullPointerException("Null pointer");
        System.out.println("В компанию " + this.company_name + " добавлен: " + worker.toString());
        this.staff.add(worker);
    }

    public Company() {
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    @Override
    public String toString() {
        return "\n---------------------------------------------" +
                "\n\t\tКОМПАНИЯ " + company_name +
                "\nШтат сотрудников: " + staff +
                "\n---------------------------------------------\n";
    }
}
