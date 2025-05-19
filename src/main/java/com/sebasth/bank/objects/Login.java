package com.sebasth.bank.objects;

public class Login {
    private String userName;
    private String password;
    private String email;

    // Constructor para inicializar un Login con parámetros
    public Login(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    // agregamos los getters y Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*agregamos los metodos para manipular el login*/
    public void loginUser() {
        // agegamos la logica para iniciar sesión
        System.out.println("Iniciando sesión para el usuario: " + userName);
    }
    public void logoutUser() {
        // agegamos la logica para cerrar sesión
        System.out.println("Cerrando sesión para el usuario: " + userName);
    }

    /*sobreescribimos los metodos ****/
    @Override
    public String toString() {
        return "Login{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
