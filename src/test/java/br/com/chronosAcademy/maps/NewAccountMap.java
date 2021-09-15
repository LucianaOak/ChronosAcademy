package br.com.chronosAcademy.maps;

import br.com.chronosAcademy.core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountMap {
    public static WebElement textCreateAccount;
    NewAccountMap newAccountMap;


    public NewAccountMap(){
    newAccountMap = new NewAccountMap();
        PageFactory.initElements(Driver.getDriver(), newAccountMap);
    }
}

