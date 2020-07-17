package com.seleniumMantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.seleniumMantis.bases.*;
import com.seleniumMantis.page.*;
import com.seleniumMantis.dbSteps.DataBaseSteps;

import java.util.ArrayList;

public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    DataBaseSteps db;

    //Tests
    @Test
    public void efetuarLoginComSucesso(){
        //Objects instances
        loginPage = new LoginPage();
        db = new DataBaseSteps();

        //Parameteres
        String usuario = "administrator";
        String senha = "administrator";

        ArrayList<String> resultado = db.retoraUsuario("administrator");

        //Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmLogin();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();
    }
    @Test
    public  void efetuarLoginSenhaIncorreta()
    {

        //Objects instances
        loginPage = new LoginPage();

        //Parameteres
        String usuario = "dfafasd";
        String senha = "sfasdfasdfa";
        String msgEsperada = "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";

        //Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmLogin();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();
        String msgRecebida = loginPage.retornarMensagemDeErro();

        Assert.assertNotNull(msgRecebida);
        Assert.assertEquals(msgRecebida, msgEsperada, "Mensagem de login não foi exibida corretamente");
    }
}
