package Utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "InputData")
    public Object[][] getDataForEditField() {
        //2 sets of data
        Object[][] obj = new Object[][]{
                {"hello"}, {"!@#$"}
        };
        return obj;
    }
}
