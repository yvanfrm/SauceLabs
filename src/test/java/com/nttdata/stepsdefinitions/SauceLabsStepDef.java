package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SauceCarritoSteps;
import com.nttdata.steps.SauceHomeSteps;
import com.nttdata.steps.SuaceLabsLoginSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class SauceLabsStepDef {
    @Steps
    SuaceLabsLoginSteps login;
    @Steps
    SauceHomeSteps home;
    @Steps
    SauceCarritoSteps carrito;

    @When("ingreso el usuario {string}")
    public void ingresoElUsuario(String usuario) {
        login.ingresoElUsuario(usuario);
    }

    @Given("ingreso al aplicativo de SauceLabs")
    public void ingresoAlAplicativoDeSauceLabs() {
    }

    @When("inicio sesión con mi usuario {string} y clave {string}")
    public void inicioSesiónConMiUsuarioYClave(String arg0, String arg1) {
        login.ingresoElUsuario(arg0);
        login.ingresarClave(arg1);
        login.ingresar();

    }

    @And("ingreso la clave {string}")
    public void ingresoLaClave(String arg0) {
        login.ingresarClave(arg0);
    }

    @And("hago clic en LOGIN")
    public void hagoClicEn() {
        login.ingresar();
    }

    @And("valido el login OK")
    public void validoElLoginOK() {
        login.validacionLogin();
    }

    @And("agrego item")
    public void agregoItem() {
        home.clickItem();
    }

    @And("hago click en Carro de compras")
    public void hagoClickEnCarroDeCompras() {
        home.clickCarroCompras();
    }

    @And("hago click en checkout")
    public void hagoClickEnCheckout() {
        carrito.checkout();
    }

    @And("ingreso informacion checkout: {string}, {string}, {string}")
    public void ingresoInformacionCheckout(String nom, String ape, String cod) {
        carrito.ingresoElUsuario(nom,ape,cod);
    }

    @And("hago click en continuar")
    public void hagoClickEnContinuar() {
        carrito.continuarCompra();
    }

    @And("hago click en finalizar")
    public void hagoClickEnFinalizar() {
        carrito.clickFinalizar();
    }

    @Then("se muestra el texto {string}")
    public void seMuestraElTexto(String text) {
        Assert.assertEquals(carrito.getResultText(), text);
    }

    @Then("valido item en carro de compra {string}")
    public void validoItemEnCarroDeCompra(String text) {
        Assert.assertEquals(carrito.getTituloText(text), text);
    }

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {

    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        assertTrue(
                "La galeria no cargo correctamente los productos",
                home.validarProductosEnHome()
        );
    }

    @When("agrego {string} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(String uni,String prod) {
        home.seleccionarProducto(prod);
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(int uni, String prod) {
        home.seleccionarProducto(prod);
        home.agregarUnidadesCarro(uni);
        home.clickCarroCompras();
    }

    @Then("valido el carrito de compra actualice correctamente {string}")
    public void validoElCarritoDeCompraActualiceCorrectamente(String text) {
        Assert.assertEquals(carrito.getTituloText(text), text);
        System.out.println("Items en carrito: " + carrito.getTituloText(text));
    }
}
