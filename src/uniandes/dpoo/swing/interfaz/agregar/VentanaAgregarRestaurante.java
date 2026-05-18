package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;
    
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

    public VentanaAgregarRestaurante( VentanaPrincipal principal ){    
        setLayout( new BorderLayout( ) );

        //titulo
        JLabel lblTituloVentana = new JLabel("INGRESAR NUEVO RESTAURANTE", JLabel.CENTER);
        lblTituloVentana.setFont(fuenteFormulario); 
        lblTituloVentana.setForeground(beige);
        lblTituloVentana.setBorder(new javax.swing.border.EmptyBorder(15, 0, 10, 0));
        getContentPane().add(lblTituloVentana, BorderLayout.NORTH);
        
        // mapa
        PanelMapaAgregar panelMapa = new PanelMapaAgregar();
        panelMapa.setOpaque(false);
        getContentPane().add(panelMapa, BorderLayout.CENTER);
        
        // formulario + botones
        panelDetalles = new PanelEditarRestaurante();
        add(panelDetalles,BorderLayout.SOUTH);
        botonesInferiores(this, panelDetalles);
        
        //Configuración final de la ventana
        setSize(400, 600);
        setTitle("Nuevo Restaurante");
        getContentPane().setBackground(new Color(41, 128, 185));
        setResizable(false);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLocationRelativeTo( principal ); 
        setVisible( true );
    }

  
    
    public void botonesInferiores(VentanaAgregarRestaurante ventanaAgregar, JPanel panelContenedor) {
        PanelBotonesAgregar panelBotones = new PanelBotonesAgregar(ventanaAgregar);
        panelBotones.setOpaque(false);
        panelContenedor.add(panelBotones, java.awt.BorderLayout.SOUTH);
    }
    
    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( ) {
        // TODO completar
    	dispose( );
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( ){
        dispose( );
    }

}
