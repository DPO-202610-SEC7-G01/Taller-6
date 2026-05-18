package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

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
    
    
    public PanelEditarRestaurante() {
        // Inicializar los atributos de la clase primero
        txtNombre = new JTextField(20);
        cbbCalificacion = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        cbbVisitado = new JComboBox<>(new String[]{"Si", "No"});
        
        // Configurar layout (opcional, para mejor organización)
        setLayout(new java.awt.GridLayout(3, 2, 10, 10));
        
        // Nombre
        JLabel lblNombre = new JLabel("Nombre del Restaurante:");
        lblNombre.setFont(fuenteFormulario);
        txtNombre.setFont(fuenteFormulario);
        
        // Calificacion
        JLabel lblCategoria = new JLabel("Calificacion:");
        lblCategoria.setFont(fuenteFormulario);
        cbbCalificacion.setFont(fuenteFormulario);
        
        // Visita
        JLabel lblVisitad = new JLabel("Visita:");
        lblVisitad.setFont(fuenteFormulario);
        cbbVisitado.setFont(fuenteFormulario);
        
        // Agregar componentes al panel
        add(lblNombre);
        add(txtNombre);
        add(lblCategoria);
        add(cbbCalificacion);
        add(lblVisitad);
        add(cbbVisitado);
        setBackground(azul);
    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( ) {
        String visit = (String)cbbVisitado.getSelectedItem();
        if (visit == "Si") {
        	return true;
        }
        return false;
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( ){
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( ){
        String nombre = (String)txtNombre.getText();
        return nombre;
    }
}
