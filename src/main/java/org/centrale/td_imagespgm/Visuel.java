/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.td_imagespgm;

/**
 *
 * @author Utilisateur
 */
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.centrale.td_imagespgm.Image;

public class Visuel extends JFrame {

    public Visuel() {
        this.setTitle("Affichage des images");
    }
    
    private BufferedImage matrixToBI(int[][] image) {
        int largeur = image[0].length;
        int hauteur = image.length;

        BufferedImage bufferedImage = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = bufferedImage.getRaster();

        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                int pixelValue = image[i][j];
                raster.setSample(j, i, 0, pixelValue); 
            }
        }
        return bufferedImage;
    }
    
    public void showImg(int[][] img){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage image = matrixToBI(img);
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        add(label);
        pack(); 
        setVisible(true);
    }
    
    public void showPGM(String nom){
        Image img=new Image(nom);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        img.Lecture();
        BufferedImage image = matrixToBI(img.image);
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        add(label);
        pack(); 
        setVisible(true);
    }
}
