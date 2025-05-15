# Bank_javafx - Aplicación JavaFX de Gestión Bancaria

Este proyecto es una aplicación de escritorio desarrollada con JavaFX para la gestión bancaria. Permite la creación de un entorno visual interactivo para diversas funcionalidades relacionadas con cuentas, tarjetas de crédito, usuarios, etc.

## Estructura del Proyecto

bank/

├── .idea/                     # Configuración de IntelliJ IDEA 

├── .mvn/                       # Archivos de Maven Wrapper

│   └── ...

├── src/

│   ├── main/

│   │   ├── java/

│   │   │   └── com/sebasth/bank/

│   │   │   └── com/sebasth/bank/controllers

│   │   │       ├── BankController.java

│   │   │       ├── AddCreditCardController.java

│   │   │       ├── UserController.java

│   │   │       ├── WalleController.java

│   │   │       └── CreditCardController.java

│   │   │   └── com/sebasth/bank/objects

│   │   │       ├── Authentication.java

│   │   │       ├── Loan.java

│   │   │       ├── Role.java

│   │   │       ├── Wallet.java    

│   │   │       ├── CreditCard.java    

│   │   │       └── User.java
                    
│   │   │       └── SistemBank.java           

│   │   │       └── module-info.java          
                    
│   │   └── resources/

│   │       └── com/sebasth/bank/

│   │       └── com/sebasth/bank/styles

│   │   │       └── MainStyles.css

│   │           └── credit-card-view.fxml 

│   │           └── user-view.fxml 

│   │           └── wallet-view.fxml

│   │           └── add-credit-cardts.fxml

│   │           └── main-view.fxml 
                    
│   └── ...

├── target/                     
    
├── .gitignore                   
    
├── mvnw                                   
    
├── mvnw.cmd                  
    
└── pom.xml                   
    

## Tecnologías Utilizadas

* **JavaFX 21:** Framework para la creación de interfaces de usuario ricas para aplicaciones de escritorio.
* **Maven:** Herramienta de gestión de proyectos y dependencias.
* **ControlsFX:** Librería que proporciona controles de interfaz de usuario adicionales para JavaFX.
* **FormsFX:** Librería para crear formularios de manera eficiente en JavaFX.
* **ValidatorFX:** Framework para la validación de campos de entrada en JavaFX.
* **Ikonli:** Librería para usar fuentes de iconos en aplicaciones JavaFX.
* **BootstrapFX:** Librería para aplicar estilos basados en Bootstrap a aplicaciones JavaFX.
* **FXGL:** Motor de juegos 2D y 3D acelerado por GPU para JavaFX (puede que no se esté utilizando directamente para la interfaz bancaria, pero está incluido como dependencia).
* **JUnit Jupiter:** Framework para escribir y ejecutar pruebas unitarias.

## Cómo Empezar

1.  **Clonar el repositorio (si aplica).**
2.  **Asegurarse de tener instalado un JDK (Java Development Kit) compatible con Java 21.**
3.  **Navegar al directorio raíz del proyecto (`step2`).**
4.  **Ejecutar la aplicación utilizando Maven:**

    ```bash
    ./mvnw clean javafx:run
    ```

    o en Windows:

    ```bash
    mvnw.cmd clean javafx:run
    ```

## Desarrollo y Modificación

Para extender y personalizar la aplicación, puedes modificar los siguientes archivos:

### 1. Crear Vistas Internas Dinámicas

* **Archivos `.fxml` (en `src/main/resources/com/sebasth/step2/`):**
    * Crea nuevos archivos `.fxml` para definir la estructura visual de cada vista interna (e.g., `account-details.fxml`, `transfer-funds.fxml`).
    * Modifica el archivo de la vista principal (`hello-view.fxml` o crea uno nuevo) para incluir un contenedor (como `BorderPane`, `StackPane`) donde se cargarán dinámicamente estas vistas. Añade elementos de navegación (botones, menú) para cambiar entre vistas.

* **Archivos `.java` (controladores en `src/main/java/com/sebasth/step2/`):**
    * Crea controladores Java (`.java`) correspondientes a cada nuevo archivo `.fxml`. Estos controladores manejarán la lógica y la interacción del usuario para sus respectivas vistas (e.g., `AccountDetailsController.java`, `TransferFundsController.java`).
    * Modifica `SistemBank.java` o el controlador de la vista principal para implementar la lógica de carga y reemplazo de las vistas dentro del contenedor principal utilizando `FXMLLoader`.

### 2. Dar Estilo con CSS

* **Archivos `.css` (en `src/main/resources/com/sebasth/step2/` o una subcarpeta como `css/`):**
    * Crea uno o varios archivos `.css` (e.g., `styles.css`, `theme.css`) para definir los estilos visuales de tu aplicación.

* **Enlazar hojas de estilo en `SistemBank.java`:**
    * En el método `start()`, después de cargar el `.fxml` y crear la `Scene`, añade las hojas de estilo a la escena utilizando `scene.getStylesheets().add(getClass().getResource("ruta/al/archivo.css").toExternalForm());`.

* **Aplicar estilos en archivos `.fxml`:**
    * Utiliza el atributo `styleClass` en los elementos de la interfaz de usuario dentro de tus archivos `.fxml` para aplicar los estilos definidos en tus archivos `.css`.

### 3. Crear Funcionalidades con Java

* **Controladores (`.java` en `src/main/java/com/sebasth/bank/`):**
    * Implementa la lógica de la aplicación en los métodos de tus controladores. Utiliza anotaciones `@FXML` para enlazar elementos de la interfaz con variables y métodos Java.
    * Maneja eventos de usuario (clics de botones, entrada de texto) y actualiza la interfaz de usuario en respuesta.
    * взаимодействуй con las clases de modelo (como `CrediCart`, `Wallet`, `User`) para realizar operaciones y gestionar datos.

* **Clases de Modelo (`.java` en `src/main/java/com/sebasth/bank/model/` - crea este paquete):**
    * Crea clases Java para representar las entidades de tu dominio (e.g., `CrediCart`, `Wallet`, `User`). Define sus atributos y comportamientos (métodos).

### 4. Crear Objetos para su Uso

* **Clases de Modelo (`.java` en `src/main/java/com/sebasth/bank/model/`):**
    * Define clases Java con atributos que representen las propiedades de tus objetos (e.g., para `CrediCart`: número, límite, saldo; para `Wallet`: saldo; para `User`: nombre, lista de tarjetas, billetera).
    * Implementa métodos dentro de estas clases para encapsular la lógica relacionada con estos objetos (e.g., un método para realizar una transacción en `CrediCart`, un método para depositar o retirar fondos en `Wallet`).
    * Instancia y utiliza estos objetos en tus controladores para gestionar los datos de la aplicación.

## Próximos Pasos

* Diseñar la interfaz de usuario para las diferentes vistas de la aplicación.
* Implementar la lógica para la navegación entre las vistas.
* Crear las clases de modelo para representar los datos bancarios.
* Desarrollar las funcionalidades principales de la aplicación en los controladores.
* Aplicar estilos CSS para mejorar la apariencia visual.
* Escribir pruebas unitarias para asegurar la correcta funcionalidad de la aplicación.
