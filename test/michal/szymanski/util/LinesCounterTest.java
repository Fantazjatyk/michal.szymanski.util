/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.util;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class LinesCounterTest {

    public LinesCounterTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    /**
     * Test of countLines method, of class LinesCounter.
     */
    @Test
    public void testCountLines() {
        String input = "ala\n    ma   \n kota";
        int lines = 3;
        int result = LinesCounter.countLines(input, LinesCounter.LineBreak.UNIX);
        assertEquals(lines, result);
    }

    @Test
    public void testCountLines_NoInput() {
        String input = "";
        int lines = 0;
        int result = LinesCounter.countLines(input, LinesCounter.LineBreak.UNIX);
        assertEquals(lines, result);
    }

    /**
     * Test of countEmptyLines method, of class LinesCounter.
     */
    @Test
    public void testCountEmptyLines() {
        String input = "ala\n\n    ma \n   \n kota";
        int emptyLines = 2;
        int result = LinesCounter.countEmptyLines(input, LinesCounter.LineBreak.UNIX);
        assertEquals(emptyLines, result);
    }

    @Test
    public void testCountEmptyLines_NoInput() {
        String input = "";
        int emptyLines = 0;
        int result = LinesCounter.countEmptyLines(input, LinesCounter.LineBreak.UNIX);
        assertEquals(emptyLines, result);
    }

}
