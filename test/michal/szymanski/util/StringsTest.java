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
public class StringsTest {

    public StringsTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of cutMatchingFragments method, of class Strings.
     */
    @Test
    public void testCutMatchingFragments() {
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempus sed ipsum bibendum eleifend. Duis vel velit ante. Morbi pellentesque nunc a justo vehicula rhoncus. Nullam sollicitudin nulla augue, in congue purus venenatis et. Phasellus eu arcu mauris. Aenean commodo lacus ac tortor facilisis consequat. Nulla in commodo mauris, quis tempor erat. Sed tristique massa diam.\n" +
"\n" +
"Etiam dapibus leo quis turpis pellentesque, vel tincidunt erat condimentum. Suspendisse id euismod purus. Ut a maximus nisl. Pellentesque blandit elit a nulla vulputate, ac suscipit erat rutrum. Nullam nec lacinia leo. Vestibulum ante Ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut nisi purus, tincidunt euismod laoreet eu, vestibulum quis dui.";

        String toCut = "ipsum";
        String[] result = Strings.cutMatchingFragments(input, toCut);
        assertEquals(2, result.length);
    }

     @Test
    public void testCutMatchingFragmentsIgnoreCase() {
           String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempus sed ipsum bibendum eleifend. Duis vel velit ante. Morbi pellentesque nunc a justo vehicula rhoncus. Nullam sollicitudin nulla augue, in congue purus venenatis et. Phasellus eu arcu mauris. Aenean commodo lacus ac tortor facilisis consequat. Nulla in commodo mauris, quis tempor erat. Sed tristique massa diam.\n" +
"\n" +
"Etiam dapibus leo quis turpis pellentesque, vel tincidunt erat condimentum. Suspendisse id euismod purus. Ut a maximus nisl. Pellentesque blandit elit a nulla vulputate, ac suscipit erat rutrum. Nullam nec lacinia leo. Vestibulum ante Ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut nisi purus, tincidunt euismod laoreet eu, vestibulum quis dui.";

        String toCut = "ipsum";
        String[] result = Strings.cutMatchingFragmentIgnoreCase(input, toCut);
        assertEquals(3, result.length);
    }
    /**
     * Test of splitByCommas method, of class Strings.
     */
    @Test
    public void testSplitByCommas() {
        String[] result = Strings.splitByCommas("ala, ma, kota");
        assertEquals(3, result.length);

    }

    @Test
    public void testSplitByCommasWithWhitespaces() {
        String[] result = Strings.splitByCommas("ala,                      ma                ,  kota");
        assertEquals(3, result.length);
    }

    @Test
    public void testSplitByCommasNoInput() {
        String[] result = Strings.splitByCommas("");
        assertEquals(0, result.length);
    }
    /**
     * Test of countCharacters method, of class Strings.
     */
    @Test
    public void testCountCharacters() {
        String input = "ala ma             kota  ";
        int characters = 9;
        int result = Strings.countCharacters(input);

        assertEquals(characters, result);
    }

      @Test
    public void testCountCharactersNoInput() {
        String input = "";
        int characters = 0;
        int result = Strings.countCharacters(input);

        assertEquals(characters, result);
    }

}
