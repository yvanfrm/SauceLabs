package com.nttdata.steps;

import com.nttdata.screens.SauceCarritoScreen;
import net.thucydides.core.annotations.Step;

public class SauceCarritoSteps {

    SauceCarritoScreen carrito;

    @Step("Obtiene el texto del item")
    public String getTituloText(String nombre){
        return carrito.getTituloText(nombre);
    }

    public void checkout(){
        carrito.clickSeguirCompra();
    }

    public void ingresoElUsuario(String nombre,String ape, String cod) {
        carrito.ingresarInformacionCheckout(nombre,ape,cod);
    }

    public void continuarCompra(){
        carrito.continuarCompra();
    }

    @Step("Obtiene el texto del resultado")
    public String getResultText(){
        return carrito.getResultText();
    }

    public void clickFinalizar(){
        carrito.clickFinalizarCompra();
    }

}
