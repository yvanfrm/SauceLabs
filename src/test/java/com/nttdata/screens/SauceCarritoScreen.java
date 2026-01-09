package com.nttdata.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceCarritoScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    private WebElement btnCheckout;

    public By txtTituloItem(String strItem){
        return By.xpath("//android.widget.TextView[@text='" + strItem + "']");
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    private WebElement txtNombre;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    private WebElement txtApellido;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    private WebElement txtCodigoPostal;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    private WebElement btnContinuarCompra;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]")
    private WebElement txtResultado;

    public String getTituloText(String nombre){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement elemento = wait.until(
                ExpectedConditions.visibilityOfElementLocated(txtTituloItem(nombre))
        );
        return elemento.getText();
    }

    public void clickSeguirCompra(){
        btnCheckout.click();
    }

    public void ingresarInformacionCheckout(String nombre,String ape, String cod){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(txtNombre));
        waitFor(ExpectedConditions.elementToBeClickable(txtNombre));
        txtNombre.sendKeys(nombre);
        txtApellido.sendKeys(ape);
        txtCodigoPostal.sendKeys(cod);
    }

    public void continuarCompra(){
        btnContinuarCompra.click();
    }

    public String getResultText(){
        return txtResultado.getText();
    }

    public void clickFinalizarCompra(){
        WebElement element = getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().description(\"test-FINISH\"))"
                )
        );
        waitFor(element).click();
    }

}
