package org.example.DataDriven;

import org.testng.annotations. DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {
@Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void test_VWOLogin(String email, String password){

    }



}
