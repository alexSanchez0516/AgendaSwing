package com.mycompany.hoja6unidad8;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author alexander
 */
public class Persona implements Comparable<Persona>, Serializable{
    
    private String nombre; 
    private String apellidos;
    private String fijo;
    private String movil;
    private String pathImage;
    private int edad;

    public Persona(String nombre, String apellidos, String fijo, String movil, int edad, String pathImage) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fijo = fijo;
        this.movil = movil;
        this.edad = edad;
        this.pathImage = pathImage;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    
    @Override
    public int compareTo(Persona t) {
        return this.edad - t.getEdad();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persona persona) {
            return this.nombre.equalsIgnoreCase(persona.getNombre() ) 
                    &&
                    this.apellidos.equals(persona.getApellidos());
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", fijo=").append(fijo);
        sb.append(", movil=").append(movil);
        sb.append(", pathImage=").append(pathImage);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
}
