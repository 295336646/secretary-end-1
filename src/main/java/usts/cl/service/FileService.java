package usts.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.File;
import usts.cl.dao.FileMapper;

import java.util.List;

@Service
public class FileService {
    @Autowired
    FileMapper fileMapper;

    public boolean uploadFile(File file) {
        fileMapper.insertSelective(file);
        return true;
    }

    public File downFile(Integer fileId) {
        return fileMapper.selectByPrimaryKey(fileId);
    }

//    public List<File> showDownFiles() {
//        return fileMapper.selectByExampleWithUser(null);
//    }
}
