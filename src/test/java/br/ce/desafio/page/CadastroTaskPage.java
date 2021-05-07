package br.ce.desafio.page;

import br.ce.desafio.core.BasePage;

public class CadastroTaskPage extends BasePage {


    public void setUser(String usuario) {
        dsl.escrever("//*[@id='user_name']", usuario);
    }

    public void setPassword(String senha) {
        dsl.escrever("//*[@id='username_password']", senha);
    }

    public void setClicarLogin() {
        dsl.clicar("//*[@id='bigbutton']");
    }

    public String setTextoPaginaInicial() {
        return dsl.validarTextoPaginaInicial("SUITECRM DASHBOARD");
    }

    public void setClicarEmCreate() {
        dsl.clicarLinkTexto("CREATE");
    }

    public void setClicarEmCreateTask() {
        dsl.clicarLinkTexto("Create Tasks");
    }

    public void setTextoCampoSubject(String texto) {
        dsl.escrever("//input[@id='name']", texto);
    }

    public void setStartDate(String data) {
        dsl.escrever("//input[@id='date_start_date']", data);
    }

    public void setDateHrs(String hrs) {
        dsl.escrever("//select[@id='date_start_hours']", hrs);
    }

    public void setDateMinutes(String minu) {
        dsl.escrever("//select[@id='date_start_minutes']", minu);
    }

    public void setDateDue(String dateDue) {
        dsl.escrever("//input[@id='date_due_date']", dateDue);
    }

    public void setClicarStatus() {
        dsl.clicar("//select[@id='status']");
    }

    public void setClicarInProgress() {
        dsl.clicar("//select[@id='status']//option[@label='In Progress']");
    }

    public void setContactName(String contactName) {
        dsl.escrever("//input[@id='contact_name']", contactName);
    }

    public void setClicarSave() {
        dsl.clicar("//*[@id=\"EditView\"]/table/tbody/tr/td[1]/div//*[@id='SAVE']");
    }

    public String setTextoTask() {
        return dsl.validarTextoTask("//h2[@class='module-title-text']");
    }

    public void setClicarActions() {
        dsl.clicar("//li[@id='tab-actions']");
    }

    public void setClicarEmEditar() {
        dsl.clicar("//input[@id='edit_button']");
    }

    public void setTextoEditado(String texto) {
        dsl.escrever("//input[@id='name']", texto);
    }

    public void setClicarSaveEditado() {
        dsl.clicar("//*[@id=\"EditView\"]/table/tbody/tr/td[1]/div//*[@id='SAVE']");
    }

    public void setClicarDelet() {
        dsl.clicar("//input[@id='delete_button']");
    }

    public void setClicarAlert() {
        dsl.clicarAlert();
    }

    public void setClicarListDelet() {
        dsl.clicar("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[1]/td[1]/input");
    }

    public void setClicarEmDeletar() {
        dsl.clicar("//*[@id=\"delete_listview_top\"]/label[2]");
    }

    public void setClicarLinkAction() {
        dsl.clicar("//*[@id=\"actionLinkTop\"]/li/ul//*[@id='delete_listview_top']");
    }
}
