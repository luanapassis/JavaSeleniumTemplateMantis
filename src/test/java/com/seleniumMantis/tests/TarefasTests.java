package com.seleniumMantis.tests;

import com.seleniumMantis.GlobalParameters;
import com.seleniumMantis.bases.TestBase;
import com.seleniumMantis.dbSteps.DataBaseSteps;
import com.seleniumMantis.flows.*;
import com.seleniumMantis.page.*;
import com.seleniumMantis.utils.Utils;
import com.seleniumMantis.tests.preTests.PreTestMethods;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class TarefasTests extends TestBase
{
    //objects
    DataBaseSteps db;
    LoginFlow loginFlow;
    HomePage homePage;
    TarefasPage tarefasPage;
    PreTestMethods preTest;
    MinhaVisaoPage minhaVisaoPage;
    VerTarefasPage verTarefasPage;

    @Test
    public void criaTarefaSucesso()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomCharacters(4);
        String descricao = "Descricao Tarefa " + Utils.returnStringWithRandomCharacters(4);

        loginFlow.fazLogin();
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

        Assert.assertNotNull(tarefaBD);
        Assert.assertEquals(resumo, tarefaBD.get(21));
    }

   @Test
    public void verificaTarefaCriadaEmMinhaVisao()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        preTest = new PreTestMethods();
        minhaVisaoPage = new MinhaVisaoPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa " + Utils.returnStringWithRandomNumbers(4);

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        minhaVisaoPage.abrirMenuMinhaVisao();
        boolean tarefaExiste = minhaVisaoPage.verificaExistenciaTarefaMinhaVisao(idTarefa);

        Assert.assertTrue(tarefaExiste);
    }
    @Test
    public void verificaFiltroTarefa()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa " + Utils.returnStringWithRandomNumbers(4);

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        verTarefasPage.abrirMenuVerTarefas();
        verTarefasPage.preencheFiltroTarefa(idTarefa);
        verTarefasPage.clicarFiltrarTarefa();
        String idRetornadoGrid = verTarefasPage.retornaIdGridTarefa();

        Assert.assertEquals(idTarefa, idRetornadoGrid);
    }
        @Test
    public void adicionaMarcadorTarefa()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String tag = "tag";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.preencheTag(tag);
        verTarefasPage.clicaAplicarTag();

        ArrayList<String> tagTarefaBD = db.retornaTagTarefa(Integer.parseInt(idTarefa));

        Assert.assertNotNull(tagTarefaBD);
    }
        @Test
    public void removeMarcadorTarefa()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa "+ Utils.returnStringWithRandomNumbers(4);
        String tag = "tag";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.preencheTag(tag);
        verTarefasPage.clicaAplicarTag();

        ArrayList<String> tagTarefaBD = db.retornaTagTarefa(Integer.parseInt(idTarefa));

        verTarefasPage.clicaBtnRemoverTag();

        ArrayList<String> tagTarefaAposDeletarBD = db.retornaTagTarefa(Integer.parseInt(idTarefa));

        Assert.assertNotNull(tagTarefaBD);
        Assert.assertNull(tagTarefaAposDeletarBD);
    }
        @Test
    public void adicionaRelacaoInvalida()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa "+ Utils.returnStringWithRandomNumbers(4);
        String relacao = "relacaoIvalida";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.preencheRelacaoTarefa(relacao);
        verTarefasPage.clicaBtnAddRelacao();
        boolean msgErro= verTarefasPage.retornaMsgErro();

        Assert.assertTrue(msgErro);
    }
        @Test
    public void adicionaRelacaoSucesso()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa "+ Utils.returnStringWithRandomNumbers(4);
        String tipoRelacao = "está relacionado a";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int relacao = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.selecionaComboTipoRelacao(tipoRelacao);
        verTarefasPage.preencheRelacaoTarefa(Integer.toString(relacao-1));
        verTarefasPage.clicaBtnAddRelacao();

        ArrayList<String> relacaoTarefaBD = db.retornaRelacaoTarefa(Integer.parseInt(idTarefa));
        Assert.assertEquals(Integer.toString(relacao - 1), relacaoTarefaBD.get(2));
        Assert.assertEquals("1", relacaoTarefaBD.get(3));
    }
        @Test
    public void adicionaRelacaoPaiSucesso()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String tipoRelacao = "é pai de";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int relacao = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.selecionaComboTipoRelacao(tipoRelacao);
        verTarefasPage.preencheRelacaoTarefa(Integer.toString(relacao - 1));
        verTarefasPage.clicaBtnAddRelacao();

        ArrayList<String> relacaoTarefaBD = db.retornaRelacaoTarefa(Integer.parseInt(idTarefa));
        Assert.assertEquals(Integer.toString(relacao - 1), relacaoTarefaBD.get(2));
        Assert.assertEquals("2", relacaoTarefaBD.get(3));
    }
        @Test
    public void adicionaRelacaoFilhoSucesso()
    {
        db =  new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String tipoRelacao = "é filho de";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int relacao = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.selecionaComboTipoRelacao(tipoRelacao);
        verTarefasPage.preencheRelacaoTarefa(Integer.toString(relacao - 1));
        verTarefasPage.clicaBtnAddRelacao();

        ArrayList<String> relacaoTarefaBD = db.retornaRelacaoTarefa(relacao - 1);
        Assert.assertEquals(Integer.toString(relacao - 1), relacaoTarefaBD.get(1));
        Assert.assertEquals("2", relacaoTarefaBD.get(3));

    }
        @Test
    public void adicionaRelacaoDuplicadaSucesso()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa " + Utils.returnStringWithRandomNumbers(4);
        String tipoRelacao = "é duplicado de";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int relacao = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.selecionaComboTipoRelacao(tipoRelacao);
        verTarefasPage.preencheRelacaoTarefa(Integer.toString(relacao - 1));
        verTarefasPage.clicaBtnAddRelacao();

        ArrayList<String> relacaoTarefaBD = db.retornaRelacaoTarefa(Integer.parseInt(idTarefa));
        Assert.assertEquals(Integer.toString(relacao - 1),relacaoTarefaBD.get(2) );
        Assert.assertEquals("0", relacaoTarefaBD.get(3));

    }
        @Test
    public void adicionaRelacaoPossuiDuplicidadeSucesso()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String tipoRelacao = "possui duplicado";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int relacao = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.selecionaComboTipoRelacao(tipoRelacao);
        verTarefasPage.preencheRelacaoTarefa(Integer.toString(relacao - 1));
        verTarefasPage.clicaBtnAddRelacao();

        ArrayList<String> relacaoTarefaBD = db.retornaRelacaoTarefa(relacao - 1);
        Assert.assertEquals(Integer.toString(relacao - 1), relacaoTarefaBD.get(1));
        Assert.assertEquals("0", relacaoTarefaBD.get(3));

    }
        @Test
    public void atribuiTarefaUsuario()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String usuario = GlobalParameters.USUARIO;


        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int bugIdInt = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.clicaBtnAtualizarTarefa();
        verTarefasPage.selecinaComboAtribuicao(usuario);
        verTarefasPage.clicaBntConfirmaAtualizacaoTarefa();

        String idUsuario = db.retornaidUsuario(usuario);
        ArrayList<String> tarefaBD = db.retornaTarefaCriadaPorId(Integer.toString(bugIdInt));

        Assert.assertEquals( idUsuario, tarefaBD.get(3));
    }
        @Test
    public void tentaResolverTarefaComStatusNovo()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        tarefasPage = new TarefasPage();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String resolucao = "corrigido";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int bugIdInt = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.clicaBtnAtualizarTarefa();
        verTarefasPage.selecionaComboResolucao(resolucao);
        verTarefasPage.clicaBntConfirmaAtualizacaoTarefa();
        boolean msgErro = verTarefasPage.retornaMsgErro();

        Assert.assertTrue(msgErro);
    }
    @Test
    public void tentaResolverTarefaSucesso()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String status = "resolvido";
        String resolucao = "corrigido";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int bugIdInt = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.clicaBtnAtualizarTarefa();
        verTarefasPage.selecionaStatusTarefa(status);
        verTarefasPage.selecionaComboResolucao(resolucao);
        verTarefasPage.clicaBntConfirmaAtualizacaoTarefa();

        ArrayList<String> tarefaBD = db.retornaTarefaCriadaPorId(Integer.toString(bugIdInt));

        Assert.assertTrue(tarefaBD.get(9).contains("20"));
    }
        @Test
    public void alteraPrioridadeTarefa()
    {
        db = new DataBaseSteps();
        preTest = new PreTestMethods();
        loginFlow = new LoginFlow();
        homePage = new HomePage();
        verTarefasPage = new VerTarefasPage();

        String projeto = "Teste";
        String categoria = "[Todos os Projetos] General";
        String resumo = "Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String descricao = "Descricao Tarefa "  + Utils.returnStringWithRandomNumbers(4);
        String prioridade = "urgente";

        loginFlow.fazLogin();
        String idTarefa = preTest.PreTestCriarTarefa(projeto, categoria, resumo, descricao);
        int bugIdInt = Integer.parseInt(idTarefa);
        homePage.preenchePesquisaTarefa(idTarefa);
        verTarefasPage.clicaBtnAtualizarTarefa();
        verTarefasPage.selecinaComboPrioridade(prioridade);
        verTarefasPage.clicaBntConfirmaAtualizacaoTarefa();

        ArrayList<String> tarefaBD = db.retornaTarefaCriadaPorId(Integer.toString(bugIdInt));

        Assert.assertTrue(tarefaBD.get(5).contains("50"));
    }
}
