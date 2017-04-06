/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.util;

import com.google.common.net.MediaType;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class URLsTest {

    public URLsTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of getMimeTypeOf method, of class URLs.
     */
    @Test
    public void testGetMimeTypeOf() throws MalformedURLException {
        URL url = new URL("https://www.w3schools.com/css/img_fjords.jpg");
        MediaType type = URLs.getMimeTypeOf(url);

        assertEquals(MediaType.JPEG, type);
    }

    @Test
    public void testGetMimeTypeOf_Pesimistic() throws MalformedURLException {
        URL url = null;
        MediaType type = URLs.getMimeTypeOf(url);

        assertEquals(MediaType.ANY_TYPE, type);
    }

}
