package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class CPs {
    //Atributos
    private HomePage homePage;
    private RegisterPage registerPage;
    private WebDriver driver;
    private String browser = "CHROME";
    private String propertyDriver = "webdriver.chrome.driver";
    private String urlDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String url = "https://www.spotify.com/";

    @BeforeMethod
    public void preparacionTests(){
        homePage = new HomePage(driver); //Se crea la page del home
        homePage.conexionBrowser(browser,propertyDriver,urlDriver); //Se conecta el driver de chrome
        registerPage = new RegisterPage(homePage.getDriver()); //se crea la page de registro

        homePage.cargarPagina(url);
        homePage.maximizarBrowser();
    }


    @Test
public void  CP002_Inicio_Sesion_Apple(){
        homePage.irAInicioSesion();
        homePage.irAInicioApple();



    }

    @Test
    public void CP002_Registro_Fallido_Mes(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("lautaro.coria@tsoftgloblal.com","lautaro.coria@tsoftgloblal.com","1234","Lautaro","08","10","1998");
        Assert.assertEquals("Confirma que no eres un robot.",registerPage.obtenerErrorCaptchaVacio());


    }

    @Test
    public void CP005_Contraseña_Corta(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("","","12","","","","");
        //Assert.assertEquals("Contraseña Corta",registerPage.());

    }






    @AfterMethod
    public void posTests(){
        registerPage.cerrarBrowser();
    }


}