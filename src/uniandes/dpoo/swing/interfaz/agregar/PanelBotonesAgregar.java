package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotonesAgregar extends JPanel implements ActionListener
{
    /**
     * El comando utilizado para el botón que sirve para crear un nuevo restaurante
     */
    private static final String CREAR = "nuevo";

    /**
     * El comando utilizado para el botón que sirve para cerrar la ventana sin crear un restaurante
     */
    private static final String CERRAR = "ver";

    public JButton butNuevo;
    public JButton butCerrar;
    
  //Constantes gráficas
    java.awt.Font fuenteFormulario = new java.awt.Font("My Ugly Handwriting", java.awt.Font.BOLD, 17);
    Color beige  = new Color(255,253,208); 
    Color azul  = new Color(255,253,208);
    
    /**
     * La ventana principal de la aplicación
     */
    private VentanaAgregarRestaurante ventanaPrincipal;

    public PanelBotonesAgregar(VentanaAgregarRestaurante ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        setLayout(new FlowLayout());

        butNuevo = new JButton("Crear Restaurante");
        butNuevo.setActionCommand(CREAR);
        butNuevo.addActionListener(this);
        butNuevo.setFont(fuenteFormulario);
        
        butCerrar = new JButton("Cerrar");
        butCerrar.setActionCommand(CERRAR);
        butCerrar.addActionListener(this);
        butCerrar.setFont(fuenteFormulario);
        
        add(butNuevo);
        add(butCerrar);
    }

    @Override
    public void actionPerformed( ActionEvent e ){
        String comando = e.getActionCommand( );
        if( comando.equals( CREAR ) ){
            ventanaPrincipal.agregarRestaurante( );
        }
        else if( comando.equals( CERRAR ) )
        {
            ventanaPrincipal.cerrarVentana( );
        }
    }
}
