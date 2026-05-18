package uniandes.dpoo.swing.interfaz.principal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener {
    /**
     * El comando para el botón para crear un nuevo restaurante
     */
    private static final String NUEVO = "Nuevo";

    /**
     * El comando para el botón para ver todos los restaurantes en el mapa
     */
    private static final String VER = "Ver Todos";

    private JButton butNuevo;
    private JButton butVerTodos;
    private VentanaPrincipal ventanaPrincipal;

    //Constantes bonitas
    java.awt.Font fuenteFormulario = new java.awt.Font("My Ugly Handwriting", java.awt.Font.PLAIN, 20);
    Color beige  = new Color(255,253,208); 
    Color azul  = new Color(255,253,208);
    
    public PanelBotones( VentanaPrincipal ventanaPrincipal ){
        this.ventanaPrincipal = ventanaPrincipal;
        setLayout( new FlowLayout( ) );

        butNuevo = new JButton(NUEVO);
        butNuevo.setActionCommand(NUEVO);
        butNuevo.addActionListener(this);
        butNuevo.setBackground(azul );
        butNuevo.setFont(fuenteFormulario);
        
        butVerTodos= new JButton(VER);
        butVerTodos.setActionCommand(VER);
        butVerTodos.addActionListener(this);
        butVerTodos.setBackground(azul);
        butVerTodos.setFont(fuenteFormulario);
        
        add(butNuevo);
        add(butVerTodos);
    }

    @Override
    public void actionPerformed( ActionEvent e ){
        String comando = e.getActionCommand( );
        if( comando.equals( NUEVO ) ){
            ventanaPrincipal.mostrarVetanaNuevoRestaurante( );
        }
        else if( comando.equals( VER ) ){
            ventanaPrincipal.mostrarVentanaMapa( );
        }
    }
}
