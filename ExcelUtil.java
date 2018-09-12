package com.kpmg.test;

import com.kpmg.itms.common.util.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Excel工具类
 *
 */
public class ExcelUtil {

    private ExcelUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * RGB创建颜色
     * @param r
     * @param g
     * @param b
     */
    public static XSSFColor setXSSFColor(int r, int g, int b)
    {
        return new XSSFColor(new java.awt.Color(r, g, b));
    }

    /**
     * 指定字体
     * @param wb
     * @param fontName
     * @param fontSize
     * @param bold
     * @param xssfColor
     */
    public static XSSFFont setXSSFFont(XSSFWorkbook wb,String fontName, int fontSize,
                                       boolean bold,XSSFColor xssfColor)
    {
        XSSFFont font = wb.createFont();
        font.setBold(bold);
        font.setFontName(fontName);
        font.setFontHeightInPoints((short)fontSize);
        font.setColor(xssfColor);
        return font;
    }


    /**
     * 创建单元格的样式
     * 包含背景颜色，字体，对齐方式
     * 已自动换行
     * @param wb
     * @param bgColor
     * @param xssfFont
     * @param horizontalAlignment
     * @param verticalAlignment
     * @return
     */
    public static XSSFCellStyle setCellStyle(XSSFWorkbook wb, XSSFColor bgColor,XSSFFont xssfFont,
                                             HorizontalAlignment horizontalAlignment,
                                             VerticalAlignment verticalAlignment) {
        XSSFCellStyle cs = wb.createCellStyle();
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cs.setWrapText(true);

        cs.setFillForegroundColor(bgColor);
        cs.setFont(xssfFont);
        cs.setAlignment(horizontalAlignment);
        cs.setVerticalAlignment(verticalAlignment);
        return cs;
    }

    /**
     * 设置单元格的值(double)
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param colNum 列数
     * @param cs 单元格样式（从外部传进来，减少对象个数及“不同样式的单元格太多”的问题）
     * @param value 设的值
     */
    public static void setCellValueNumber(XSSFSheet sheet, int rowNum, int colNum, XSSFCellStyle cs, double value) {
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        XSSFCell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellType(CellType.NUMERIC);

        if (cs != null) {
            cell.setCellStyle(cs);
        }
        cell.setCellValue(value);
    }

    /**
     * 设置单元格的值(String)
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param colNum 列数
     * @param cs 单元格样式（从外部传进来，减少对象个数及“不同样式的单元格太多”的问题）
     * @param value 设的值
     */
    public static void setCellValue(XSSFSheet sheet, int rowNum, int colNum, XSSFCellStyle cs, String value) {
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        XSSFCell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellType(CellType.STRING);

        if (cs != null) {
            cell.setCellStyle(cs);
        }

        if (value == null) {
            value = "";
        }
        cell.setCellValue(new XSSFRichTextString(value));
    }


    /**
     * 设置单元格的值(formula)
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param colNum 列数
     * @param cs 单元格样式（从外部传进来，减少对象个数及“不同样式的单元格太多”的问题）
     * @param value 设的值
     */
    public static void setCellFomula(XSSFSheet sheet, int rowNum, int colNum, XSSFCellStyle cs, String value) {
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        XSSFCell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellType(CellType.FORMULA);

        if (cs != null) {
            cell.setCellStyle(cs);
        }

        if (value == null) {
            value = "";
        }
        cell.setCellFormula(value);
    }

    /**
     * 设置一行单元格的样式(excel2007)
     * @param rowNum excel行
     * @param startColNum 起始列数
     * @param endColNum 终止列数
     * @param cs 样式
     */
    public static void setLineCellStyle(XSSFSheet sheet, int rowNum, int startColNum, int endColNum, XSSFCellStyle cs) {
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        for(int i = startColNum; i <= endColNum; i++) {
            XSSFCell cell = row.getCell(i);
            if (cell == null) {
                cell = row.createCell(i);
            }
            cell.setCellStyle(cs);
        }
    }

    /**
     * 填充一行单元格的值(String)
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param startColNum 起始列数
     * @param cs 单元格样式
     * @param values 值(集合)
     */
    public static void setLineValue(XSSFSheet sheet, int rowNum, int startColNum, XSSFCellStyle cs, List<String> values) {
        for (int i = 0; i < values.size(); i++) {
            setCellValue(sheet, rowNum, startColNum++, cs, values.get(i));
        }
    }

