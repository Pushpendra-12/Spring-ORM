package com.springORM;

import com.springORM.dao.StudentDao;
import com.springORM.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("********* Welcome to Spring ORM *********");
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while (go){

            System.out.println("Press 1 for add new Student");
            System.out.println("Press 2 for display all Student");
            System.out.println("Press 3 for get single student Student");
            System.out.println("Press 4 for delete Student");
            System.out.println("Press 5 for update Student");
            System.out.println("Press 6 for exit");

            try {
                int choice = Integer.parseInt(br.readLine());
                switch (choice){
                    case 1:
                        System.out.println("Enter student id");
                        int uid = Integer.parseInt(br.readLine());

                        System.out.println("Enter student name");
                        String uName = br.readLine();

                        System.out.println("Enter student city");
                        String uCity = br.readLine();

                        Student student = new Student();
                        student.setStudentId(uid);
                        student.setName(uName);
                        student.setCity(uCity);
                        studentDao.insert(student);
                        System.out.println("------Student Inserted--------");
                        break;
                    case 2:
                        List<Student> studentList = studentDao.getAll();
                        System.out.println("Getting all students details");
                        for (Student st : studentList){
                            System.out.println("---------------------------------");
                            System.out.println("Id : " + st.getStudentId());
                            System.out.println("Name : " + st.getName());
                            System.out.println("City : " + st.getCity());
                            System.out.println("---------------------------------");
                        }
                        System.out.println("*********************************");
                        break;
                    case 3:
                        System.out.println("Enter student id");
                        int sId = Integer.parseInt(br.readLine());

                        Student single = studentDao.getOne(sId);
                        System.out.println("---------------------------------");
                        System.out.println("Id : " + single.getStudentId());
                        System.out.println("Name : " + single.getName());
                        System.out.println("City : " + single.getCity());
                        System.out.println("---------------------------------");
                        break;
                    case 4:
                        System.out.println("Enter student id");
                        int Id = Integer.parseInt(br.readLine());
                        studentDao.delete(Id);
                        System.out.println("------------Deleted----------------");
                        System.out.println("*************************************");
                        break;
                    case 5:
                        System.out.println("Enter student Id to update");
                        int upId = Integer.parseInt(br.readLine());

                        System.out.println("Enter student name to update");
                        String name = br.readLine();

                        System.out.println("Enter city to update");
                        String city = br.readLine();

                        Student student2 = new Student();
                        student2.setStudentId(upId);
                        student2.setName(name);
                        student2.setCity(city);
                        studentDao.update(student2);
                        System.out.println("Student details updated");
                        System.out.println("**********************************");
                        break;
                    case 6:
                        go = false;
                        break;
                }


            }catch (Exception e){
                System.out.println("Invalid input");
                System.out.println(e.getMessage());
            }
        }

    }
}
