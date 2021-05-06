package br.ce.desafio.steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroTask {

    private WebDriver driver;

    @Before
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "c:\\Temp\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        driver.get("https://demo.suiteondemand.com");
    }

    @Quando("informo usuário {string}")
    public void informoUsuário(String usuario) {
        driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys(usuario);
    }
    @Quando("a senha {string}")
    public void aSenha(String senha) {
        driver.findElement(By.xpath("//*[@id='username_password']")).sendKeys(senha);
        driver.findElement(By.xpath("//*[@id='bigbutton']")).click();
    }
    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
       String texto = driver.findElement(By.partialLinkText("SUITECRM DASHBOARD")).getText();
        Assert.assertEquals("SUITECRM DASHBOARD", texto);

    }
    @Quando("seleciono Create")
    public void selecionoCreate() {
        driver.findElement(By.partialLinkText("CREATE")).click();

    }
    @Quando("seleciono Create Task")
    public void selecionoCreateTask() {
        driver.findElement(By.partialLinkText("Create Tasks")).click();

    }
    @Quando("preencho os campos")
    public void preenchoOsCampos() {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='date_start_date']")).sendKeys("06/05/1998");
        driver.findElement(By.xpath("//select[@id='date_start_hours']")).sendKeys("11");
        driver.findElement(By.xpath("//select[@id='date_start_minutes']")).sendKeys("15");

        driver.findElement(By.xpath("//input[@id='date_due_date']")).sendKeys("06/05/2021");
        driver.findElement(By.xpath("//select[@id='status']")).click();
        driver.findElement(By.xpath("//select[@id='status']//option[@label='In Progress']")).click();
        driver.findElement(By.xpath("//input[@id='contact_name']")).sendKeys("Test Contact");

    }
    @Então("vejo que a task foi cadastrada com sucesso.")
    public void vejoQueATaskFoiCadastradaComSucesso() {
        driver.findElement(By.xpath("//*[@id=\"EditView\"]/table/tbody/tr/td[1]/div//*[@id='SAVE']")).click();
        String texto = driver.findElement(By.xpath("//h2[@class='module-title-text']")).getText();
        Assert.assertEquals("TEST",texto);
    }

    @E("clico na opção Actions")
    public void clicoNaOpçãoActions() {
        driver.findElement(By.xpath("//li[@id='tab-actions']")).click();
    }

    @E("clico em Editar")
    public void clicoEmEditar() {
        driver.findElement(By.xpath("//input[@id='edit_button']")).click();
    }

    @Então("o arquivo é alterado com sucesso")
    public void oArquivoÉAlteradoComSucesso() {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(" Editado");
        driver.findElement(By.xpath("//*[@id=\"EditView\"]/table/tbody/tr/td[1]/div//*[@id='SAVE']")).click();
        String texto = driver.findElement(By.xpath("//h2[@class='module-title-text']")).getText();
        Assert.assertEquals("TEST EDITADO",texto);
    }

    @E("clico em Deletar")
    public void clicoEmDeletar() {
        driver.findElement(By.xpath("//input[@id='delete_button']")).click();
        driver.switchTo().alert().accept();
    }

    @Então("o arquivo é deletado com sucesso")
    public void oArquivoÉDeletadoComSucesso() {
        driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[1]/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"delete_listview_top\"]/label[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"actionLinkTop\"]/li/ul//*[@id='delete_listview_top']")).click();
        driver.switchTo().alert().accept();
    }
}
