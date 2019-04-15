package usts.cl.bean;

import lombok.Data;

@Data
public class File {
    private Integer fileId;

    private String fileName;

    private String fileType;

    private String uid;

    private byte[] file;

}