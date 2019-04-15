package usts.cl.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Team implements Cloneable {
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private int number;

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

}
