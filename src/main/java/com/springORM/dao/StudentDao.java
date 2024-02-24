package com.springORM.dao;

import com.springORM.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class StudentDao {

    private HibernateTemplate hibernateTemplate;
    @Transactional
    public int insert (Student student){
        int res = (int)this.hibernateTemplate.save(student);
        return res;
    }

    public Student getOne(int Sid){
       Student student = this.hibernateTemplate.get(Student.class, Sid);
       return student;
    }

    public List<Student> getAll(){
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    @Transactional
    public void delete(int Sid){
       Student student = this.hibernateTemplate.get(Student.class,Sid);
       this.hibernateTemplate.delete(student);
    }
    @Transactional
    public void update(Student student){
        this.hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
