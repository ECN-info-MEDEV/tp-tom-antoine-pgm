/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.td_imagespgm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static java.lang.Math.*;

/**
 *
 * @author Utilisateur
 */
public class Image {

    String nom;
    int largeur;
    int hauteur;
    int[][] image;

    public Image(String nom) {
        this.nom = nom;

    }

    public void Lecture() {
        try {
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(nom));
            fichier.readLine();
            fichier.readLine();
            String dimension = fichier.readLine();
            String delimiteurs = " ";
            StringTokenizer tokenizer = new StringTokenizer(dimension, delimiteurs);
            largeur = Integer.parseInt(tokenizer.nextToken());
            hauteur = Integer.parseInt(tokenizer.nextToken());
            fichier.readLine();
            image = new int[hauteur][largeur];
            int i=0;
            int j=0;
            while(i<hauteur) {
                j=0;
                while(j<largeur) {
                    ligne=fichier.readLine();
                    if (ligne != null) {
                        StringTokenizer tokenizer2 = new StringTokenizer(ligne, delimiteurs);
                        while (tokenizer2.hasMoreTokens() && j<largeur) {
                            image[i][j] = Integer.parseInt(tokenizer2.nextToken());
                            j++;
                        }

                    }
                }
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Ecriture(String nom) {
        String ligne = "";
        try {
            BufferedWriter ecrit = new BufferedWriter(new FileWriter(nom));
            ecrit.write("P2");
            ecrit.newLine();
            ecrit.write("#");
            ecrit.newLine();
            ecrit.write(largeur + " " + hauteur);
            ecrit.newLine();
            ecrit.write("255");
            ecrit.newLine();
            for (int i = 0; i <= hauteur - 1; i++) {
                for (int j = 0; j <= largeur - 1; j++) {
                    ligne += image[i][j] + " ";
                }
                ecrit.write(ligne);
                ecrit.newLine();
                ligne = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean equal(Image image2) {
    // Compare dimensions
    if (this.largeur != image2.largeur || this.hauteur != image2.hauteur) {
        return false;
    }

    // Compare pixel values
    for (int i = 0; i < hauteur; i++) {
        for (int j = 0; j < largeur; j++) {
            if (this.image[i][j] != image2.image[j][i]) {
                return false;
            }
        }
    }

    // If dimensions and pixel values are the same, images are equal
    return true;
}
    public boolean equal0() {
    // Compare pixel values
    for (int i = 0; i < hauteur; i++) {
        for (int j = 0; j < largeur; j++) {
            if (this.image[i][j] != 0) {
                return false;
            }
        }
    }

    // If dimensions and pixel values are the same, images are equal
    return true;
}
    public void Seuillage() {

    }
  public void reduire(){
      int j=0;
      int i=0;
      int[][] red= new int[(int)largeur/2][(int) hauteur/2];
      while(i<(int) hauteur/2){
          j=0;
          while(j<(int)largeur/2){
              red[i][j]=(image[i*2][j*2]+image[i*2+1][j*2+1]+image[i*2][j*2+1]+image[i*2+1][j*2])/4;
 
          }
      }
  }
    
    public void difference(int[][] img){
        int haut = img.length;
        int larg= img[0].length;
        
        if(img[0].length>largeur){
            larg=largeur;
        }
       if(img.length>hauteur){
           haut=hauteur;
        }
        int[][] diff = new int[larg][haut];
        int i=0;
        int j=0;
        while(i<haut){
            j=0;
            while(j<larg){
               diff[i][j]=(abs(img[i][j]-image[i][j]));
               j++;
            }
            i++;
        }
    }
}
