package com.mycompany.hoja6unidad8;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alexander
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private Fichero fichero;
    private HashSet<Persona> personas;
    private modalNewUser modal;
    private Details modalDetails;

    public Main() {

        this.cargar();
        initComponents();
        buildTable();
        setLocationRelativeTo(null);
    }

    private void cargar() {

        this.fichero = new Fichero("contactos.dat");
        this.personas = fichero.getDataFichero();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSearch = new javax.swing.JMenuItem();
        jMenuItem6Details = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGENDA DE CONTACTOS");
        setResizable(false);

        jScrollPane1.setViewportView(jTable1);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoUC.jpg"))); // NOI18N

        jMenu1.setText("Contactos");

        jMenuItemNew.setText("Nuevo");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNew);

        jMenuItemDelete.setText("Eliminar");
        jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemDelete);

        jMenuItemSave.setText("Guardar");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSave);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consulta");

        jMenuItemSearch.setText("Buscar");
        jMenuItemSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSearchActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSearch);

        jMenuItem6Details.setText("Detalles");
        jMenuItem6Details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6DetailsActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6Details);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(jLabelLogo)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewActionPerformed
        this.modal = new modalNewUser(this, true);
        this.modal.setVisible(true);
        this.modal.setModal(true);
        this.modal.setLocationRelativeTo(this);
        int edad = -1;
        boolean realizarAgregado = true;

        String nombre = this.modal.getjTextFieldNombre().getText();
        String apellidos = this.modal.getjTextFieldApellidos().getText();
        String fijo = this.modal.getjTextFieldFijo().getText();
        String movil = this.modal.getjTextFieldMovil().getText();

        //validacion
        try {
            edad = Integer.parseInt(this.modal.getjTextFieldEdad().getText());

        } catch (NumberFormatException e) {
            realizarAgregado = false;
            JOptionPane.showMessageDialog(this, "Error de conversion", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        if (!nombre.matches("[A-ZÑa-zñ ]*") || !apellidos.matches("[A-ZÑa-zñ ]*")) {
            JOptionPane.showMessageDialog(this, "Datos Inválidos", "ERROR", JOptionPane.ERROR_MESSAGE);
            realizarAgregado = false;

        }

        String pathImg = this.modal.getjFileChooser().getSelectedFile().getName();

        if (this.modal.IsAccept() && realizarAgregado) {
            this.fichero.addPersona(new Persona(nombre, apellidos, fijo, movil, edad, pathImg));

            //copiamos la foto a resoruces
            this.cpImgContactos(this.modal.getjFileChooser().getSelectedFile());
            JOptionPane.showMessageDialog(this, "Contacto creado correctamente", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            cargar();
            buildTable();
        }


    }//GEN-LAST:event_jMenuItemNewActionPerformed

    private void cpImgContactos(File photo) {
        System.out.println(photo.getName());
        String dest = System.getProperty("user.dir") + "/src/main/resources/img/" + photo.getName();
        Path destino = Paths.get(dest);

        //origen
        String ori = photo.getPath();
        Path origen = Paths.get(ori);

        try {
            //copiamos
            Files.copy(origen, destino, REPLACE_EXISTING);
            System.out.println("copiado con exito");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void jMenuItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeleteActionPerformed

        Object[] personasArray = this.personas.toArray();
        Persona[] personasSend = new Persona[jTable1.getSelectedRows().length];

        int[] rows = jTable1.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int rowCount = model.getRowCount();

        if (rowCount > 0) {
            for (int i = 0; i < rows.length; i++) { //en caso de fallar cambiar a rowCount
                try {
                    model.removeRow(jTable1.getSelectedRow());
                    personasSend[i] = (Persona) personasArray[rows[i]];
                } catch (Exception e) { //Cuando quiere lanza una excepcion de indexBoundException
                    System.out.println("Error: " + e.toString());
                }
            }
        }

        this.fichero.eliminarPersona(personasSend);
        cargar();
        //buildTable();


    }//GEN-LAST:event_jMenuItemDeleteActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        Fichero file = new Fichero("personas.dat");

        int rowCount = model.getRowCount();
        String nombre, apellidos, fijo, movil, pathImg = "";
        int edad;
        Persona personaWrite;

        if (rowCount > 0) {
            for (int i = 0; i < rowCount; i++) {
                nombre = (String) model.getValueAt(i, Utilidades.NOMBRE);
                apellidos = (String) model.getValueAt(i, Utilidades.APELLIDOS);
                fijo = (String) model.getValueAt(i, Utilidades.FIJO);
                movil = (String) model.getValueAt(i, Utilidades.MOVIL);
                edad = Integer.parseInt(model.getValueAt(i, Utilidades.EDAD).toString());
                System.out.println("edad = " + edad);

                for (Persona persona : this.personas) {
                    if (persona.getNombre()
                            .equalsIgnoreCase(nombre)
                            && persona.getMovil().equals(movil)) {
                        pathImg = persona.getPathImage();
                    }
                }
                personaWrite = new Persona(nombre, apellidos, fijo, movil, edad, pathImg);

                file.addPersona(personaWrite);
            }
        } else {
            System.out.println("No hay nada que guardar");
        }

        this.fichero.deleteFile();
        file.rename("contactos.dat");


    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSearchActionPerformed
        // TODO add your handling code here:

        String name = JOptionPane.showInputDialog(this, "Buscar Contacto", "Search", JOptionPane.QUESTION_MESSAGE);
        int index = this.getIndexContact(name);

        if (index >= 0) {
            this.jTable1.setRowSelectionInterval(index, index);

        } else {
            JOptionPane.showMessageDialog(this, "No encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jMenuItemSearchActionPerformed

    private void jMenuItem6DetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6DetailsActionPerformed

        String name = JOptionPane.showInputDialog(this, "Buscar Contacto", "Search", JOptionPane.QUESTION_MESSAGE);
        Persona persona = this.getPersona(name);
        URL imgUrl;

        if (name.matches("[A-ZÑa-zñ ]*")) {
            if (persona != null) {

                System.out.println(persona.toString());
                this.modalDetails = new Details(this, true);

                this.modalDetails.getjLabel2Name().setText(persona.getNombre());
                this.modalDetails.getjLabel3Apellidos().setText(persona.getApellidos());
                this.modalDetails.getjLabel4Movil().setText(persona.getMovil());
                this.modalDetails.getjLabel5Edad().setText(String.valueOf(persona.getEdad()));

                if (persona.getPathImage().length() > 0) {
                    imgUrl = getClass().getClassLoader().getResource("img/" + persona.getPathImage());
                    ImageIcon img = new ImageIcon(imgUrl);
                    this.modalDetails.getjLabelPhoto().setIcon(img);
                    this.modalDetails.getjLabelPhoto().setPreferredSize(new Dimension(400, 400));
                }

                this.modalDetails.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "No encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Nombre invalido", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_jMenuItem6DetailsActionPerformed

    private Persona getPersona(String name) {
        Persona personaC = null;

        for (Persona persona : this.personas) {
            if (persona.getNombre().equalsIgnoreCase(name)) {
                personaC = persona;
                break;
            }
        }

        return personaC;
    }

    private int getIndexContact(String name) {

        int index = -1;
        Persona[] personasArray = this.personas.toArray(Persona[]::new);
        boolean isLocated = false;

        for (int i = 0; i < personasArray.length && !isLocated; i++) {

            if (personasArray[i].getNombre().equalsIgnoreCase(name)) {
                index = i;
                isLocated = true;

            }

        }

        return index;

    }

    private void buildTable() {

        Object data[][];
        Object[] personasArray = this.personas.toArray();
        // **********TITULOS***********
        ArrayList<String> titulos = new ArrayList<>();

        titulos.add("Nombre");
        titulos.add("Apellidos");
        titulos.add("Fijo");
        titulos.add("Movil");
        titulos.add("Edad");

        // **** ASIGNANDO COLUMNAS AL ARREGLO DE COLUMNAS DE JTABLE  ****
        String[] titulosC = new String[titulos.size()];
        for (int i = 0; i < titulosC.length; i++) {
            titulosC[i] = titulos.get(i);
        }

        //****  RELLENAMOS CON LOS DATOS  ****
        data = new Object[this.personas.size()][titulos.size()];

        for (int i = 0; i < data.length; i++) {

            data[i][Utilidades.NOMBRE] = ((Persona) personasArray[i]).getNombre();
            data[i][Utilidades.APELLIDOS] = ((Persona) personasArray[i]).getApellidos();
            data[i][Utilidades.FIJO] = ((Persona) personasArray[i]).getFijo();
            data[i][Utilidades.MOVIL] = ((Persona) personasArray[i]).getMovil();
            data[i][Utilidades.EDAD] = ((Persona) personasArray[i]).getEdad();
        }
        //jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jTable1.setModel(new DefaultTableModel(data, titulosC));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6Details;
    private javax.swing.JMenuItem jMenuItemDelete;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}