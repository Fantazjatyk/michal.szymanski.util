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
public class ArraysTest {

    public ArraysTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of convertAnyArrayToStringArray method, of class Arrays.
     */
    @Test
    public void testConvertAnyArrayToStringArray() {
        Object[] input = new Object[]{"ala", 1, true, new Long(2)};
        String[] result = Arrays.convertAnyArrayToStringArray(input);
        assertEquals(result[0], "ala");
        assertEquals(result[1], "1");
        assertEquals(result[2], "true");
        assertEquals(result[3], "2");
    }

}
