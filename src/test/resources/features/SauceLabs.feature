
@LoginTest
 Feature: Sauce Labs App

   @Login1
   Scenario: Login Ok
     Given ingreso al aplicativo de SauceLabs
     When inicio sesión con mi usuario "standard_user" y clave "secret_sauce"

   @Login2
   Scenario: Login 2 Ok
     Given ingreso al aplicativo de SauceLabs
     When ingreso el usuario "standard_user"
     And ingreso la clave "secret_sauce"
     And hago clic en LOGIN
     Then valido el login OK

   @ValidarCarrito
   Scenario Outline: Agregar items a carro de compras
     Given ingreso al aplicativo de SauceLabs
     When ingreso el usuario "standard_user"
     And ingreso la clave "secret_sauce"
     And hago clic en LOGIN
     And valido que carguen correctamente los productos en la galeria
     When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
     Then valido el carrito de compra actualice correctamente "<PRODUCTO>"
     Examples:
       | PRODUCTO                  | UNIDADES |
       | Sauce Labs Backpack       | 1        |
       | Sauce Labs Bolt T-Shirt   | 1        |
       | Sauce Labs Bike Light     | 2        |


   @AgregarCarrito
   Scenario Outline: Agregar item a carro de compras
     Given ingreso al aplicativo de SauceLabs
     When ingreso el usuario "standard_user"
     And ingreso la clave "secret_sauce"
     And hago clic en LOGIN
     And agrego item
     And hago click en Carro de compras
     And hago click en checkout
     And ingreso informacion checkout: "<nombre>", "<apellido>", "<codigo>"
     And hago click en continuar
     And hago click en finalizar
     Then se muestra el texto "THANK YOU FOR YOU ORDER"
     Examples:
       | nombre | apellido  | codigo |
       | juan   | fernandez | 15423  |

   @ValidarItem
   Scenario: Validar item de carro de compras
     Given ingreso al aplicativo de SauceLabs
     When ingreso el usuario "standard_user"
     And ingreso la clave "secret_sauce"
     And hago clic en LOGIN
     And agrego item
     And hago click en Carro de compras
     Then valido item en carro de compra "Sauce Labs Backpack"