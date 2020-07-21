    package com.seleniumMantis.tests;

    import com.sun.org.glassfish.gmbal.Description;
    import org.apache.poi.ss.usermodel.DataFormatter;
    import org.testng.Assert;
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;
    import com.seleniumMantis.bases.*;
    import com.seleniumMantis.page.*;
    import com.seleniumMantis.utils.ReadExcelFile;
    import com.seleniumMantis.dbSteps.DataBaseSteps;
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.*;
    import java.util.ArrayList;

    public class LoginTests extends TestBase {
        //Objects
        LoginPage loginPage;
        HomePage homePage;

        //Tests
        @Test
        @Description("Realiza o login com suscesso")
        public void LoginSucesso()
        {
            loginPage = new LoginPage();
            homePage = new HomePage();

            String usuario = "luana.assis";
            String senha = "123456";
            loginPage.preenhcerUsuario(usuario);
            loginPage.clicarEmLogin();
            loginPage.preencherSenha(senha);
            loginPage.clicarEmLogin();

            String usuLogado = homePage.retornaUsuLogado();
            Assert.assertEquals(usuLogado , usuario, "Usuário não logado.");
        }

        @Test
        @Description ("Realizar o login com usuario e senha incorretos")
        public void LoginUsuarioSenhaIncorretos()
        {
            loginPage = new LoginPage();
            homePage = new HomePage();

            String usuario = "errado";
            String senha = "123456";
            String msg = "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";

            loginPage.preenhcerUsuario(usuario);
            loginPage.clicarEmLogin();
            loginPage.preencherSenha(senha);
            loginPage.clicarEmLogin();
            String msgErroLogin = loginPage.retornarMensagemDeErro();
            Assert.assertTrue(msg.contains(msgErroLogin));
        }
        @Test
        @Description("Realizar o login com senha incorreta")
        public void LoginSenhaIncorreta()
        {
            loginPage = new LoginPage();
            homePage = new HomePage();

            String usuario = "luana.assis";
            String senha = "1234567";
            String msg = "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";

            loginPage.preenhcerUsuario(usuario);
            loginPage.clicarEmLogin();
            loginPage.preencherSenha(senha);
            loginPage.clicarEmLogin();
            String msgErroLogin = loginPage.retornarMensagemDeErro();
            Assert.assertTrue(msg.contains(msgErroLogin));
        }

        @Test
        @Description("Realizar teste com usuário desativado")
        public void LoginUsuarioDesativado()
        {
            loginPage = new LoginPage();
            homePage = new HomePage();

            String usuario = "usu.inativo";
            String senha = "123456";
            String msg = "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";

            loginPage.preenhcerUsuario(usuario);
            loginPage.clicarEmLogin();
            loginPage.preencherSenha(senha);
            loginPage.clicarEmLogin();
            String msgErroLogin = loginPage.retornarMensagemDeErro();
            Assert.assertTrue(msg.contains(msgErroLogin));
        }

        @Test
        @Description("Realiza login utilizando interação com javaScript")
        public void LoginUtilizandoJavaScritp()
        {
            loginPage = new LoginPage();
            homePage = new HomePage();

            String usuario = "luana.assis";
            String senha = "123456";

            loginPage.preencherUsuarioJavaScript(usuario);
            loginPage.clicarEmLoginJavaScript();
            loginPage.preencherSenhaJavaScript(senha);
            loginPage.clicarEmLoginJavaScript();

            String usuLogado = homePage.retornaUsuLogado();
            Assert.assertEquals(usuLogado , usuario, "Usuário não logado.");
        }

        @Test(dataProvider="testdata")
        public void LoginUtilizandoDataDriven(String usuario, String senha, String valorQualquer) throws InterruptedException
        {
            loginPage = new LoginPage();
            homePage = new HomePage();

            loginPage.preenhcerUsuario(usuario);
            loginPage.clicarEmLogin();
            loginPage.preencherSenha(senha);
            loginPage.clicarEmLogin();
            String usuLogado = homePage.retornaUsuLogado();
            Assert.assertEquals(usuLogado , usuario, "Usuário não logado.");
        }

        @DataProvider(name="testdata")
        public Object[][] testDataExample()
        {

            ReadExcelFile configuration = new ReadExcelFile("C:\\Users\\Base2\\Desktop\\Ole\\mantisJavaTemplate\\src\\test\\resources\\testdata.xlsx");
            int rows = configuration.getRowCount(0);

            //2 é a quantidade de valores que será preenchido no for
            Object[][]signin_credentials = new Object[rows][3];

            for(int i=0;i<rows;i++)
            {
                signin_credentials[i][0] = configuration.getData(0, i, 0);
                signin_credentials[i][1] = configuration.getData(0, i, 1);
                signin_credentials[i][2] = configuration.getData(0, i, 2);
            }
            return signin_credentials;
        }
    }

