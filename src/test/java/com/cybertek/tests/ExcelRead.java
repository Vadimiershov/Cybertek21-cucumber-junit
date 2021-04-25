package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Test;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    //in this test we will be reading from excel file
    @Test
    public void excel_read_test() throws IOException {

        String path = "SampleData.xlsx";
        //to be ready to read from excel file we need to load the file
        FileInputStream fileinputStream = new FileInputStream(path);

        //workbook > sheet > row > cell
        //We created workbook instance and loaded with "SampleData" file
        XSSFWorkbook workbook = new XSSFWorkbook(fileinputStream);

        //Create the sheet and pass the name of the sheet we want to work on
        XSSFSheet sheet = workbook.getSheet("Employees");

        System.out.println( sheet.getRow(1).getCell(0));
        //return the count of used cells only
        //if there are empty cells not used they will not be counted
        //this starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();

        //returns the count from top to bottom
        //Even counts if there are empty cells
        //this starts counting from 0
        int lastUsedRow =  sheet.getLastRowNum();

        //TODO: 1- Create a logic to print out NEENA's name dynamically

        for(int rowNum = 0; rowNum<usedRows;rowNum++){
            XSSFCell currentCell = sheet.getRow(rowNum).getCell(0);
            if(currentCell.toString().equals("Neena")){
                System.out.println("CurrentCell = " + sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: 2- Create a logic to print out ADAM SANdLER's last name dynamically

        for(int rowNum = 0; rowNum<usedRows;rowNum++){
            XSSFCell currentCell = sheet.getRow(rowNum).getCell(1);
            if(currentCell.toString().equals("Sandler")){
                System.out.println(currentCell);
            }
        }

        //TODO: 3- Create a logic to print out Steven King's JOB ID dynamically
        //CHECK for Last Name, if itt is King, print out job_ID
        for(int rowNum = 0; rowNum<usedRows;rowNum++){
            XSSFCell currentCell = sheet.getRow(rowNum).getCell(1);
            if(currentCell.toString().equals("King")){
                System.out.println(sheet.getRow(rowNum).getCell(2));
            }

        }
    }


}
