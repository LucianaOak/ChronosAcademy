package br.com.chronosAcademy.maps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursoMap {
    WebDriver driver;
    CursoMap cursoMap;
    @FindBy(xpath = "//section[2]//h2")
    public WebElement h2Titulo;
}
