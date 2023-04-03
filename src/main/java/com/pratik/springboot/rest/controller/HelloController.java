package com.pratik.springboot.rest.controller;

import com.pratik.springboot.rest.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/sendData")
    public ModelAndView sendData() {
        ModelAndView mav = new ModelAndView("data");
        mav.addObject("message", "If you are good at something, never do it for free");
        return mav;
    }

    @RequestMapping("/student")
    public ModelAndView getStudent() {
        ModelAndView mav = new ModelAndView("student");
        Student student = new Student();
        student.setName("Pratik");
        student.setScore(100);
        mav.addObject("student", student);
        return mav;
    }

    @RequestMapping("/students")
    public ModelAndView getStudents() {
        ModelAndView mav = new ModelAndView("studentList");
        Student student1 = new Student();
        student1.setName("Pratik1");
        student1.setScore(1001);

        Student student2 = new Student();
        student2.setName("Pratik2");
        student2.setScore(1002);

        Student student3 = new Student();
        student3.setName("Pratik3");
        student3.setScore(1003);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        mav.addObject("students", studentList);
        return mav;
    }

    @RequestMapping("/studentForm")
    public ModelAndView displayStudentForm() {
        ModelAndView mav = new ModelAndView("studentForm");
        Student student = new Student();
        student.setName("Pratik");
        student.setScore(100);
        mav.addObject("student", student);
        return mav;
    }

    @RequestMapping("/saveStudent")
    public ModelAndView saveStudentData(@ModelAttribute Student student) {
        ModelAndView mav = new ModelAndView("result");
        //Student student = new Student();
        mav.addObject("student", student);
        System.out.println(student.getName());
        System.out.println(student.getScore());
        return mav;
    }
}
