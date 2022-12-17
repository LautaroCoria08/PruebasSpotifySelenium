package tests;

import org.openqa.selenium.By;
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
    public void  CP001_Inicio_Sesion_Apple(){
        homePage.irAInicioSesion();
        homePage.irAInicioApple();
    }
    @Test
    public void CP002_Registro_Fallido_Mes(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("lautaro.coria@tsoftgloblal.com","lautaro.coria@tsoftgloblal.com","1234","Lautaro","08","","1998");
        Assert.assertEquals("Selecciona tu mes de nacimiento",registerPage.obtenerErrorMesFallido());
    }
    @Test
    public void CP003_Inicio_Sesion_con_Google(){
        homePage.irAInicioSesion();
        homePage.irAInicioGoogle();
    }
    @Test
     public void CP004_Inicio_Sesion_con_Facebook() {
        homePage.irAInicioSesion();
        homePage.irAInicioFacebook();
    }
    @Test
    public void CP005_Contraseña_Corta(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("lautaro.coria@tsoftglobal.com", "lautaro.coria@tsoftglobal.com", "1", "Lautaro", "08", "Abril", "1998");

        Assert.assertEquals("Tu contraseña es demasiado corta.",registerPage.obtenerErrorPasswordCorta());
    }

    @AfterMethod
    public void posTests(){
        registerPage.cerrarBrowser();
    }


}