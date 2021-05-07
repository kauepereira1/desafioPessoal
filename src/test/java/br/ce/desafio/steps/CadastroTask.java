package br.ce.desafio.steps;

import br.ce.desafio.core.BaseSteps;
import br.ce.desafio.core.DSL;
import br.ce.desafio.page.CadastroTaskPage;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import static br.ce.desafio.core.DriverFactory.getDriver;

public class CadastroTask extends BaseSteps {


    private DSL dsl;
    private CadastroTaskPage page;

    @Before
    public void inicializa() {
        dsl = new DSL();
        page = new CadastroTaskPage();

    }

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        getDriver().get("https://demo.suiteondemand.com");
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
        page.setClicarEmCreate();

    }

    @Quando("seleciono Create Task")
    public void selecionoCreateTask() {
        page.setClicarEmCreateTask();

    }

    @Quando("preencho os campos")
    public void preenchoOsCampos() {

        page.setTextoCampoSubject("Test");
        page.setStartDate("06/05/1998");
        page.setDateHrs("11");
        page.setDateMinutes("15");

        page.setDateDue("06/05/2021");
        page.setClicarStatus();
        page.setClicarInProgress();
        page.setContactName("Test Contact");

    }

    @Então("vejo que a task foi cadastrada com sucesso.")
    public void vejoQueATaskFoiCadastradaComSucesso() {
        page.setClicarSave();
        Assert.assertEquals("TEST", page.setTextoTask());
    }

    @E("clico na opção Actions")
    public void clicoNaOpçãoActions() {
        page.setClicarActions();

    }

    @E("clico em Editar")
    public void clicoEmEditar() {
        page.setClicarEmEditar();
    }

    @Então("o arquivo é alterado com sucesso")
    public void oArquivoÉAlteradoComSucesso() {
        page.setTextoEditado(" Editado");
        page.setClicarSaveEditado();
        Assert.assertEquals("TEST EDITADO", page.setTextoTask());
    }

    @E("clico em Deletar")
    public void clicoEmDeletar() {
        page.setClicarDelet();
        page.setClicarAlert();
    }

    @Então("o arquivo é deletado com sucesso")
    public void oArquivoÉDeletadoComSucesso() {
        page.setClicarListDelet();
        page.setClicarEmDeletar();
        page.setClicarLinkAction();
        page.setClicarAlert();

    }
}
