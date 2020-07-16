package com.seleniumMantis.bases;

import com.seleniumMantis.GlobalParameters;
import com.seleniumMantis.utils.DriverFactory;
import com.seleniumMantis.utils.ExtentReportUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    @BeforeSuite
    public void beforeSuite()
    {
        new GlobalParameters();
        ExtentReportUtils.createReport();
    }

    @BeforeMethod
    public void beforeTest(Method method)
    {
        ExtentReportUtils.addTest(method.getName(), method.getDeclaringClass().getSimpleName());
        DriverFactory.createInstance();
        DriverFactory.INSTANCE.manage().window().maximize();
        DriverFactory.INSTANCE.navigate().to(GlobalParameters.URL_DEFAULT);
    }

    @AfterMethod
    public void afterTest(ITestResult result)
    {
        ExtentReportUtils.addTestResult(result);
        //DriverFactory.quitInstace();
    }

    @AfterSuite
    public void afterSuite(){

        ExtentReportUtils.generateReport();
    }
}
