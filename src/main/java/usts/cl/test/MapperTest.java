package usts.cl.test;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.FieldsDocumentPart;
import org.apache.poi.hwpf.usermodel.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import usts.cl.bean.*;
import usts.cl.dao.*;
import usts.cl.service.UserService;
import usts.cl.utils.PasswordHash;

import java.io.*;
import java.io.File;
import java.util.*;


/**
 * 测试dao层的工作
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    FileMapper fileMapper;
    @Autowired
    UserService userService;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    GradeMapper gradeMapper;

    @Test
    public void test() throws Exception {
        User user = userMapper.selectByPrimaryKey("30008");
        if (user != null) {
            System.out.println("用户已注册");
        } else {
            String[] params = PasswordHash.createHash("123").split(":");
            String hash = params[PasswordHash.PBKDF2_INDEX];
            String salt = params[PasswordHash.SALT_INDEX];
            userMapper.insert(new User("30008", "杨利娟", hash, salt, 2));
        }
//        UserExample userExample = new UserExample();
//        Criteria criteria = userExample.createCriteria();
//        criteria.andUidEqualTo("152040135120");
//        List<User> list = userMapper.selectByExample(userExample);
//        long count = userMapper.countByExample(userExample);
//        System.out.println(count);
//        if (count == 1) {
//            for (User user : list
//                    ) {
//                String hash = user.getPassword();
//                String salt = user.getSalt();
//                System.out.println(user.getUsername());
//                System.out.println(PasswordHash.validatePassword("123", hash, salt));
//            }
//        }
    }

    @Test
    public void test2() {
        List<Student> list = studentMapper.selectByStudentWithGrade(null);
        for (Student student : list) {
            System.out.println("课题名称:" + student.getCourse().getCname());
            System.out.println("学生:" + student.getSname());
            System.out.println("课题类型:" + student.getCourse().getCtype());
            System.out.println("指导评分:" + student.getGrade().getAdvisorGrade());
            System.out.println("评阅评分:" + student.getGrade().getReviewGrade());
            System.out.println("答辩评分:" + student.getGrade().getReplyGrade());
            System.out.println("总成绩:" + student.getGrade().getTotalGrade());
            System.out.println("总评:" + student.getGrade().getGeneralComments());
        }
    }

    @Test
    @Ignore
    public void test3() {
//        List<File> list = fileMapper.selectByExampleWithUser(null);
//        System.out.println(list);
    }

    @Test
    @Ignore
    public void test4() {
        String strs = "321d.doc".substring("321d.doc".lastIndexOf("."));
        System.out.println(strs);
//        for (String str :
//                strs) {
//            System.out.println(str);
//        }
    }

    @Test
    public void test5() {
//        Grade grade = new Grade();
//        grade.setReplyGrade((byte) 72);
//        grade.setTotalGrade((byte) 72);
//        System.out.println(gradeMapper.updateBySidSelective(grade, "1220126125"));
        System.out.println(gradeMapper.selectBySid("1220126125"));
    }

    @Test
    public void test6() {
        List<Teacher> teacherList = teacherMapper.selectByExample(null);
        List<Student> studentList = studentMapper.selectByExample(null);
        List<Team> teams = new ArrayList<>();
        int si = studentList.size();
        int tj = teacherList.size();
        int avg = si / tj;
        int sb = 0, tb = 0;
        int k = 0;
        while (sb != studentList.size() && tb != teacherList.size()) {
            for (; avg > 0; avg--) {
                teacherList.get(tb).getStudents().add(studentList.get(sb));
                ++sb;
                --si;
            }
//            Team team = new Team();
//            if (tb % 3 == 0) {
//                k++;
//                List<Teacher> teachers = new ArrayList<>();
//                teachers.add(teacherList.get(tb));
//                teachers.add(teacherList.get(tb + 1));
//                teachers.add(teacherList.get(tb + 2));
//                team.setTeachers(teachers);
//                team.setNumber(k);
//                teacherList.get(tb).setTeam(team);
//                teams.add(team);
//            } else {
//                team.setNumber(k);
//                teacherList.get(tb).setTeam(team);
//            }
//            for (Student student : teacherList.get(tb).getStudents()) {
//                student.setTeam(team);
//            }
            --tj;
            ++tb;
            if (0 == si || 0 == tj) break;
            avg = si / tj;
        }
//        for (Teacher t : teacherList) {
//            teams.get(t.getTeam().getNumber() - 1).getStudents().addAll(t.getStudents());
//        }
//        List<Student> temp = new ArrayList<>();
//        temp.addAll(teacherList1.get(0).getStudents());
//        temp.addAll(teacherList1.get(1).getStudents());
//        temp.addAll(teacherList1.get(2).getStudents());
//        Map<String, Student> map = new HashMap<>();
//        for (Student s : teams.get(0).getStudents()) {
//            map.put(s.getSid(), s);
//        }
//        for (Student s : temp) {
//            if (map.containsKey(s.getSid())) {
//                teams.get(0).getStudents().remove(map.get(s.getSid()));
//                teams.get(0).getExchangeStudents().add(map.get(s.getSid()));
//            }
//        }
//
//        for (Student student : teams.get(0).getStudents()) {
//            System.out.println(student.getSname());
//        }
//        for (Student exchange: teams.get(0).getExchangeStudents()) {
//            System.out.println(exchange.getSname());
//        }
//        System.out.println(teams.get(1).getStudents());
//        System.out.println(teacherList.get(1).getStudents().size());

    }


    //矩阵算法
    @Test
    public void test8() {
        List<Team> teams = new ArrayList<>();// 答辩分组
        this.group(teams);
        List<Student> studentList = studentMapper.selectByExample(null);// 所有学生
        List<Teacher> teacherList = teacherMapper.selectByExample(null);//所有老师
        int scount = studentList.size(); // 学生总数
        int tcount = teacherList.size();//老师总数
        int avg = scount / tcount;//每个老师平均分配多少学生
        int[][] students = new int[tcount][scount];
        int i = 0, j = 0;
        for (Team team : teams) {
            for (Teacher teacher : team.getTeachers()) {
                System.out.println("老师:" + teacher.getTname() + ",研究方向:" + teacher.getResearchDirection());
                System.out.print("学生:");
                for (Student student : teacher.getStudents()) {
                    System.out.println(student.getSname() + ",研究方向:" + student.getCourse().getCtype());
                }
                System.out.println("---------------------------------------------------------------------");
            }
        }
//        for (Team team : teams) {
//            for (Teacher teacher : team.getTeachers()) {
//                for (Student student : teacher.getStudents()) {
//                    for (Student stu : studentList) {
//                        if (student.getSid().equals(stu.getSid())) {
//                            students[i][studentList.indexOf(stu)] = 1;
//                        }
//                    }
//                }
//                i++;
//            }
//        }
//        for (i = 0; i < tcount; i++) {
//            for (j = 0; j < scount; j++) {
//                System.out.print(students[i][j]);
//            }
//            System.out.println();
//        }
//        j = 0;
//        for (i = 0; i < teams.get(0).getTeachers().size(); i++, j++) {
//            System.out.println(students[j][0]);
//        }
    }

    @Test
    public void test10() {
//        List<Team> teams = new ArrayList<>();// 答辩分组
//        this.group(teams);
//        List<Student> studentList = studentMapper.selectByExample(null);// 所有学生
//        List<Teacher> teacherList = teacherMapper.selectByExample(null);//所有老师
//        List<Student> studentGroup = studentMapper.selectByStudentWithGroup(null);
//        Set<String> set = new HashSet<>();
//        for (Student student : studentGroup) {
//            set.add(student.getCourse().getCtype());
//        }
//        List<String> cType = new ArrayList(set);
//        int[][] ts = new int[teacherList.size()][studentList.size()];
//        int[][] sc = new int[studentList.size()][cType.size()];
//        int[][] tc = new int[teacherList.size()][cType.size()];
//        int i = 0;
//        for (Student student : studentGroup) {
//            for (int j = 0; j < cType.size(); j++) {
//                if (cType.get(j).equals(student.getCourse().getCtype()))
//                    sc[i][j] = 1;
//            }
//            i++;
//        }
//        i = 0;
//        for (Team team : teams) {
//            for (Teacher teacher : team.getTeachers()) {
//                for (Student student : teacher.getStudents()) {
//                    for (Student stu : studentList) {
//                        if (student.getSid().equals(stu.getSid())) {
//                            ts[i][studentList.indexOf(stu)] = 1;
//                        }
//                    }
//                }
//                i++;
//            }
//        }
//        for (i = 0; i < teacherList.size(); i++) {
//            for (int j = 0; j < cType.size(); j++) {
//                for (int k = 0; k < studentList.size(); k++) {
//                    tc[i][j] += ts[i][k] * sc[k][j];
//                }
//            }
//        }
//        for (i = 0; i < cType.size(); i++) {
//            System.out.println(cType.get(i));
//        }
//        for (i = 0; i < teacherList.size(); i++) {
//            for (int j = 0; j < cType.size(); j++) {
//                System.out.print(tc[i][j]);
//            }
//            System.out.println();
//        }
//        Iterator<String> iterator = cType.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }

    public void group(List<Team> teams) {
        long groupSize = teacherMapper.groupSize().size();// 分组总数
//        List<Student> studentList = studentMapper.selectByExample(null);// 所有学生
//        List<Teacher> teacherList = teacherMapper.selectByExample(null);//所有老师
//        Collections.shuffle(studentList);
        //将分配好的老师录入答辩分组
        for (int i = 1; i <= groupSize; i++) {
            Team team = new Team();
            team.setTeachers(teacherMapper.selectByTeacherWithGroup(i));
            team.setNumber(i);
            teams.add(team);
        }
//        int scount = studentList.size(); // 学生总数
//        int tcount = teacherList.size();//老师总数
//        int sbegin = 0;
//        int avg = scount / tcount;//每个老师平均分配多少学生
//        int k = 0, count = 0;
        // 学生平均分组
//        for (Student student : studentList) {
//            while (avg > 0) {
//                //学生答辩组
//                teams.get(k).getStudents().add(studentList.get(sbegin));
//                ++sbegin;
//                --scount;
//                avg--;
//            }
//
//            if ((count + 1) % 3 == 0) {
//                k++;
//            }
//            ++count;// 记录每隔3次换组
//            --tcount;
//            if (0 == scount || 0 == tcount) break;
//            avg = scount / tcount;
//        }
        //去除冲突数据，并将冲突数据提取出来以便调整
//        Map<String, Student> map = new HashMap<>();
//        for (Team team : teams) {
//            map.clear();
//            for (Student student : team.getStudents()) {
//                map.put(student.getSid(), student);
//            }
//            for (Teacher teacher : team.getTeachers()) {
//                for (Student student : teacher.getStudents()) {
//                    if (map.containsKey(student.getSid())) {
//                        team.getStudents().remove(map.get(student.getSid()));
//                        team.getExchangeStudents().add(map.get(student.getSid()));
//                    }
//                }
//            }
//        }

//        List<Integer> list = new ArrayList<>();
//        for (Team team : teams) {
//            if (!team.getExchangeStudents().isEmpty()) list.add(team.getNumber());
//        }
//        if (!list.isEmpty()) return this.group();
//        else {
//            for (Team team : teams) {
//                for (Student student : team.getStudents()) {
//                    student.setSgroup(team.getNumber());
//                    studentMapper.updateByPrimaryKeySelective(student);
//                }
//            }
//        }

    }

    @Test
    public void test9() {
        Map<String, String> map = new HashMap();
        map.put("${1}", "电子与信息工程学院");
        map.put("${2}", "计算机科学与技术");
        map.put("${3}", "14200107135");
        map.put("${4}", "李子晗");
        map.put("${5}", "基于云计算的哈希数据建模方法研究与实现");
        map.put("${6}", "83");
        map.put("${7}", "80");
        map.put("${8}", "82");
        map.put("${9}", "82");
        map.put("${10}", "良好");
        String srcPath = "D:\\IDEA\\secretary\\target\\secretary\\uploadfiles\\李子晗_14200107135_答辩评议书.doc";
        readwriteWord(srcPath, map);
    }

    /**
     * 实现对word读取和修改操作
     *
     * @param filePath word模板路径和名称
     * @param map      待填充的数据，从数据库读取
     */
    public static void readwriteWord(String filePath, Map<String, String> map) {
        // 读取word模板
        // String fileDir = new
        // File(base.getFile(),"http://www.cnblogs.com/http://www.cnblogs.com/../doc/").getCanonicalPath();
        FileInputStream in = null;
        try {
            in = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        HWPFDocument hdt = null;
        try {
            hdt = new HWPFDocument(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Fields fields = hdt.getFields();
        Iterator<Field> it = fields.getFields(FieldsDocumentPart.MAIN)
                .iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getType());
        }

//        //读取word文本内容
        Range range = hdt.getRange();
        TableIterator tableIt = new TableIterator(range);
        //迭代文档中的表格
        int ii = 0;
        while (tableIt.hasNext()) {
            Table tb = tableIt.next();
            ii++;
            System.out.println("第" + ii + "个表格数据...................");
            //迭代行，默认从0开始
            for (int i = 0; i < tb.numRows(); i++) {
                TableRow tr = tb.getRow(i);
                //只读前8行，标题部分
                if (i >= 8) break;
                //迭代列，默认从0开始
                for (int j = 0; j < tr.numCells(); j++) {
                    TableCell td = tr.getCell(j);//取得单元格
                    //取得单元格的内容
                    for (int k = 0; k < td.numParagraphs(); k++) {
                        Paragraph para = td.getParagraph(k);
                        String s = para.text();
                        System.out.println(s);
                    } //end for
                }   //end for
            }   //end for
        } //end while
        //System.out.println(range.text());

        // 替换文本内容
        for (Map.Entry<String, String> entry : map.entrySet()) {
            range.replaceText(entry.getKey(), entry.getValue());
        }
        ByteArrayOutputStream ostream = new ByteArrayOutputStream();
        String fileName = "" + System.currentTimeMillis();
        fileName += ".doc";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath + fileName, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            hdt.write(ostream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 输出字节流
        try {
            out.write(ostream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ostream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
