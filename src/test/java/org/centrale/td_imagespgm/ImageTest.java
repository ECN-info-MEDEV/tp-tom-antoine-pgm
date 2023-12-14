/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.td_imagespgm;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Utilisateur
 */
public class ImageTest {

    Image baboon = new Image("baboon.pgm");
    Image coins = new Image("coins.pgm");
    Image brain = new Image("brain.pgm");

    public ImageTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of Lecture method, of class Image.
     */
    @Test
    public void testLecture() {
        System.out.println("Lecture");
        //Image instance = null;

        Image baboon = new Image("baboon.pgm");
        Image coins = new Image("coins.pgm");
        Image brain = new Image("brain.pgm");
        baboon.Lecture();
        coins.Lecture();
        brain.Lecture();
        System.out.println("assert");
        assertFalse(baboon.equal(coins));
        assertFalse(baboon.equal(brain));
        assertFalse(coins.equal(brain));

        assertTrue(baboon.equal(baboon));
        assertTrue(coins.equal(coins));
        assertTrue(brain.equal(brain));

    }

}
