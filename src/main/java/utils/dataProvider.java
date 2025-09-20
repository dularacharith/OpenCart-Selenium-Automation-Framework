package utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class dataProvider {

    @DataProvider(name = "LoginTest")
    public Object[][] getLoginData() throws IOException {
        String filePath = "./testData/Data.xlsx";
        excelUtils.loadExcel(filePath,"Sheet1");
        int rowCount = excelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];

        for(int i=0;i<rowCount-1;i++){
            data[i][0]=excelUtils.getCellData(i+1,0);
            data[i][1]=excelUtils.getCellData(i+1,1);
        }
        excelUtils.closeExcel();;
        return data;
    }



}
