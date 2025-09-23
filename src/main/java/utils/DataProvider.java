package utils;

import java.io.IOException;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "LoginTest")
    public Object[][] getLoginData() throws IOException {
        String filePath = "./testData/Data.xlsx";
        ExcelUtils.loadExcel(filePath,"Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];

        for(int i=0;i<rowCount-1;i++){
            data[i][0]= ExcelUtils.getCellData(i+1,0);
            data[i][1]= ExcelUtils.getCellData(i+1,1);
        }
        ExcelUtils.closeExcel();;
        return data;
    }
    @org.testng.annotations.DataProvider(name="RegisterTest")
    public Object[][] userRegister() throws IOException {
        String filePath = "./testData/Data_Register.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][4];
        for (int i = 0; i < rowCount-1; i++) {
            data[i][0] = ExcelUtils.getCellData(i+1,0);
            data[i][1] = ExcelUtils.getCellData(i+1,1);
            data[i][2] = ExcelUtils.getCellData(i+1,2);
            data[i][3] = ExcelUtils.getCellData(i+1,3);
        }
        ExcelUtils.closeExcel();
        return data;
    }
    @org.testng.annotations.DataProvider(name="ForgotPasswordTest")
    public Object[][] forgotPWTest() throws IOException{
        String filePath = "./testData/Data_Register.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][1];
        for (int i=0;i<rowCount-1;i++){
            data[i][0] =ExcelUtils.getCellData(i+1,2);
        }
        ExcelUtils.closeExcel();
        return data;
    }
}