package usts.cl.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Group implements Serializable{
    private String sid;

    private String sclass;

    private String sname;

    private String tid;

    private String tname;

    private String cname;

    private String tjudge;

    private String tjudgename;

    private Integer groupnum;

    private Byte leader;

    private Student student;

    private Teacher teacher;

    private Grade grade;

}