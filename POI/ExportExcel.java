package com.kpmg.test;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportExcel {
    public static void main(String [] args){

        //每一行的内容，mock固定数据
        List<String> rowList1 = new ArrayList<>();
        rowList1.add("D1");
        rowList1.add("1.       了解存货在仓库的存放位置和存放方式（如存货是否排列整齐，是否加贴了标签，大宗存货是否恰当堆放和标识）。如适用，索取仓库平面图并安排由仓库负责人陪同实地察看存货各存放地点。");
        rowList1.add("是 - 提供具体信息。");
        rowList1.add("xmz回复");
        rowList1.add(" ");
        rowList1.add(" ");
        rowList1.add(" ");
        List<String> rowList2 = new ArrayList<>();
        rowList2.add("D1");
        rowList2.add("是 - 盘点期间存货存放场所被关闭。\n" +
                "是 - 存在存货在存放场所之间移动的情况，提供具体信息。");
        rowList2.add("是 - 提供具体信息。");
        rowList2.add("xmz回复");
        rowList2.add(" ");
        rowList2.add(" ");
        rowList2.add("G");

        //各部分的list
        List<List<String>> dlist = new ArrayList<List<String>>();
        dlist.add(rowList1);
        dlist.add(rowList1);
        dlist.add(rowList2);
        dlist.add(rowList1);

        //excelName
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        Date date = new Date();
        String excelName ="test_" + sdf.format(date) + ".xls";
        String exportPath = "C:\\Users\\weitaoxu\\Desktop\\" + excelName;
        System.out.print(exportExcel(dlist, dlist, dlist,dlist,exportPath));

    }





    public static String exportExcel(List<List<String>> dlist, List<List<String>> e1list,
                                     List<List<String>> e2list, List<List<String>> e3list,
                                     String exportPath){

        //new workbook
        XSSFWorkbook wb =new XSSFWorkbook();

        //new sheet
        XSSFSheet sheet = wb.createSheet("3A全面实地盘点");

        //set bg color
        XSSFColor title1Color = ExcelTool.setXSSFColor(255,192,0);
        XSSFColor title2Color = ExcelTool.setXSSFColor(255,242,204);
        XSSFColor title3Color = ExcelTool.setXSSFColor(226,239,218);
        XSSFColor tip1Color = ExcelTool.setXSSFColor(155,194,230);
        XSSFColor tip2Color = ExcelTool.setXSSFColor(217,225,242);
        XSSFColor tip3Color = ExcelTool.setXSSFColor(146,208,80);
        XSSFColor ftBlkColor = ExcelTool.setXSSFColor(0,0,0);
        XSSFColor white = ExcelTool.setXSSFColor(255,255,255);

        //set font
        XSSFFont t1Font = ExcelTool.setXSSFFont(wb,"微软雅黑",11,true,ftBlkColor);
        XSSFFont t2Font = ExcelTool.setXSSFFont(wb,"微软雅黑",10,true,ftBlkColor);
        XSSFFont t3Font = ExcelTool.setXSSFFont(wb,"微软雅黑",9,true,ftBlkColor);
        XSSFFont contentFont = ExcelTool.setXSSFFont(wb,"微软雅黑",9,false,ftBlkColor);

        //设置各个模块样式
        //title 1
        XSSFCellStyle title1CenterStyle = ExcelTool.setCellStyle(wb,title1Color,t1Font,HorizontalAlignment.CENTER, VerticalAlignment.TOP);
        XSSFCellStyle title1LeftStyle = ExcelTool.setCellStyle(wb,title1Color,t1Font,HorizontalAlignment.LEFT, VerticalAlignment.TOP);
        XSSFCellStyle titleSmallStyle = ExcelTool.setCellStyle(wb,title1Color,t3Font,HorizontalAlignment.CENTER, VerticalAlignment.TOP);

        //title 2
        XSSFCellStyle title2CenterStyle = ExcelTool.setCellStyle(wb,title2Color,t2Font,HorizontalAlignment.CENTER, VerticalAlignment.TOP);
        XSSFCellStyle title2LeftStyle = ExcelTool.setCellStyle(wb,title2Color,t2Font,HorizontalAlignment.LEFT, VerticalAlignment.TOP);
        XSSFCellStyle title2SmallStyle = ExcelTool.setCellStyle(wb,title2Color,t3Font,HorizontalAlignment.CENTER, VerticalAlignment.TOP);

        //title 3
        XSSFCellStyle title3CenterStyle = ExcelTool.setCellStyle(wb,title3Color,t2Font,HorizontalAlignment.CENTER, VerticalAlignment.TOP);
        XSSFCellStyle title3LeftStyle = ExcelTool.setCellStyle(wb,title3Color,t2Font,HorizontalAlignment.LEFT, VerticalAlignment.TOP);

        //tips
        XSSFCellStyle tipStyle1 = ExcelTool.setCellStyle(wb,tip1Color,t3Font,HorizontalAlignment.CENTER, VerticalAlignment.TOP);
        XSSFCellStyle tipStyle2 = ExcelTool.setCellStyle(wb,tip2Color,t3Font,HorizontalAlignment.CENTER, VerticalAlignment.TOP);
        XSSFCellStyle tipStyle3 = ExcelTool.setCellStyle(wb,tip3Color,t3Font,HorizontalAlignment.CENTER, VerticalAlignment.TOP);

        //正文样式
        XSSFCellStyle contentStyle = ExcelTool.setCellStyle(wb,white,contentFont,HorizontalAlignment.CENTER, VerticalAlignment.TOP);

        //行高&列宽
        int rowHeight = 30;
        int colWidth10 = 10;
        int colWidth15 = 15;
        int colWidth40 = 40;
        sheet.setColumnWidth(0,256*colWidth10);
        sheet.setColumnWidth(1,256*colWidth40);
        sheet.setColumnWidth(2,256*colWidth15);
        sheet.setColumnWidth(3,256*colWidth15);
        sheet.setColumnWidth(4,256*colWidth15);
        sheet.setColumnWidth(5,256*colWidth10);
        sheet.setColumnWidth(6,256*colWidth10);
        sheet.setDefaultRowHeightInPoints(30);


        //设置表头行
        ExcelTool.setCellValue(sheet,0,0,title1CenterStyle,"二");
        ExcelTool.setCellValue(sheet,0,1,title1LeftStyle,"监盘程序");
        //合并列
        sheet.addMergedRegion(new CellRangeAddress(0,0,2,4));
        ExcelTool.setCellValue(sheet,0,2,titleSmallStyle,"记录回复");
        ExcelTool.setCellValue(sheet,0,5,titleSmallStyle,"备注列");
        ExcelTool.setCellValue(sheet,0,6,tipStyle1,"提示");

        //设置次标题行
        ExcelTool.setCellValue(sheet,1,0,title2CenterStyle,"D");
        ExcelTool.setCellValue(sheet,1,1,title2LeftStyle,"存货盘点的环境状况、客户的盘点和记录程序");
        ExcelTool.setCellValue(sheet,1,2,title2SmallStyle,"可选回复");
        ExcelTool.setCellValue(sheet,1,3,title2SmallStyle,"项目组回复");
        ExcelTool.setCellValue(sheet,1,4,title2SmallStyle,"提供具体信息");
        ExcelTool.setCellValue(sheet,1,5,title2SmallStyle,"备注");
        ExcelTool.setCellValue(sheet,1,6,tipStyle2,"提示");

        //循环写入D模块的值
        for (int i = 0; i < dlist.size() ; i++) {
            ExcelTool.setLineValue(sheet, 2 + i, 0, contentStyle, dlist.get(i));
        }

        //写E标题行
        int eRowNum = dlist.size() + 2;
        ExcelTool.setCellValue(sheet,eRowNum,0,title2CenterStyle,"E");
        ExcelTool.setCellValue(sheet,eRowNum,1,title2LeftStyle,"审计师的监盘程序和记录");
        ExcelTool.setCellValue(sheet,eRowNum,2,title2SmallStyle,"可选回复");
        ExcelTool.setCellValue(sheet,eRowNum,3,title2SmallStyle,"项目组回复");
        ExcelTool.setCellValue(sheet,eRowNum,4,title2SmallStyle,"提供具体信息");
        ExcelTool.setCellValue(sheet,eRowNum,5,title2SmallStyle,"备注");
        ExcelTool.setCellValue(sheet,eRowNum,6,tipStyle2,"提示");

        //E1 title  subtitleStyle2
        int e1RowNum = eRowNum + 1;
        ExcelTool.setCellValue(sheet,e1RowNum,0,title3CenterStyle,"(1)");
        ExcelTool.setCellValue(sheet,e1RowNum,1,title3LeftStyle,"监盘中");
        ExcelTool.setLineCellStyle(sheet,e1RowNum,2,6,title3CenterStyle);

        //E1 List   contentStyle
        for (int i = 0; i < e1list.size(); i++) {
            ExcelTool.setLineValue(sheet,e1RowNum + 1 + i,0,contentStyle,e1list.get(i));
        }

        //E2 title  subtitleStyle2
        int e2RowNum = e1RowNum + e1list.size() + 1;
        ExcelTool.setCellValue(sheet,e2RowNum,0,title3CenterStyle,"(2)");
        ExcelTool.setCellValue(sheet,e2RowNum,1,title3LeftStyle,"监盘完毕后，离开被审计单位工作场所前");
        ExcelTool.setLineCellStyle(sheet,e2RowNum,2,6,title3LeftStyle);

        //E2 list  contentStyle
        for (int i = 0; i < e2list.size(); i++) {
            ExcelTool.setLineValue(sheet,e2RowNum + 1 + i,0,contentStyle,e2list.get(i));
        }

        //E3 title  subtitleStyle2
        int e3RowNum = e2RowNum + e2list.size() + 1;
        ExcelTool.setCellValue(sheet,e3RowNum,0,title3CenterStyle,"(3)");
        ExcelTool.setCellValue(sheet,e3RowNum,1,title3LeftStyle,"监盘后");
        ExcelTool.setLineCellStyle(sheet,e3RowNum,2,6,title3LeftStyle);

        //E3 list  contentStyle
        for (int i = 0; i < e3list.size(); i++) {
            ExcelTool.setLineValue(sheet,e3RowNum +1 + i,0,contentStyle,e3list.get(i));
        }


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(exportPath);
            wb.write(fileOutputStream);
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return "Excel文件生成成功，路径：\n" + exportPath;
    }

}
