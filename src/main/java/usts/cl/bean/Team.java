package usts.cl.bean;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> exchangeStudents = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private int number;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getExchangeStudents() {
        return exchangeStudents;
    }

    public void setExchangeStudents(List<Student> exchangeStudents) {
        this.exchangeStudents = exchangeStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Team{number=" + number + '}';
    }
}
