package com.seleniumMantis.page;

import com.seleniumMantis.bases.PageBase;
import org.openqa.selenium.By;

public class GerenciarMarcadoresPage extends PageBase
{
    By menuGerenciar = By.xpath("//a[@href= '/mantis/manage_overview_page.php']");
    By menuMarcador = By.xpath("//a[@href= '/mantis/manage_tags_page.php']");
    By marcadorTesteGrid = By.xpath("//a[text()='marcadorTeste']");
    By marcadorTeste2Grid = By.xpath("//a[text()='marcadorTeste2']");
    By atualizarMarcadorButton = By.xpath("//input[@value='Atualizar Marcador']");
    By nomeMarcadorField = By.id("tag-name");
    By usuMarcadorCombo = By.id("tag-user-id");
    By descricaoMarcadorField = By.id("tag-description");
    By criarMarcadorButton = By.xpath("//a[text()='Criar Marcador']");
    By confirmaCriarMarcadorButton = By.name("config_set");
    By msgErro = By.xpath("//p[contains(text(),'APPLICATION ERROR')]");

    public void abrirMenuGerenciarMarcadores()
    {
    click(menuGerenciar);
    click(menuMarcador);
    }

    public void selecionaMarcadorTeste()
    {
    click(marcadorTesteGrid);
    }
    public void selecionaMarcadorTeste2()
    {
    click(marcadorTeste2Grid);
    }
    public void clicaAtualizarMarcador()
    {
    click(atualizarMarcadorButton);
    }
    public void preencheNomeMarcador(String texto)
    {
        clear(nomeMarcadorField);
        sendKeys(nomeMarcadorField, texto);
    }
    public void preencheUsuarioMarcador(String usuario)
    {
    comboBoxSelectByVisibleText(usuMarcadorCombo, usuario);
    }
    public void preencheDescricaoMarcador(String texto)
    {
    clearAndSendKeys(descricaoMarcadorField, texto);
    }
    public boolean retornaMsgErro()
    {
    return returnIfElementIsDisplayed(msgErro);
    }
    public void clicaBtnCriarMarcador()
    {
    click(criarMarcadorButton);
    }
    public void clicaBtnConfirmarCriacaoMarcador()
    {
    click(confirmaCriarMarcadorButton);
    }
}