    /**
     * 设置一行单元格的值(number)
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param startColNum 起始列数
     * @param cs 单元格样式
     * @param values 值(集合)
     */
    public static void setLineValueNum(XSSFSheet sheet, int rowNum, int startColNum, XSSFCellStyle cs, List<Double> values) {
        for (int i = 0; i < values.size(); i++) {
            setCellValueNumber(sheet, rowNum, startColNum++, cs, values.get(i));
        }
    }

    /**
     * 设置一行单元格的值(String[])
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param startColNum 起始列数
     * @param cs 单元格样式
     * @param values 值(数组)
     */
    public static void setLineValue(XSSFSheet sheet, int rowNum,
                                    int startColNum, XSSFCellStyle cs, String[] values) {
        for (int i = 0; i < values.length; i++) {
            setCellValue(sheet, rowNum, startColNum++, cs, values[i]);
        }
    }


    //-------------------------------------------------excel2007end-------------------------------------------------------------//


    //--------------------------------------------------excel流------------------------------------------------------------------//
    /**
     * 创建单元格样式
     * @param wb
     * @param bgColor
     * @return
     */
    public static CellStyle createCellStyle(SXSSFWorkbook wb, short bgColor) {
        CellStyle cs = wb.createCellStyle();
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setFillForegroundColor(bgColor);
        cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        return cs;
    }


    /**
     * 设置单元格的值(excel流)
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param colNum 列数
     * @param cs 单元格样式（从外部传进来，减少对象个数及“不同样式的单元格太多”的问题）
     * @param value 设的值
     */
    public static void setCellValue(Sheet sheet, int rowNum, int colNum, CellStyle cs, String value) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        Cell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellType(CellType.STRING);

        if (cs != null) {
            cell.setCellStyle(cs);
        }

        if (value == null) {
            value = "";
        }
        cell.setCellValue(value);
    }


    /**
     * 设置一行单元格的值
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param startColNum 起始列数
     * @param cs 单元格样式
     * @param values 值的数组
     */
    public static void setLineValue(Sheet sheet, int rowNum, int startColNum, CellStyle cs, String values[]) {
        for (int i = 0; i < values.length; i++) {
            setCellValue(sheet, rowNum, startColNum++, cs, values[i]);
        }
    }


    /**
     * 设置一行单元格的值(excel流)
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param startColNum 起始列数
     * @param cs 单元格样式
     * @param values 值(集合)
     */
    public static void setLineValue(Sheet sheet, int rowNum, int startColNum, CellStyle cs, List<String> values) {
        for (int i = 0; i < values.size(); i++) {
            setCellValue(sheet, rowNum, startColNum++, cs, values.get(i));
        }
    }

    public static String getDateString(Date date, String dateFormate) {
        if (date == null) {
            return null;
        }
        String formate = "";
        if (isNull(dateFormate)) {
            formate = "yyyy-MM-dd HH:mm:ss";
        } else {
            formate = dateFormate;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(date);
    }
    public static boolean isNull(Object o) {
        if (o == null) {
            return true;
        }

        if (o instanceof String) {
            String s = (String) o;
            if (StringUtils.isEmpty(s)||StringUtils.isBlank(s)) {
                return true;
            }
            return false;
        } else if (o instanceof Object[]) {
            return ((Object[]) o).length == 0;
        } else if (o instanceof Collection<?>) {
            return ((Collection<?>) o).isEmpty();
        } else if (o instanceof Map<?, ?>) {
            return ((Map<?, ?>) o).isEmpty();
        }
        return false;
    }

    /**
     * 设置单元格的值(excel2007)
     *
     * @param sheet 工作表
     * @param rowNum 行数
     * @param colNum 列数
     * @param cs 单元格样式（从外部传进来，减少对象个数及“不同样式的单元格太多”的问题）
     * @param xSSFRichTextString 设的值
     */
    public static void setCellValue(XSSFSheet sheet, int rowNum, int colNum, XSSFCellStyle cs, XSSFRichTextString xSSFRichTextString) {
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        XSSFCell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellType(CellType.STRING);

        if (cs != null) {
            cell.setCellStyle(cs);
        }

        if (xSSFRichTextString == null) {
            xSSFRichTextString = new XSSFRichTextString();
        }
        cell.setCellValue(xSSFRichTextString);
    }

    /**
     * 设置cell边框颜色
     * @param cs XSSFCellStyle
     * @param color XSSFColor
     */
    public static void setCellBorderColor(XSSFCellStyle cs, XSSFColor color) {
        cs.setBottomBorderColor(color);
        cs.setTopBorderColor(color);
        cs.setLeftBorderColor(color);
        cs.setRightBorderColor(color);
    }

}
