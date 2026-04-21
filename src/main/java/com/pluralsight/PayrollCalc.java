package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the employee file to process: ");
        String fileName = scanner.nextLine();

        System.out.println("Enter the name of the payroll file to create: ");
        String newFile = scanner.nextLine();



        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));

            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split("\\|");
                int id = Integer.parseInt(info[0]);
                String name = info[1];
                double hours = Double.parseDouble(info[2]);
                double rate = Double.parseDouble(info[3]);

                Employees employee = new Employees(id, name, hours, rate);

                double grossPay = employee.getGrossPay();
                String employeeName = employee.getName();
                int employeeId = employee.getEmployeeId();

                String newEmployee = ("ID: " + employeeId + ", Name: " + employeeName + ", Gross Pay: " + grossPay);

                bufferedWriter.write(newEmployee);

                bufferedWriter.close();

                // System.out.println("ID: " + employeeId + ", Name: " + employeeName + ", Gross Pay: " + grossPay);
            }
            bufferedReader.close();









        }
        catch (Exception e) {
            System.out.println("Sorry an error occured!");
        }



    }
}
