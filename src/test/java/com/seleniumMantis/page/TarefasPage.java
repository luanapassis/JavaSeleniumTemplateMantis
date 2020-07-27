package com.seleniumMantis.page;

import com.seleniumMantis.bases.PageBase;
import org.openqa.selenium.By;

public class TarefasPage extends PageBase {
    By menuCriarTarefa = By.xpath("//a[@href= '/mantis/bug_report_page.php']");
    By projetoCombo = By.id("select-project-id");
    By selecionarProjetoButton = By.xpath("//input[@value = 'Selecionar Projeto']");
    By categoriaCombo = By.id("category_id");
    By resumoField = By.id("summary");
    By descricaoField = By.id("description");
    By criarNovaTarefaButton = By.xpath("//input[@value = 'Criar Nova Tarefa']");
    By bugIdField = By.xpath("//td[@class = 'bug-id']");


    public void abrirMenuGerenciarUsuario()
    {
        click(menuCriarTarefa);
    }

    public void selecionaProjeto(String projeto)
    {
        comboBoxSelectByVisibleText(projetoCombo, projeto);
    }
    public void clicarBtnSelecionarProjeto()
    {
        click(selecionarProjetoButton);
    }
    public void selecinaComboCategoria(String categoria)
    {
        comboBoxSelectByVisibleText(categoriaCombo, categoria);
    }
    public void preencheCampoResumo(String resumo)
    {
        clearAndSendKeys(resumoField, resumo);
    }
    public void preencheCampoDescricao(String descricao)
    {
        clearAndSendKeys(descricaoField, descricao);
    }
    public void clicaBtnCriarNovaTarefa()
    {
        click(criarNovaTarefaButton);
    }
    public String retornaBugIdDaTela()
    {
        return getText(bugIdField);
    }

}
