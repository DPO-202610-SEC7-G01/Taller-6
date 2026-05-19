package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.swing.interfaz.agregar.PanelMapaAgregar;
import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener{
    /**
     * El comando para reconocer al radio que muestra sólo los restaurantes visitados
     */
    private static final String VISITADOS = "VISITADOS";

    /**
     * El comando para reconocer al radio que muestra todos los restaurantes
     */
    private static final String TODOS = "TODOS";

    /**
     * El panel con el mapa
     */
    private PanelMapaVisualizar panelMapa;

    /**
     * El radio button para hacer que se muestren todos los restaurantes. Si este está activo, radioVisitados debe estar inactivo.
     */
    private JRadioButton radioTodos;

    /**
     * El radio button para hacer que se muestren sólo los restaurantes visitados. Si este está activo, radioTodos debe estar inactivo.
     */
    private JRadioButton radioVisitados;

    /**
     * La referencia a la ventana principal
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
    
    public VentanaMapa( VentanaPrincipal ventanaPrincipal, List<Restaurante> restaurantes ){
        this.ventanaPrincipal = ventanaPrincipal;
        setLayout( new BorderLayout( ) );
        
        //Titulo
        JLabel lblTituloVentana = new JLabel("UBICAR RESTAURANTES", JLabel.CENTER);
        lblTituloVentana.setFont(fuenteFormulario); 
        lblTituloVentana.setForeground(beige);
        lblTituloVentana.setBorder(new javax.swing.border.EmptyBorder(15, 0, 10, 0));
        getContentPane().add(lblTituloVentana, BorderLayout.NORTH);
        
        // Mapa
        panelMapa = new PanelMapaVisualizar(); 
        panelMapa.setOpaque(false);
        getContentPane().add(panelMapa, BorderLayout.CENTER);
        
        panelMapa.actualizarMapa(restaurantes);
        
        radioTodos = new JRadioButton("Todos", true);
        radioVisitados = new JRadioButton("Visitados", false);
        
        radioTodos.setActionCommand(TODOS);
        radioVisitados.setActionCommand(VISITADOS);
        
        radioTodos.addActionListener(this);
        radioVisitados.addActionListener(this);

        radioTodos.setFont(fuenteFormulario);
        radioTodos.setForeground(beige);
        radioTodos.setOpaque(false);
        
        radioVisitados.setFont(fuenteFormulario);
        radioVisitados.setForeground(beige);
        radioVisitados.setOpaque(false);
        
        ButtonGroup grupoFiltros = new ButtonGroup();
        grupoFiltros.add(radioTodos);
        grupoFiltros.add(radioVisitados);
        
        // CORREGIDO: crear el panel de filtros que faltaba
        JPanel panelFiltros = new JPanel();
        panelFiltros.setOpaque(false);
        panelFiltros.add(radioTodos);
        panelFiltros.add(radioVisitados);
        getContentPane().add(panelFiltros, BorderLayout.SOUTH);
      
        // Termina de configurar la ventana y la muestra
        setSize( 400, 600 );
        setTitle("Mapa de Restaurantes"); 
        getContentPane().setBackground(new Color(41, 128, 185));
        setResizable(false);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLocationRelativeTo( ventanaPrincipal ); 
        setCursor(cursorEspecial); 
        setVisible( true );
    }
    
    
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String comando = e.getActionCommand( );
        if( TODOS.equals( comando ) ) {
            panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( true ) );
        }
        else if( VISITADOS.equals( comando ) ) {
            panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( false ) );
        }
    }

}
