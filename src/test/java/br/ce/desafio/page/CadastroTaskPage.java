package br.ce.desafio.page;

import br.ce.desafio.core.DSL;
import org.openqa.selenium.WebDriver;

public class CadastroTaskPage {

    private DSL dsl;

    public CadastroTaskPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void setUser(String usuario){
        dsl.escrever("//*[@id='user_name']", usuario);
    }

    public void setPassword(String senha ){
        dsl.escrever("//*[@id='username_password']", senha);
    }

    public void setClicarLogin(){
        dsl.clicar("//*[@id='bigbutton']");
    }

    public String setTextoPaginaInicial(){
       return dsl.validarTextoPaginaInicial("SUITECRM DASHBOARD");
    }
}
