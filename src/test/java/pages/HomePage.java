package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //las pages tienen por objetivo centralizar los localizador y acciones de pagina

    // Locators
    By locatorBtnRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");
    By locatorBtnInicioSesion = By.xpath("//span[text() = 'Iniciar sesión']");
    By locatorBtnInicioApple = By.xpath("//button[@data-testid= 'apple-login']");
    By locatorBtnInicioGoogle= By.xpath("//button[@data-testid='google-login']");

    By locartorBtnInicioFacebook= By.xpath("//button[@data-testid='facebook-login']");


    //Acciones
    public void irARegistrarte(){
        click(esperarAElementoWeb(locatorBtnRegistrarte));
    }
    public void irAInicioSesion(){ click(esperarAElementoWeb(locatorBtnInicioSesion));}
    public void irAInicioApple(){click(esperarAElementoWeb(locatorBtnInicioApple));}
    public void irAInicioGoogle(){click(esperarAElementoWeb(locatorBtnInicioGoogle));}
    public void irAInicioFacebook(){click(esperarAElementoWeb(locartorBtnInicioFacebook));}


}
