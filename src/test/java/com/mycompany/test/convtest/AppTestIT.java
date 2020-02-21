package com.mycompany.test.convtest;

import java.math.BigDecimal;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

/**
 *
 * @author J.JanieR
 */
public class AppTestIT {
    
    private static WebDriver driver = null;
    
    public AppTestIT() {
    }
    
    @BeforeClass
    public static void inicializarDriver() {
        driver = new ChromeDriver();
    }
    
    @AfterClass
    public static void liquidarDriver() {
        driver.quit();
    }

    @org.junit.Test
    public void ComprobarFlujoBusquedad() {
        
        driver.get("https://www.choucairtesting.com/empleos-testing/");
        
        WebElement palabraElem = driver.findElement(By.id("search_keywords"));
        palabraElem.sendKeys("Analista");  
        WebElement ubicacionElem = driver.findElement(By.id("search_location"));
        ubicacionElem.sendKeys("Medellin");
        
        WebElement cmdBuscar = driver.findElement(By.xpath("//input[@type='submit']"));
        cmdBuscar.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[contains(Búsqueda completada.)]"))));
        WebElement errorMessageElement = driver.findElement(By.xpath("//span[contains(Búsqueda completada.)]"));
        Assert.assertTrue(errorMessageElement.getText().toLowerCase().contains("Búsqueda completada"),"error");
    
        driver.close();
    }
    
}
