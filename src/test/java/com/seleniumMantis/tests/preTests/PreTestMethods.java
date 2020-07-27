package com.seleniumMantis.tests.preTests;

import com.seleniumMantis.bases.TestBase;
import com.seleniumMantis.flows.LoginFlow;
import com.seleniumMantis.page.TarefasPage;
import com.seleniumMantis.dbSteps.DataBaseSteps;
import org.testng.Assert;

import java.util.ArrayList;

public class PreTestMethods extends TestBase
{
    public String PreTestCriarTarefa(String nomeProjeto, String nomeCategoria, String nomeResumo, String txtDescricao)
    {
        DataBaseSteps db = new DataBaseSteps();
        LoginFlow loginFlow = new LoginFlow();
        TarefasPage tarefasPage = new TarefasPage();


        String projeto = nomeProjeto;
        String categoria = nomeCategoria;
        String resumo = nomeResumo;
        String descricao = txtDescricao;

        tarefasPage.abrirMenuGerenciarUsuario();
        tarefasPage.selecionaProjeto(projeto);
        tarefasPage.clicarBtnSelecionarProjeto();
        tarefasPage.selecinaComboCategoria(categoria);
        tarefasPage.preencheCampoResumo(resumo);
        tarefasPage.preencheCampoDescricao(descricao);
        tarefasPage.clicaBtnCriarNovaTarefa();
        String bugIdTela = tarefasPage.retornaBugIdDaTela();
        int bugIdInt = Integer.parseInt(bugIdTela);

        ArrayList<String> tarefaBD = db.retornaTarefaCriadaPorId(Integer.toString(bugIdInt));

        Assert.assertTrue(tarefaBD.get(21).contains( resumo), "Tarefa não foi criada no Pre-Teste");
        return bugIdTela;
    }
}
