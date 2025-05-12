package com.sebasth.bank.objects;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Role {
    private long rolId;
    private String rolName;
    private Set<String> permisiions;

    //agregamos los constructores (builders)
    public Role(){
        this.permisiions = new HashSet<>();
        /*
        * uso de hashset para evitar duplicados ademas de primera interaccion
        * aprendizaje de su funcionamiento
        * */
    }
    public Role(String roleName){
        this.rolName = roleName;
        this.permisiions = new HashSet<>(); // inicializamos el set vacio para evitar duplicados y permitir gestion de permisos
    }
    public Role(String rolName, Set<String> permissions){
        this.rolName = rolName;
        /*creamos una copia para evitar modificaciones externas o duplicaciones*/
        this.permisiions = new HashSet<>(permissions);
    }
    /*agregamos los getters y setter del objeto*/

    public long getRolId() {
        return rolId;
    }

    public void setRolId(long rolId) {
        this.rolId = rolId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public Set<String> getPermisiions() {
        return permisiions;
    }

    public void setPermisiions(Set<String> permisiions) {
        this.permisiions = permisiions;
    }

    /*agergamos los metodos para gestionar los permisos*/

    public boolean addPermission(String permission){
        /*retornnamos que se agregara este permiso*/
        return this.permisiions.add(permission);
    }

    public boolean removePermission(String permission){
        /*retornamos que se eliminara este permiso*/
        return this.permisiions.remove(permission);
    }

    public boolean hasPermission(String permission){
        /*retornamos si el permiso existe*/
        return this.permisiions.contains(permission);
    }

    /*sobre escribimos los metodos equals, hashCode() y el toString, ya que los nombres de rol
    * suelen ser unicos*/

    @Override
    public int hashCode() {
        return Objects.hash(rolName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(rolName, role.rolName);
    }

    @Override
    public String toString() {
        return  "Role{" +
                "roleId=" + rolId +
                ", roleName='" + rolName + '\'' +
                ", permissions=" + permisiions + '}';
    }
}
