package com.seleniumMantis.bases;

import com.seleniumMantis.GlobalParameters;
import com.seleniumMantis.utils.DriverFactory;
import com.seleniumMantis.utils.ExtentReportUtils;
import com.seleniumMantis.dbSteps.DataBaseSteps;
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
        DataBaseSteps db = new DataBaseSteps();

        //cargas de usuário, projeto e marcadores a cada execução da suite
        db.cargaUsuario();
        db.cargaProjeto();
        db.cargaMarcadores();
    }

    @BeforeMethod
    public void beforeTest(Method method)
    {
        ExtentReportUtils.addTest(method.getName(), method.getDeclaringClass().getSimpleName());
        DriverFactory.createInstance();
        DriverFactory.INSTANCE.manage().window().maximize();
        DriverFactory.INSTANCE.navigate().to(GlobalParameters.URL_DEFAULT);

        //cargas de atualização a cada novo teste
        DataBaseSteps db = new DataBaseSteps();
        db.atualizacaoCargaUsuario();
        db.atualizacaoCargaProjeto();
        db.atualizacaoCargaMarcadores();
    }

    @AfterMethod
    public void afterTest(ITestResult result)
    {
        ExtentReportUtils.addTestResult(result);
        DriverFactory.quitInstace();
    }

    @AfterSuite
    public void afterSuite(){

        ExtentReportUtils.generateReport();
    }
}
