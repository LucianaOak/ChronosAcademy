package br.com.chronosAcademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUser")
    public WebElement btnLogin;
    @FindBy(css = ".closeBtn")
    public WebElement btnFechar;
    @FindBy(css = ".PopUp")
    public WebElement divFechaModal;
    @FindBy(css = "*[name = 'username']")
    public WebElement inpuserName;
    @FindBy(css = "*[name='password']")
    public WebElement inpPassword;
    @FindBy(css = "*[name = 'remember_me']")
    public WebElement inpRemember;
    @FindBy(css = "#sign_in_btnundefined")
    public WebElement btnSignIn;//click
    @FindBy(linkText = "CREATE NEW ACOUNT")
    public WebElement linkCreateAccount;//click


    public Object divLoader;
    public WebElement textLogado;
    public WebElement textErroLogin;
}
