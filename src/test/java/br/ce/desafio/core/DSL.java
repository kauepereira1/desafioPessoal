package br.ce.desafio.core;

import org.openqa.selenium.By;

import static br.ce.desafio.core.DriverFactory.getDriver;

public class DSL {


    public void escrever(String xpath, String texto) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(texto);
    }

    public void clicar(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public String validarTextoPaginaInicial(String texto) {
        return texto = getDriver().findElement(By.partialLinkText(texto)).getText();
    }

    public void clicarAlert() {
        getDriver().switchTo().alert().accept();
    }

    public void clicarLinkTexto(String texto) {
        getDriver().findElement(By.partialLinkText(texto)).click();
    }

    public String validarTextoTask(String xpath) {
        return getDriver().findElement(By.xpath(xpath)).getText();
    }

}
