package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SauceHomeScreen extends PageObject {

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"ADD TO CART\"])[1]")
    private WebElement btnAgregarItem;

    public By seleccionarItemNombre(String strItem){
        return By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text='" + strItem + "']");
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<WebElement> itemsHome;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    private WebElement btnCarroCompras;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CONTINUE SHOPPING\"]")
    private WebElement btnContinue;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    private WebElement btnTerminarCompra;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sauce Labs Backpack\"]")
    private WebElement txtTituloItem2;

    public void agregarItem(){
        btnAgregarItem.click();
    }

    public void irCarroCompras(){
        btnCarroCompras.click();
    }

    public void clickContinue(){
        btnContinue.click();
    }

    public void seleccionarItem(String nombre){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement producto = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        seleccionarItemNombre(nombre)
                )
        );
        producto.click();
    }

    public boolean validarProductosEnHome() {
        System.out.println("Items encontrados: " + itemsHome.size());
        return itemsHome.size() > 0;
    }

    public void agregarUnidadesCarrito(int unidades){
        WebElement element = getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().description(\"test-ADD TO CART\"))"
                )
        );
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        for (int i = 0; i < unidades; i++) {
            element.click();
        }

    }
}
