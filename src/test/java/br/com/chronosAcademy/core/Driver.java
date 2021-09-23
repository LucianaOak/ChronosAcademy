package br.com.chronosAcademy.core;

import br.com.chronosAcademy.enuns.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Driver {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String nomeCenario;
    private static File diretorio;
    private static int numPrint;

    public static String getNomeCenario() {
        return nomeCenario;
    }

    public static void setNomeCenario(String nomeCenario) {
        Driver.nomeCenario = nomeCenario;
    }

    public static <nomeCenario> void criaDiretorio(){
        String caminho = "scr/test/resources/evidencias";
            diretorio = new File(caminho+"/"+nomeCenario);
        diretorio.mkdir();
        numPrint = 0;
    }

    public static void printScreen(String passo) throws IOException{
        numPrint++;
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String caminho = diretorio.getPath()+"/"+passo+".png";
        FileUtils.copyFile(file, new File(caminho));
    }

    public Driver( Browser navegador){

        switch (navegador){

            case CHROME:
                starChrome();
                break;
            case FIREFOX:
                startFirefox();
                break;
            case EDGE:
                startEdge();
                break;
            case IE:
                startIe();
                break;

        }
        wait = new WebDriverWait(driver, 10);

    }

    private void startIe() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
    }

    private void startEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void starChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
        chromeOptions.setHeadless(headless);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visibilityOf(WebElement element){wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void invisibilityOf(WebElement element){wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void attributeChange(WebElement element, String attribute, String value) {
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));

    }
}


