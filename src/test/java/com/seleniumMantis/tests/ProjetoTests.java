package com.seleniumMantis.tests;

import com.seleniumMantis.bases.TestBase;
import com.seleniumMantis.page.HomePage;
import  com.seleniumMantis.flows.LoginFlow;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjetoTests extends TestBase
{
    //Objects
    LoginFlow loginFlow;
    HomePage homePage;

    @Test
    public void Test_verificaProjetoExistente()
    {
        loginFlow = new LoginFlow();
        homePage = new HomePage();

        String projetoExistente = "Teste";

        loginFlow.fazLogin();
        String projetoLocalizado = homePage.retornaProjetoMassa();

        Assert.assertEquals( projetoLocalizado, projetoExistente);

    }

     @Test
    public void Test_verificaSelecaoProjetoExistente()
    {
        loginFlow = new LoginFlow();
        homePage = new HomePage();

        String projetoExistente = "Teste";

        loginFlow.fazLogin();
        String projetoLocalizado = homePage.retornaProjetoMassa();
        homePage.clicaProjetoMassa();

        Assert.assertEquals( projetoLocalizado, projetoExistente);

    }
}
