package com.bitlabs.employee;

import java.util.Scanner;

class App {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("\n-- WELCOME Employee Management System --");
            System.out.println("1. Employee Registration");
            System.out.println("2. Show All Employee");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Details");
            System.out.println("5. Delete Employee Details");
            System.out.println("6. Exit");

            System.out.println("Enter the Choice");
             choice= sc.nextInt();

            switch (choice) {
                case 1:
                    empRegistration();
                    break;
                case 2:
                    showAllEmployees();
                    break;
                case 3:
                    getEmpById();
                    break;
                case 4:
                    updateEmp();
                    break;
                case 5:
                    deleteEmp();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    public static void empRegistration() {
        Scanner sc = new Scanner(System.in);
        int eno, esal;
        String ename;
        System.out.println("Enter Employee Number:");
        eno = sc.nextInt();
        System.out.println("Enter Employee Name:");
        ename = sc.next();
        System.out.println("Enter Employee Salary:");
        esal = sc.nextInt();
        EmpDaoInterface dao = new EmpDaoImpl();
        Emp e = new Emp();
        e.setEno(eno);
        e.setEname(ename);
        e.setEsal(esal);
        dao.empRegistration(e);
    }

    public static void showAllEmployees() {
        EmpDaoInterface dao = new EmpDaoImpl();
        dao.showAllEmployees();
    }

    public static void getEmpById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID to search:");
        int eno = sc.nextInt();
        EmpDaoInterface dao = new EmpDaoImpl();       		
        dao.getEmpById(eno);
    }

    public static void updateEmp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID to update:");
        int eno = sc.nextInt();
        EmpDaoInterface dao = new EmpDaoImpl();
        Emp e = new Emp();
        

        System.out.println("Enter new details:");
        System.out.print("Enter Employee Name: ");
        String ename = sc.next();
        System.out.print("Enter Employee Salary: ");
        int esal = sc.nextInt();

        e.setEname(ename);
        e.setEsal(esal);
        dao.updateEmp(eno, e);
        System.out.println("Employee information updated successfully!");
    }

    public static void deleteEmp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID to delete:");
        int eno = sc.nextInt();
        EmpDaoInterface dao = new EmpDaoImpl();
        dao.deleteEmp(eno);
        System.out.println("Employee with ID " + eno + " deleted successfully!");
    }
}
