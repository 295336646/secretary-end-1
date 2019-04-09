package usts.cl.bean;

import java.util.ArrayList;
import java.util.List;

public class Team implements Cloneable {
    private List<Teacher> teachers = new ArrayList<>();
    //    private List<Student> exchangeStudents = new ArrayList<>();
    private int number;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        Team team = null;
        try {
            //浅克隆
            team = (Team) super.clone();
            //深克隆
            List<Teacher> listBeans = new ArrayList<>();
            for (Teacher itemList :
                    teachers) {
                listBeans.add((Teacher) itemList.clone());
            }
            teachers = listBeans;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return team;
    }

    @Override
    public String toString() {
        return "Team{number=" + number + '}';
    }

}
