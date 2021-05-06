package br.ce.desafio.steps;

import br.ce.desafio.core.DSL;
import br.ce.desafio.page.CadastroTaskPage;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroTask {

    private WebDriver driver;
    private DSL dsl;
    private CadastroTaskPage page;

    @Before
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "c:\\Temp\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        dsl = new DSL(driver);
        page = new CadastroTaskPage(driver);

    }

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        driver.get("https://demo.suiteondemand.com");
    }

    @Quando("informo usuário {string}")
    public void informoUsuário(String usuario) {
       page.setUser(usuario);
    }
    @Quando("a senha {string}")
    public void aSenha(String senha) {
        page.setPassword(senha);
        page.setClicarLogin();
    }
    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        Assert.assertEquals("SUITECRM DASHBOARD", page.setTextoPaginaInicial());

    }
    @Quando("seleciono Create")
    public void selecionoCreate() {
        dsl.clicarLinkTexto("CREATE");

    }
    @Quando("seleciono Create Task")
    public void selecionoCreateTask() {
        dsl.clicarLinkTexto("Create Tasks");

    }
    @Quando("preencho os campos")
    public void preenchoOsCampos() {

        dsl.escrever("//input[@id='name']","Test");
        dsl.escrever("//input[@id='date_start_date']","06/05/1998");
        dsl.escrever("//select[@id='date_start_hours']", "11");
        dsl.escrever("//select[@id='date_start_minutes']","15");


        dsl.escrever("//input[@id='date_due_date']", "06/05/2021");
        dsl.clicar("//select[@id='status']");
        dsl.clicar("//select[@id='status']//option[@label='In Progress']");
        dsl.escrever("//input[@id='contact_name']", "Test Contact");


    }
    @Então("vejo que a task foi cadastrada com sucesso.")
    public void vejoQueATaskFoiCadastradaComSucesso() {

        dsl.clicar("//*[@id=\"EditView\"]/table/tbody/tr/td[1]/div//*[@id='SAVE']");
        Assert.assertEquals("TEST",dsl.validarTextoTask("//h2[@class='module-title-text']"));
    }

    @E("clico na opção Actions")
    public void clicoNaOpçãoActions() {
        dsl.clicar("//li[@id='tab-actions']");

    }

    @E("clico em Editar")
    public void clicoEmEditar() {
        dsl.clicar("//input[@id='edit_button']");
    }

    @Então("o arquivo é alterado com sucesso")
    public void oArquivoÉAlteradoComSucesso() {
        dsl.escrever("//input[@id='name']"," Editado");
        dsl.clicar("//*[@id=\"EditView\"]/table/tbody/tr/td[1]/div//*[@id='SAVE']");
        Assert.assertEquals("TEST EDITADO", dsl.validarTextoTask("//h2[@class='module-title-text']"));
    }

    @E("clico em Deletar")
    public void clicoEmDeletar() {
        dsl.clicar("//input[@id='delete_button']");
        dsl.clicarAlert();
    }

    @Então("o arquivo é deletado com sucesso")
    public void oArquivoÉDeletadoComSucesso() {
        dsl.clicar("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[1]/td[1]/input");
        dsl.clicar("//*[@id=\"delete_listview_top\"]/label[2]");
        dsl.clicar("//*[@id=\"actionLinkTop\"]/li/ul//*[@id='delete_listview_top']");
        dsl.clicarAlert();

    }
}
