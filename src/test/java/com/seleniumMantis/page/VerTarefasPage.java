package com.seleniumMantis.page;

import com.seleniumMantis.bases.PageBase;
import org.openqa.selenium.By;

public class VerTarefasPage extends PageBase
{
    By menuVerTarefas = By.xpath("//a[@href= '/mantis/view_all_bug_page.php']");
    By filtroTarefasField = By.id("filter-search-txt");
    By filtrarTarefasButton = By.xpath("//input[@value='Aplicar Filtro']");
    By tarefaIdGrid = By.xpath("//td[@class= 'column-id']/a");
    By tagField = By.id("tag_string");
    By aplicarTagButton = By.xpath("//input[@value='Aplicar']");
    By removerTagButton = By.xpath("//a[contains(@href,'tag_detach')]");
    By relacaoTarefaField = By.name("dest_bug_id");
    By addRelacaoButton = By.name("add_relationship");
    By atualizarTarefaButton = By.xpath("//input[@value='Atualizar']");
    By tipoRelacaoCombo = By.name("rel_type");
    By atribuicaoCombo = By.name("handler_id");
    By confirmarAtualizacaoTarefaButton = By.xpath("//input[@value='Atualizar Informação']");
    By resolucaoCombo = By.id("resolution");
    By statusCombo = By.name("status");
    By prioridadeCombo = By.id("priority");
    By msgErro = By.xpath("//p[contains(text(),'APPLICATION ERROR')]");


    public void abrirMenuVerTarefas()
    {
        click(menuVerTarefas);
    }
    public void preencheFiltroTarefa(String codigoTarefa)
    {
        clearAndSendKeys(filtroTarefasField, codigoTarefa);
    }
    public void clicarFiltrarTarefa()
    {
        click(filtrarTarefasButton);
    }
    public String retornaIdGridTarefa()
    {
        return getText(tarefaIdGrid);
    }
    public void preencheTag(String tag)
    {
        click(tagField);
        sendKeys(tagField, tag);
    }
    public void clicaAplicarTag()
    {
        click(aplicarTagButton);
    }
    public void clicaBtnRemoverTag()
    {
        click(removerTagButton);
    }
    public void preencheRelacaoTarefa(String relacao)
    {
        sendKeys(relacaoTarefaField, relacao);
    }
    public void clicaBtnAddRelacao()
    {
        click(addRelacaoButton);
    }
    public boolean retornaMsgErro()
    {
        return returnIfElementIsDisplayed(msgErro);
    }
    public void selecionaComboTipoRelacao(String tipoRelacao)
    {
        comboBoxSelectByVisibleText(tipoRelacaoCombo, tipoRelacao);
    }
    public void clicaBtnAtualizarTarefa()
    {
        click(atualizarTarefaButton);
    }
    public void selecinaComboAtribuicao(String usuario)
    {
        comboBoxSelectByVisibleText(atribuicaoCombo, usuario);
    }
    public void clicaBntConfirmaAtualizacaoTarefa()
    {
        click(confirmarAtualizacaoTarefaButton);
    }
    public void selecionaComboResolucao(String resolucao)
    {
        comboBoxSelectByVisibleText(resolucaoCombo, resolucao);
    }
    public void selecionaStatusTarefa(String status)
    {
        comboBoxSelectByVisibleText(statusCombo, status);
    }
    public void selecinaComboPrioridade(String prioridade)
    {
        comboBoxSelectByVisibleText(prioridadeCombo, prioridade);
    }
}
