package br.com.chronosAcademy.steps;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.enuns.Browser;
import br.com.chronosAcademy.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class LoginSteps<NewAccountPage, Cenario> {
    LoginPage loginPage;
    NewAccountPage newAccountPage = new NewAccountPage();
    String username;


    @Before
    public void iniciaNavegador(Scenario cenario){
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario){
        Driver.getDriver().quit();
        System.out.println(Driver.getNomeCenario()+" - " + cenario.getStatus());
        System.out.println(cenario.isFailed());
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://www.advantageonlineshopping.com/");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();
    }
    @Quando("for realizado um clique fora da modal")
    public void forRealizadoUmCliqueForaDaModal() {
        loginPage.clickDivFechaModal();
    }
    @Entao("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        } catch (Exception e){
            throw new Exception("A janela modal não foi fechada");
        }

    }
    @Quando("for realizado um clique icone de fechar da modal")
    public void forRealizadoUmCliqueIconeDeFecharDaModal() {
        loginPage.clickBtnFechar();
    }


    @Quando("for realizado um clique em Create New Account")
    public void forRealizadoUmCliqueEmCreateNewAccount() {
        loginPage.clickLinkCreateAccount();
    }

    @Entao("a pagina Create Account deve ser exibida")
    public void aPaginaCreateAccountDeveSerExibida() {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
    }


    @Quando("os campos de login forem preenchidos com os valores")
    public void osCamposDeLoginForemPreenchidosComOsValores(Map<String, String> map) throws IOException {
        username = map.get("usuario");
        String password = map.get("senha");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);

        if (remember) loginPage.clickInpRemember();

        Driver.printScreen("preenchimento dos campos de Login");
    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSignIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() throws IOException {
        assertEquals(username, loginPage.getTextLogado());
        Driver.printScreen("Logado no sistema");
    }

    @Entao("o sistema devera exibir uma mensagem de erro")
    public void oSistemaDeveraExibirUmaMensagemDeErro() {
        assertEquals("Incorrect user name or password.",loginPage.getErroLogin());
    }

    @Entao("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        assertFalse(enabled);
    }
}