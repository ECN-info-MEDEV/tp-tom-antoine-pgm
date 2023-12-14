/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.td_imagespgm;
        import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author 33651
 */
public class TD_ImagesPGM {

    public static void main(String[] args) {
        Image babouin = new Image("baboon.pgm");
        Visuel affichage=new Visuel();
        babouin.Lecture();
        babouin.Ecriture("babouin");
        affichage.showImg(babouin.image);
        affichage.showPGM("baboon.pgm");
}}
