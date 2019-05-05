package usts.cl.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import usts.cl.bean.Group;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class Excel {
    /**
     * 实现对word修改操作
     *
     * @param filePath Excel存放路径
     */
    public static void write(String filePath, List<Group> groups) {
        try {
            Workbook wb = new XSSFWorkbook();
            //标题行抽出字段
            String[] title = {"学号", "班级", "姓名", "指导教工号",
                    "指导老师", "课题", "评阅教工号", "评阅老师",
                    "组号", "组长", "指导评分", "评阅评分", "答辩评分", "总评分"};
            //设置sheet名称，并创建新的sheet对象
            String sheetName = "答辩分组表";
            Sheet stuSheet = wb.createSheet(sheetName);
            //获取表头行
            Row titleRow = stuSheet.createRow(0);
            //创建单元格，设置style居中，字体，单元格大小等
            CellStyle style = wb.createCellStyle();
            Cell cell = null;
            //把已经写好的标题行写入excel文件中
            for (int i = 0; i < title.length; i++) {
                cell = titleRow.createCell(i);
                cell.setCellValue(title[i]);
                cell.setCellStyle(style);
            }
            //把从数据库中取得的数据一一写入excel文件中
            Row row = null;
            for (int i = 0; i < groups.size(); i++) {
                //创建list.size()行数据
                row = stuSheet.createRow(i + 1);
                //把值一一写进单元格里
                row.createCell(0).setCellValue(groups.get(i).getSid());
                row.createCell(1).setCellValue(groups.get(i).getSclass());
                row.createCell(2).setCellValue(groups.get(i).getSname());
                row.createCell(3).setCellValue(groups.get(i).getTid());
                row.createCell(4).setCellValue(groups.get(i).getTname());
                row.createCell(5).setCellValue(groups.get(i).getCname());
                row.createCell(6).setCellValue(groups.get(i).getTjudge());
                row.createCell(7).setCellValue(groups.get(i).getTjudgename());
                row.createCell(8).setCellValue(groups.get(i).getGroupnum());
                row.createCell(9).setCellValue(groups.get(i).getTeacher().getTname());
                row.createCell(10).setCellValue(groups.get(i).getGrade().getAdvisorGrade());
                row.createCell(11).setCellValue(groups.get(i).getGrade().getReviewGrade());
                row.createCell(12).setCellValue(groups.get(i).getGrade().getReplyGrade());
                row.createCell(13).setCellValue(groups.get(i).getGrade().getTotalGrade());
            }
            //设置单元格宽度自适应，在此基础上把宽度调至1.5倍
            for (int i = 0; i < title.length; i++) {
                stuSheet.autoSizeColumn(i, true);
                stuSheet.setColumnWidth(i, stuSheet.getColumnWidth(i) * 15 / 10);
            }
            // 创建新文件目录
            File newFile = new File(filePath);
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            String savePath = filePath + sheetName + ".xlsx";
            OutputStream fileOut = new FileOutputStream(savePath, false);
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
