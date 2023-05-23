package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;


import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==== TEST 1: Department findById ====");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n==== TEST 2: Department findAll ====");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n==== TEST 3: Department insert ====");
        Department newDepartment = new Department(null, "Books");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n==== TEST 4: Department update ====");
        department = departmentDao.findById(7);
        department.setName("Bermudas");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n==== TEST 5: Department delete ====");
        System.out.println("Enter id for delete Department");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

    }


}
