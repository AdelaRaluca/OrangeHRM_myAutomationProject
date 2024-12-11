package data;

public class DataProvider {
    @org.testng.annotations.DataProvider(name="Valid Authentication")
    public Object[][] validLoginDataProvider() {
    return new Object[][]{
            {"Admin"},
            {"admin123"}
    };
    }

    @org.testng.annotations.DataProvider(name="Invalid Authentication")
    public Object[][] emptyLoginDataProvider() {
        return new Object[][]{
                {" "},
                {" "}
        };
    }

    //    @DataProvider(name = "loginDataProvider")
//    public Object[][] loginDataProvider() throws IOException {
//        // Load test data from JSON file
//        ObjectMapper mapper = new ObjectMapper();
//        LoginTestData[] testData = mapper.readValue(new File("src/test/resources/loginTestData.json"), LoginTestData[].class);
//
//        Object[][] data = new Object[testData.length][1];
//        for (int i = 0; i < testData.length; i++) {
//            data[i][0] = testData[i];
//        }
//        return data;
//    }
}
