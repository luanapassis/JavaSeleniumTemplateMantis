package com.seleniumMantis.page;

import com.seleniumMantis.bases.PageBase;
import org.openqa.selenium.By;

public class GerenciarProjetoPage extends PageBase
{
        By menuGerenciar = By.xpath("//a[@href= '/mantis/manage_overview_page.php']");
        By menuProjeto = By.xpath("//a[@href= '/mantis/manage_proj_page.php']");
        By projetoGrid = By.xpath("//a[contains(@href,'manage_proj_edit_page.php') and text()='Teste']");
        By estadoCombo = By.id("project-status");
        By atualizarProjetoButton = By.xpath("//input[@value='Atualizar Projeto']");
        By criarNovoProjetoButton = By.xpath("//button[text()='Criar Novo Projeto']");
        By nomeProjetoField = By.id("project-name");
        By visibiliadeCombo = By.id("project-view-state");
        By descricaoField = By.id("project-description");
        By adicionarProjetoButton = By.xpath("//input[@type='submit']");
        By subProjetoCombo= By.name("subproject_id");
        By adicionarSubProjetoButton = By.xpath("//input[@value='Adicionar como Subprojeto']");
        By enabledCheck = By.xpath("//label/span[@class='lbl']");
        By msgErro = By.xpath("//p[contains(text(),'APPLICATION ERROR')]");

        public void abrirMenuGerenciarProjeto()
        {
        click(menuGerenciar);
        click(menuProjeto);
        }

        public void abrirGridProjeto()
        {
        click(projetoGrid);
        }
        public void selecaoComboEstado(String estado)
        {
        comboBoxSelectByVisibleText(estadoCombo, estado);
        }
        public void clicaBtnAtualizarProjeto()
        {
        click(atualizarProjetoButton);
        }
        public void clicarBtnNovoProjeto()
        {
        click(criarNovoProjetoButton);
        }
        public void preencheNomeProjeto(String nome)
        {
        clearAndSendKeys(nomeProjetoField, nome);
        }
        public void selecionarVisibilidade(String visibilidade)
        {
        comboBoxSelectByVisibleText(visibiliadeCombo, visibilidade);
        }
        public void preencheDescricaoProjeto(String descricao)
        {
        clearAndSendKeys(descricaoField, descricao);
        }
        public void clicarAdicionarProjeto()
        {
        click(adicionarProjetoButton);
        }
        public void selecionaSubProjeto(String subProjeto)
        {
        comboBoxSelectByVisibleText(subProjetoCombo, subProjeto);
        }
        public void adicionarSubProjeto()
        {
        click(adicionarSubProjetoButton);
        }
        public void desabilitaProjeto()
        {
        click(enabledCheck);
        }
        public boolean retornaMsgErro()
        {
        return returnIfElementIsDisplayed(msgErro);
        }
}
