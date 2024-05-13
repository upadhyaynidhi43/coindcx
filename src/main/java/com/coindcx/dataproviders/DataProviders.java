package com.coindcx.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "createObject")
    public Object[][] restServiceable() {
        return new Object[][]{
                {"Google Pixel 6 Pro", "128 GB", "4th", "312"}};
    }
}
