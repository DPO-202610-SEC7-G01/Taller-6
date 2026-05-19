package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel {
    private List<Restaurante> restaurantes;
    private Image imagenMapa; // Guardamos directamente la imagen, no un JLabel


    java.awt.Font fuenteFormulario = new java.awt.Font("My Ugly Handwriting", java.awt.Font.BOLD, 17);
    Color azul = new Color(41, 128, 185);
    public static final int MAP_WIDTH = 400;
    public static final int MAP_HEIGHT = 400;

    public PanelMapaVisualizar() {
        setLayout(new BorderLayout());
        this.imagenMapa = new ImageIcon("./imagenes/mapa.png").getImage();
        
        setBorder(new LineBorder(Color.DARK_GRAY));
        setPreferredSize(new Dimension(MAP_WIDTH, MAP_HEIGHT));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (imagenMapa != null) {
            Graphics2D g2d = (Graphics2D) g;

            int anchoOriginal = imagenMapa.getWidth(this);
            int altoOriginal = imagenMapa.getHeight(this);

            int anchoActual = getWidth();
            int altoActual = getHeight();

            g2d.drawImage(imagenMapa, 0, 0, anchoActual, altoActual, this);

            if (restaurantes != null && !restaurantes.isEmpty()) {
                if (anchoOriginal > 0 && altoOriginal > 0 && anchoActual > 0 && altoActual > 0) {
                    
                    for (Restaurante r : restaurantes) {
                        int radio = 6;
                        int diametro = radio * 2;

               
                        g2d.setColor(azul);
                        g2d.fillOval(r.getX() - radio, r.getY() - radio, diametro, diametro);

                        g2d.setColor(Color.BLACK);
                        g2d.drawOval(r.getX() - radio, r.getY() - radio, diametro, diametro);

                        g2d.setFont(fuenteFormulario);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString(r.getNombre(), r.getX() + 10, r.getY() + 5);
                    }
                }
            }
        }
    }

    public void actualizarMapa(List<Restaurante> nuevosRestaurantes) {
        if (nuevosRestaurantes != null) {
            this.restaurantes = new java.util.ArrayList<>(nuevosRestaurantes);
        } else {
            this.restaurantes = null;
        }
        repaint();
    }
}