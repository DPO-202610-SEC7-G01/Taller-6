package uniandes.dpoo.swing.interfaz.principal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.agregar.PanelEditarRestaurante;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    /**
     * La etiqueta donde se muestra el nombre de un restaurante
     */
    private JLabel labNombre;

    /**
     * La etiqueta donde se muestra la calificación de un restaurante, usando imágenes de estrellas
     */
    private JLabel labCalificacion;

    /**
     * Un checkbox en el que se muestra si un restaurante fue visitado o no
     */
    private JCheckBox chkVisitado;
    
    //Constantes gráficas
    java.awt.Font fuenteFormulario = new java.awt.Font("My Ugly Handwriting", java.awt.Font.BOLD, 17);
    Color beige  = new Color(255,253,208); 
    Color azul  = new Color(255,253,208);
    java.awt.Image imagenCursor = new javax.swing.ImageIcon("imagenes/Coursor.png").getImage();
    java.awt.Point puntoClic = new java.awt.Point(30, 30); 
    java.awt.Cursor cursorEspecial = java.awt.Toolkit.getDefaultToolkit().createCustomCursor(
        imagenCursor, 
        puntoClic, 
        "CursorMapa"
    );
    
    
    public PanelDetallesRestaurante() {
        labNombre = new JLabel("Nombre: ");
        labNombre.setFont(fuenteFormulario);
        labNombre.setForeground(beige);
        
        labCalificacion = new JLabel();
        labCalificacion.setFont(fuenteFormulario);
        
        chkVisitado = new JCheckBox("Visitado");
        chkVisitado.setFont(fuenteFormulario);
        chkVisitado.setForeground(beige);
        chkVisitado.setOpaque(false);
        chkVisitado.setEnabled(false);
        
        setLayout(new GridLayout(3, 1, 10, 10));
        setOpaque(false);
        setBorder(new javax.swing.border.EmptyBorder(10, 20, 10, 20));
        setBackground(azul);
        
        add(labNombre);
        add(labCalificacion);
        add(chkVisitado);
    }

    /**
     * Actualiza los datos mostrados del restaurante, indicando los valores por separado.
     * @param nombre
     * @param calificacion
     * @param visitado
     */
    private void actualizarRestaurante(String nombre, int calificacion, boolean visitado) {
        labNombre.setText("Nombre: " + nombre);
        labCalificacion.setIcon(buscarIconoCalificacion(calificacion));
        chkVisitado.setSelected(visitado);
    }

    /**
     * Actualiza los datos que se muestran de un restaurante
     * @param r El restaurante que se debe mostrar
     */
    public void actualizarRestaurante(Restaurante r) {
        if (r != null) {
            this.actualizarRestaurante(r.getNombre(), r.getCalificacion(), r.isVisitado());
        } else {
            labNombre.setText("Nombre: ");
            labCalificacion.setIcon(null);
            chkVisitado.setSelected(false);
        }
    }

    /**
     * Dada una calificación, retorna una imagen para utilizar en la etiqueta que muestra la calificación
     * @param calificacion La calificación del restaurante, que debe ser un numero entre 1 y 5.
     * @return Una imagen a la que corresponde la calificación
     */
    private ImageIcon buscarIconoCalificacion( int calificacion ){
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon( imagen );
    }
}
