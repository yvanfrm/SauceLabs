package com.nttdata.steps;

import com.nttdata.screens.SauceHomeScreen;
import net.thucydides.core.annotations.Step;

public class SauceHomeSteps {
    SauceHomeScreen home;


    public void clickItem(){
        home.agregarItem();
    }

    public void clickCarroCompras(){
        home.irCarroCompras();
    }

    public boolean validarProductosEnHome() {
        return home.validarProductosEnHome();
    }

    public void seleccionarProducto(String prod) {
        home.seleccionarItem(prod);
    }

    public void agregarUnidadesCarro(int uni){
        home.agregarUnidadesCarrito(uni);
    }
}
