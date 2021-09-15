package br.com.chronosAcademy.automacaoweb;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.enuns.Browser;
import br.com.chronosAcademy.maps.PrincipalMap;
import br.com.chronosAcademy.pages.CursoPage;
import br.com.chronosAcademy.pages.PrincipalPage;
import io.cucumber.java.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class TesteWeb {
        WebDriver driver;
        Driver driverWeb;
        PrincipalPage principalPage;
        CursoPage cursoPage;


        @Before
        public void inicializaTeste() {
            driverWeb = new Driver(Browser.CHROME);
            driver = Driver.getDriver();
            driver.get("Https://www.chronosacademy.com.br");
            principalPage = new PrincipalPage(driver);
        }

        @Test
        public void primeiroTeste(){
            String titulo = principalPage.getTitulo();
            assertEquals("Porque Tempo É Conhecimento", titulo);
        }

        @Test
        public void segundoTeste(){
            clickBotao();
            WebElement h2Titulo = getTitulo2();
            assertEquals ("AUTOMAÇÃO SEM COMPLICAÇÃO WEB 2.0", h2Titulo);
    }

    private WebElement getTitulo2() {
        String xpathTitulo = "//section[2]//";
        WebElement h2Titulo = driver.findElement( By.xpath(xpathTitulo));
        String titulo = h2Titulo.getText();
        return h2Titulo;
    }

    private void clickBotao() {
        String xpathBotao = "//section[2]/div[3]//a";
        WebElement btnTitulo = driver.findElement(By.xpath(xpathBotao));
        btnTitulo.click();
    }

    @After
        public void finalizaTeste(){
            driver.quit();
        }
}






