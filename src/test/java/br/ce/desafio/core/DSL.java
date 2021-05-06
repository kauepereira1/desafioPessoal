package br.ce.desafio.core;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escrever(String xpath, String texto){
        driver.findElement(By.xpath(xpath)).sendKeys(texto);
    }

    public void clicar(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public String validarTextoPaginaInicial(String texto){
        return texto = driver.findElement(By.partialLinkText(texto)).getText();
    }

    public void clicarAlert(){
        driver.switchTo().alert().accept();
    }

    public void clicarLinkTexto(String texto){
        driver.findElement(By.partialLinkText(texto)).click();
    }

    public String validarTextoTask(String xpath){
       return driver.findElement(By.xpath(xpath)).getText();
    }
}
