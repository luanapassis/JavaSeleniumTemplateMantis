package com.seleniumMantis.tests;

import com.seleniumMantis.bases.TestBase;
import com.seleniumMantis.dbSteps.DataBaseSteps;
import com.seleniumMantis.flows.LoginFlow;
import com.seleniumMantis.page.GerenciarMarcadoresPage;
import com.seleniumMantis.page.GerenciarProjetoPage;
import com.seleniumMantis.page.GerenciarUsuarioPage;
import com.seleniumMantis.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GerenciarTests extends TestBase {

    //objects
    DataBaseSteps db;
    LoginFlow loginFlow;
    GerenciarUsuarioPage gerenciarUsuarioPage;
    GerenciarProjetoPage gerenciarProjetoPage;
    GerenciarMarcadoresPage gerenciarMarcadoresPage;

    @Test
    public void verificaTrocaPerfilAdministrador()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAtualizar = "usuario1";
        String perfil = "administrador";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAtualizar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.selecionaNivelUsuario(perfil);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String status = db.retornaNivelAcesso(usuarioAtualizar);

        Assert.assertEquals(  "90",status);
    }
    @Test
    public void inativaUsuario()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioDesativar = "usuario1";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioDesativar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.desabilitaUsuario();
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String status = db.retornaStatusUsuario(usuarioDesativar);

        Assert.assertEquals(  "0",status);
    }
    @Test
    public void verificaTrocaPerfilGerente()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAtualizar = "usuario1";
        String perfil = "gerente";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAtualizar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.selecionaNivelUsuario(perfil);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String status = db.retornaNivelAcesso(usuarioAtualizar);

        Assert.assertEquals(  "70",status);
    }
    @Test
    public void verificaTrocaPerfilDesenvolvedor()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAtualizar = "usuario1";
        String perfil = "desenvolvedor";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAtualizar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.selecionaNivelUsuario(perfil);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String status = db.retornaNivelAcesso(usuarioAtualizar);

        Assert.assertEquals(  "55",status);
    }
    @Test
    public void verificaTrocaPerfilAtualizador()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAtualizar = "usuario1";
        String perfil = "atualizador";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAtualizar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.selecionaNivelUsuario(perfil);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String status = db.retornaNivelAcesso(usuarioAtualizar);

        Assert.assertEquals(  "40",status);
    }
    @Test
    public void verificaTrocaPerfilRelator()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAtualizar = "usuario1";
        String perfil = "relator";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAtualizar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.selecionaNivelUsuario(perfil);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String status = db.retornaNivelAcesso(usuarioAtualizar);

        Assert.assertEquals(  "25",status);
    }
     @Test
    public void verificaTrocaPerfilVisualizador()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAtualizar = "usuario1";
        String perfil = "visualizador";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAtualizar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.selecionaNivelUsuario(perfil);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String status = db.retornaNivelAcesso(usuarioAtualizar);

        Assert.assertEquals(  "10",status);
    }
    @Test
    public void verificaAlteracaoEmailUsuario()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAtualizar = "usuario1";
        String email = "teste@hotmail.com";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAtualizar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.preencheEmail(email);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String novoEmail = db.retornaEmailUsuario(usuarioAtualizar);

        Assert.assertEquals( email,novoEmail);
    }
    @Test
    public void apagaUsuario()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioApagar = "usuario1";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioApagar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.apagaUsuario();

        String usu = db.retornaUsuario(usuarioApagar);

        Assert.assertNull(usu);
    }
    @Test
    public void alteraNomeUsuario()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAlterar = "testeAlteraNome";
        String novoNomeUsuario = "NovoNome"+ Utils.returnStringWithRandomCharacters(4);

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAlterar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.preencheNomeUsuario(novoNomeUsuario);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String usu = db.retornaNomeUsuario("alteraNome@gmail.com");

        Assert.assertEquals(novoNomeUsuario, usu);
    }
    @Test
    public void alteraNomeRealUsuario()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioAlterar = "testeAlteraNome";
        String novoNomeRealUsuario = "NovoNome" + Utils.returnStringWithRandomCharacters(4);

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.pesquisarUsuario(usuarioAlterar);
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
        gerenciarUsuarioPage.preencheNomeVerdadeiro(novoNomeRealUsuario);
        gerenciarUsuarioPage.gravaAlteracaoUsuario();

        String usu = db.retornaNomeRealUsuario("alteraNome@gmail.com");

        Assert.assertEquals(novoNomeRealUsuario, usu);
    }
    @Test
    public void criaNovoUsuario()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioCriar = "Usu"+ Utils.returnStringWithRandomCharacters(4);
        String nomeCriar = "Nome"+ Utils.returnStringWithRandomCharacters(4);
        String emailCriar = "a"+ Utils.returnStringWithRandomCharacters(4)+"@gmail.com";
        String nivelAcessoCriar = "administrador";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.criarNovoUsuario();
        gerenciarUsuarioPage.preencheCampoNovoNomeUsuario(usuarioCriar);
        gerenciarUsuarioPage.preencheCampoNovoNomeReal(nomeCriar);
        gerenciarUsuarioPage.preencheCampoNovoEmail(emailCriar);
        gerenciarUsuarioPage.preencheCampoNovoNivel(nivelAcessoCriar);
        gerenciarUsuarioPage.confirmarNovoUsuario();

        String usu = db.retornaUsuario(usuarioCriar);

        Assert.assertNotNull(usu);
    }
    @Test
    public void criaUsuarioNomeJaCadastrado()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioCriar = "Usuario1";
        String nomeCriar = "Nome"+ Utils.returnStringWithRandomCharacters(4);
        String emailCriar = "a" + Utils.returnStringWithRandomCharacters(4) + "@gmail.com";
        String nivelAcessoCriar = "administrador";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.criarNovoUsuario();
        gerenciarUsuarioPage.preencheCampoNovoNomeUsuario(usuarioCriar);
        gerenciarUsuarioPage.preencheCampoNovoNomeReal(nomeCriar);
        gerenciarUsuarioPage.preencheCampoNovoEmail(emailCriar);
        gerenciarUsuarioPage.preencheCampoNovoNivel(nivelAcessoCriar);
        gerenciarUsuarioPage.confirmarNovoUsuario();
        boolean msgErro = gerenciarUsuarioPage.retornaMsgErro();

        String usu = db.retornaUsuario(usuarioCriar);

        Assert.assertTrue(msgErro);
    }
    @Test
    public void criaUsuarioEmailJaCadastrado()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        String usuarioCriar = "Usu"+ Utils.returnStringWithRandomCharacters(4);
        String nomeCriar = "Nome" + Utils.returnStringWithRandomCharacters(4);
        String emailCriar = "luana.assis1@gmail.com";
        String nivelAcessoCriar = "administrador";

        loginFlow.fazLogin();
        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();
        gerenciarUsuarioPage.criarNovoUsuario();
        gerenciarUsuarioPage.preencheCampoNovoNomeUsuario(usuarioCriar);
        gerenciarUsuarioPage.preencheCampoNovoNomeReal(nomeCriar);
        gerenciarUsuarioPage.preencheCampoNovoEmail(emailCriar);
        gerenciarUsuarioPage.preencheCampoNovoNivel(nivelAcessoCriar);
        gerenciarUsuarioPage.confirmarNovoUsuario();
        boolean msgErro = gerenciarUsuarioPage.retornaMsgErro();

        String usu = db.retornaUsuario(usuarioCriar);

        Assert.assertTrue(msgErro);
    }

    //testes de gerenciamento de projetos
    @Test
    public void editarStadoParaRelease()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String estado = "release";
        String projeto = "Teste";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.abrirGridProjeto();
        gerenciarProjetoPage.selecaoComboEstado(estado);
        gerenciarProjetoPage.clicaBtnAtualizarProjeto();

        String status = db.retornaStatusProjeto(projeto);

        Assert.assertEquals(status, "30");
    }
    @Test
    public void editarStadoParaEstavel()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String estado = "estável";
        String projeto = "Teste";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.abrirGridProjeto();
        gerenciarProjetoPage.selecaoComboEstado(estado);
        gerenciarProjetoPage.clicaBtnAtualizarProjeto();

        String status = db.retornaStatusProjeto(projeto);

        Assert.assertEquals(status, "50");
    }
    @Test
    public void editarStadoParaObsoleto()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String estado = "obsoleto";
        String projeto = "Teste";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.abrirGridProjeto();
        gerenciarProjetoPage.selecaoComboEstado(estado);
        gerenciarProjetoPage.clicaBtnAtualizarProjeto();

        String status = db.retornaStatusProjeto(projeto);

        Assert.assertEquals(status, "70");
    }
    @Test
    public void criarNovoProjeto()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String nomeProjeto = "Projeto Teste Automatizado";
        String estadoProjeto = "release";
        String visibilidadeProjeto = "público";
        String descricaoProjeto = "Inserindo projeto atravez de testes automaziados.";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.clicarBtnNovoProjeto();
        gerenciarProjetoPage.preencheNomeProjeto(nomeProjeto);
        gerenciarProjetoPage.selecaoComboEstado(estadoProjeto);
        gerenciarProjetoPage.selecionarVisibilidade(visibilidadeProjeto);
        gerenciarProjetoPage.preencheDescricaoProjeto(descricaoProjeto);
        gerenciarProjetoPage.clicarAdicionarProjeto();

        ArrayList<String> dadosProjeto = db.retornaDadosProjeto(nomeProjeto);

        Assert.assertNotNull(dadosProjeto);
    }
    @Test
    public void alterarVisibilidadePrivado()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String visibilidade = "privado";
        String projeto = "Teste";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.abrirGridProjeto();
        gerenciarProjetoPage.selecionarVisibilidade(visibilidade);
        gerenciarProjetoPage.clicaBtnAtualizarProjeto();

        String view = db.retornaVisibilidadeProjeto(projeto);

        Assert.assertEquals(view, "50");
    }
    @Test
    public void alterarVisibilidadePublico()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String visibilidade = "público";
        String projeto = "Teste";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.abrirGridProjeto();
        gerenciarProjetoPage.selecionarVisibilidade(visibilidade);
        gerenciarProjetoPage.clicaBtnAtualizarProjeto();

        String view = db.retornaVisibilidadeProjeto(projeto);

        Assert.assertEquals(view, "10");
    }
    @Test
    public void vincularSubProjeto()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String projeto = "Teste";
        String subProjeto = "Teste SubProjeto";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.abrirGridProjeto();
        gerenciarProjetoPage.selecionaSubProjeto(subProjeto);
        gerenciarProjetoPage.adicionarSubProjeto();

        ArrayList<String> dadosProjetoPai = db.retornaDadosProjeto(projeto);
        String idProjetoPai = dadosProjetoPai.get(0);

        ArrayList<String> dadosProjetoFilho = db.retornaDadosProjeto(subProjeto);
        String idProjetoFilho = dadosProjetoFilho.get(0);

        ArrayList<String> dadosVinculo = db.retornaVinculoSubProjeto(idProjetoPai, idProjetoFilho);

        Assert.assertNotNull(dadosVinculo);

    }
    @Test
    public void desabilitarProjeto()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String projeto = "Teste";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.abrirGridProjeto();
        gerenciarProjetoPage.desabilitaProjeto();
        gerenciarProjetoPage.clicaBtnAtualizarProjeto();

        ArrayList<String> dadosProjeto = db.retornaDadosProjeto(projeto);
        String status = dadosProjeto.get(3);

        Assert.assertEquals(status, "0");

    }
    @Test
    public void cadastrarProjetoNomeJaExistente()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarProjetoPage = new GerenciarProjetoPage();

        String nomeProjeto = "Teste";
        String estadoProjeto = "desenvolvimento";
        String visibilidadeProjeto = "público";
        String descricaoProjeto = "Inserindo projeto atravez de testes automaziados.";

        loginFlow.fazLogin();
        gerenciarProjetoPage.abrirMenuGerenciarProjeto();
        gerenciarProjetoPage.clicarBtnNovoProjeto();
        gerenciarProjetoPage.preencheNomeProjeto(nomeProjeto);
        gerenciarProjetoPage.selecaoComboEstado(estadoProjeto);
        gerenciarProjetoPage.selecionarVisibilidade(visibilidadeProjeto);
        gerenciarProjetoPage.preencheDescricaoProjeto(descricaoProjeto);
        gerenciarProjetoPage.clicarAdicionarProjeto();
        boolean msg = gerenciarProjetoPage.retornaMsgErro();

        ArrayList<String> dadosProjeto = db.retornaDadosProjeto(nomeProjeto);

        Assert.assertTrue(msg);
        Assert.assertTrue(dadosProjeto.size() == 10);
    }
    @Test
    public void editarNomeMarcador()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarMarcadoresPage = new GerenciarMarcadoresPage();

        String novoNomeMarcador = "NovoNomeMarcador";
        String descricaoMarcador = "descricao";

        loginFlow.fazLogin();
        gerenciarMarcadoresPage.abrirMenuGerenciarMarcadores();
        gerenciarMarcadoresPage.selecionaMarcadorTeste();
        gerenciarMarcadoresPage.clicaAtualizarMarcador();
        gerenciarMarcadoresPage.preencheNomeMarcador(novoNomeMarcador);
        gerenciarMarcadoresPage.clicaAtualizarMarcador();

        ArrayList<String> marcadorRetornado = db.retornaMarcadorPorDescricao(descricaoMarcador);
        String nomeMarcadorBD = marcadorRetornado.get(2);

        Assert.assertEquals(nomeMarcadorBD, novoNomeMarcador);
    }
        @Test
    public void cadastrarNomeMarcadorJaExistente()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarMarcadoresPage = new GerenciarMarcadoresPage();

        String novoNomeMarcadorAtualizar = "marcadorTeste2";
        String descricaoMarcador = "descricao";

        loginFlow.fazLogin();
        gerenciarMarcadoresPage.abrirMenuGerenciarMarcadores();
        gerenciarMarcadoresPage.selecionaMarcadorTeste();
        gerenciarMarcadoresPage.clicaAtualizarMarcador();
        gerenciarMarcadoresPage.preencheNomeMarcador(novoNomeMarcadorAtualizar);
        gerenciarMarcadoresPage.clicaAtualizarMarcador();
        boolean msgErro = gerenciarMarcadoresPage.retornaMsgErro();

        ArrayList<String> marcadorRetornado = db.retornaMarcadorPorNome(novoNomeMarcadorAtualizar);

        Assert.assertEquals(marcadorRetornado.size() , 6);
        Assert.assertTrue(msgErro);
    }
        @Test
    public void editarDescricaoMarcador()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarMarcadoresPage = new GerenciarMarcadoresPage();

        String novaDescricaoMarcador = "Nova descrição para marcador";

        loginFlow.fazLogin();
        gerenciarMarcadoresPage.abrirMenuGerenciarMarcadores();
        gerenciarMarcadoresPage.selecionaMarcadorTeste2();
        gerenciarMarcadoresPage.clicaAtualizarMarcador();
        gerenciarMarcadoresPage.preencheDescricaoMarcador(novaDescricaoMarcador);
        gerenciarMarcadoresPage.clicaAtualizarMarcador();

        ArrayList<String> marcadorRetornado = db.retornaMarcadorPorNome("marcadorTeste2");
        String descricaoMarcadorBD = marcadorRetornado.get(3);

        Assert.assertEquals(novaDescricaoMarcador, descricaoMarcadorBD);
    }
        @Test
    public void criarNovoMarcador()
    {
        db = new DataBaseSteps();
        loginFlow = new LoginFlow();
        gerenciarMarcadoresPage = new GerenciarMarcadoresPage();

        String nomeMarcador = "CadastroMarcador" + Utils.returnStringWithRandomCharacters(4);
        String descricaoMarcador = "Descricao Marcador " + Utils.returnStringWithRandomCharacters(3)+Utils.returnStringWithRandomCharacters(3);

        loginFlow.fazLogin();
        gerenciarMarcadoresPage.abrirMenuGerenciarMarcadores();
        gerenciarMarcadoresPage.clicaBtnCriarMarcador();
        gerenciarMarcadoresPage.preencheNomeMarcador(nomeMarcador);
        gerenciarMarcadoresPage.preencheDescricaoMarcador(descricaoMarcador);
        gerenciarMarcadoresPage.clicaBtnConfirmarCriacaoMarcador();

        ArrayList<String> marcadorBD = db.retornaMarcadorPorNome(nomeMarcador);

        Assert.assertNotNull(marcadorBD);
    }
}
