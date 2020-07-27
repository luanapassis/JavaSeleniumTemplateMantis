package com.seleniumMantis.flows;

import com.seleniumMantis.GlobalParameters;
import com.seleniumMantis.page.HomePage;
import com.seleniumMantis.page.LoginPage;
import org.testng.Assert;

public class LoginFlow
{
    LoginPage loginPage;

    public LoginFlow(){
        loginPage = new LoginPage();
    }
    private String usuario = GlobalParameters.USUARIO;
    private String senha = GlobalParameters.SENHA;

    public void fazLogin()
    {
        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmLogin();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();
    }
}
