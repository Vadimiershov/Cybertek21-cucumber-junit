package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GasMileageTests {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

    @Test
    public void gas_mileage_calculation()throws IOException {

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");
        //get the path of the file
        String path = "src/test/resources/testData/GasMileageTestData.xlsx";
        //loading file into inputStream object
        fileInputStream = new FileInputStream(path);
        //loading the workbook to the class
        workbook = new XSSFWorkbook(fileInputStream);

        //opening sheet
        sheet = workbook.getSheet("Sheet1");

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {


            XSSFRow currentRow = sheet.getRow(rowNum);

            if(!currentRow.getCell(0).toString().equals("Y")){

                if(currentRow.getCell(6) == null){
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("Skip Requested");

                continue;
            }


            double current = currentRow.getCell(1).getNumericCellValue();

            //double current = 123000;

            gasMileageCalculatorPage.inputCurrentOdo.clear();

            //we need to pass double into input box
            gasMileageCalculatorPage.inputCurrentOdo.sendKeys(String.valueOf(current));
            double previous = currentRow.getCell(2).getNumericCellValue();
            //Entering previous odometer reading
            //double previous =122000;

            gasMileageCalculatorPage.inputPreviousOdo.clear();
            gasMileageCalculatorPage.inputPreviousOdo.sendKeys(String.valueOf(previous));
            double gas = currentRow.getCell(3).getNumericCellValue();
            //entering how many gallons of gas used
            //double gas = 70;

            gasMileageCalculatorPage.inputGas.clear();
            gasMileageCalculatorPage.inputGas.sendKeys(String.valueOf(gas));

            //click to calculate button
            gasMileageCalculatorPage.calculateButton.click();

            //how does the calculation of AVG/MPG work
            //(current-previous)/gallons --> avg MPG

            double expectedResult = (current - previous) / gas;


            System.out.println("expected Result = " + expectedResult);

            //actual result
            String[] actualResultArr = gasMileageCalculatorPage.resultInGas.getText().split(" ");
            System.out.println("actualResultArr = " + actualResultArr[0]);

            String actual = actualResultArr[0];

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            String formattedExpected = decimalFormat.format(expectedResult);
            System.out.println("formattedExpected = " + formattedExpected);

            //if the cell is empty we need to create the cell before being able to pass the data
            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }
            //Passing the "formatted Expected" into our Excel sheet
            currentRow.getCell(4).setCellValue(formattedExpected);

            //Passing Actual value into Excel Sheet
            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }

            currentRow.getCell(5).setCellValue(actual);

            //Passing the status
            if (currentRow.getCell(6) == null) {
                currentRow.createCell(6);
            }

            if (actual.equals(formattedExpected)) {
                //System.out.println("PASS!");
                currentRow.getCell(6).setCellValue("PASS!");
            } else {
                //System.out.println("FAIL!");
                currentRow.getCell(6).setCellValue("FAIL!");
            }

            //Entering the current time when test is running that specific line
            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }
            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("hh:mm:ss a");
            currentRow.getCell(7).setCellValue(LocalDateTime.now().format(DTF));
        }

        //We must write into excel file using .write method, otherwise changes will not be appear

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();




    }


}
