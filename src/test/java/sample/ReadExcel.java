package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;



    public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        //Create an object of File class to open xls file
        File file =    new File(excelFilePath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //creating workbook instance that refers to .xlsx file
        workbook=new XSSFWorkbook(inputStream);

        //creating a Sheet object
        sheet=workbook.getSheet(sheetName);

        row = sheet.getRow(0);

    }

    public String getCellData(int rowNumber, int cellNumber)
    {
        //getting the cell value from rowNumber and cell Number
        row = sheet.getRow(rowNumber);
        //row.
        cell =sheet.getRow(rowNumber).getCell(cellNumber);

        DataFormatter formatter = new DataFormatter();
        String val = formatter.formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));

        //returning the cell value as string
        // return cell.getStringCellValue();
        return val;
    }

    public int getRowCountInSheet()
    {
        int rowcount = sheet.getPhysicalNumberOfRows();//sheet.getLastRowNum()-sheet.getFirstRowNum();//sheet.getPhysicalNumberOfRows()-1;//sheet.getLastRowNum()-sheet.getFirstRowNum();
        return rowcount;
    }

    public int getColumnCountInRow()
    {
        int lastColumn = sheet.getRow(0).getLastCellNum();
        return lastColumn;

    }

    public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException
    {
        Font headerFont = workbook.createFont();
        CellStyle headerCellStyle = sheet.getWorkbook().createCellStyle();
         //fill foreground color ...
         // headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
        // and solid fill pattern produces solid grey cell fill
        //   headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        if(cellValue.equalsIgnoreCase("Fail"))// || cellValue.equalsIgnoreCase("Please enter valid Mobile Number")
        {
            headerFont.setColor(IndexedColors.RED.index);
            headerFont.setBold(true);
        }
        else if (cellValue.equalsIgnoreCase("Pass"))
        {
            headerFont.setColor(IndexedColors.GREEN.index);
            headerFont.setBold(true);
        }

        headerCellStyle.setFont(headerFont);
        //creating a new cell in row and setting value to it
        sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
        sheet.getRow(rowNum).getCell(cellNum).setCellStyle(headerCellStyle);

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
    }


    public List<String[]> extractInfo()
    {
        List<String[]> infoList = new ArrayList<String[]>();

        try {

            int rowcount = sheet.getLastRowNum();

            for (int i =0; i<=rowcount; i++)
            {
                row = sheet.getRow(i);
                if (isRowEmpty(row))
                {
                    continue;
                }

                List<XSSFCell> cells = new ArrayList<XSSFCell>();

                int lastColumn = sheet.getRow(0).getLastCellNum();//row.getLastCellNum();//Math.max(row.getLastCellNum(), 5);
                for (int cn = 0; cn < lastColumn; cn++) {
                    XSSFCell c = row.getCell(cn, XSSFRow.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    cells.add(c);
                }

                String[] cellvalues = extractInfoFromCell(cells);
                infoList.add(cellvalues);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return infoList;
    }

    private String[] extractInfoFromCell(List<XSSFCell> cells) {

        int lastColumn = sheet.getRow(0).getLastCellNum();//Math.max(row.getLastCellNum(), 5);
        String[] cellValues = new String[lastColumn];

        DataFormatter formatter = new DataFormatter();
        for (int i =0; i<lastColumn;i++)
        {

            cellValues[i] = formatter.formatCellValue(cells.get(i));//;/getCellValue(cells.get(i));
        }
        return cellValues;
    }

    private boolean isRowEmpty(XSSFRow row) {
        boolean isEmpty = true;
        DataFormatter dataFormatter = new DataFormatter();

        if (row != null)
        {
            int lastColumn = row.getLastCellNum();

            for (int i =0; i<lastColumn;i++)
            {
                cell =row.getCell(i);
                if (dataFormatter.formatCellValue(cell).trim().length() > 0)
                {
                    isEmpty = false;
                    break;
                }
            }
        }

        return isEmpty;
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public XSSFSheet getSheet() {
        return sheet;
    }

    public void setSheet(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public XSSFRow getRow() {
        return row;
    }

    public void setRow(XSSFRow row) {
        this.row = row;
    }

    public XSSFCell getCell() {
        return cell;
    }

    public void setCell(XSSFCell cell) {
        this.cell = cell;
    }
}
