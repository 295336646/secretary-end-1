package usts.cl.bean;

import lombok.Data;

@Data
public class Grade {
    private Integer id;

    private Byte advisorGrade;

    private Byte reviewGrade;

    private Byte replyGrade;

    private Byte totalGrade;

    private Byte task;

    private Byte technology;

    private Byte language;

    private Byte answer;

    private String comments;

    private String generalComments;
}