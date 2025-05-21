package com.sebasth.bank.objects;

public class Register {
    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String repeatedPassword;

    /*Constructores para poder ingresar registros y mandarlos a user*/
    public Register(String firstName, String lastName, String userName, String email, String password, String repeatedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.repeatedPassword = repeatedPassword;

        // Validador de contraseñas comparando la contraseña y la repetida
        if (!password.equals(repeatedPassword)) {
            System.out.println("Las contraseñas no coinciden");
            // Aquí lanzamos una excepción para evitar el registro
            // throw new IllegalArgumentException("Las contraseñas no coinciden");
        } else {
            System.out.println("Registro exitoso");
        }
    }
    //agregampos los getters y setters
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }


    /*agregamos los metodos de manipulacion del registro*/

    public void registerUser(){

    }

    public void validateUserName(){

    }

}
