package com.mycompany.hoja6unidad8;

import ejercicio1.MiObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexander
 */
public class Fichero {

    private File file;

    /**
     *
     * @param path
     */
    public Fichero(String path) {
        this.file = new File(path);

        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return
     */
    public HashSet<Persona> getDataFichero() {
        HashSet<Persona> personas = new HashSet<>();
        ObjectInputStream in = null;
        Persona persona;
        boolean seguir = false;

        try {
            in = new ObjectInputStream(new FileInputStream(this.file));
            while (!seguir) {
                persona = (Persona) in.readObject();
                if (!personas.contains(persona)) {
                    personas.add(persona);

                }
            }

        } catch (EOFException e) {
            seguir = true;
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarFlujo(null, in);
        }

        return personas;

    }

    private void cerrarFlujo(ObjectOutputStream out, ObjectInputStream in) {

        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.toString());
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.toString());

            }
        }

    }

    /**
     *
     * @param persona
     * @return
     */
    public boolean addPersona(Persona persona) {

        ObjectOutputStream out = null;
        boolean isSave = false;

        try {
            if (this.file.length() > 0) {
                out = new MiObjectOutputStream(new FileOutputStream(this.file, true));

            } else {
                out = new ObjectOutputStream(new FileOutputStream(this.file));

            }
            out.writeObject(persona);
            isSave = true;
            System.out.println("Pais guardado");
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            cerrarFlujo(out, null);
        }
        return isSave;

    }

    /**
     *
     * @param personas
     */
    public void eliminarPersona(Persona[] personas) {

        boolean end = false;
        File nuevo = new File("nuevo.dat");
        boolean EscribirPersona;
        try {
            nuevo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        Persona personaRead; //leida

        try {
            in = new ObjectInputStream(new FileInputStream(this.file));

            if (nuevo.length() > 0) {
                out = new MiObjectOutputStream(new FileOutputStream(nuevo, true));
            } else {
                out = new ObjectOutputStream(new FileOutputStream(nuevo));
            }

            while (!end) {
                EscribirPersona = true;
                personaRead = (Persona) in.readObject();

                for (Persona persona : personas) {

                    if (personaRead.equals(persona)) {
                        EscribirPersona = false;
                    }

                }

                if (EscribirPersona) {
                    System.out.println("Agregando --> " + personaRead.toString());
                    out.writeObject(personaRead);
                } else {
                    System.out.println("Eliminar --> " + personaRead.toString());
                }

            }

        } catch (EOFException e) {
            end = true;
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            cerrarFlujo(out, in);
            this.file.delete();

            nuevo.renameTo(new File("contactos.dat"));
        }

    }
    
    public boolean deleteFile() {
        return this.file.delete();
    }
    
    public boolean rename(String name) {
       return this.file.renameTo(new File(name));
    }

}
