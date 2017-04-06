/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.util;

import java.lang.reflect.Method;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class MapperTest {

    TestingObject obj;
     WrongTestingObject wrong;


    public MapperTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        obj = new TestingObject();
        obj.setInteger(1);
        obj.setString("test");

        wrong = new WrongTestingObject();
        wrong.setInteger(1);
        wrong.setString(null);
    }

    /**
     * Test of map method, of class Mapper.
     */
    class TestingObject {

        private String string;
        private int integer;

        public String getString() {
            return this.string;
        }

        public int getInteger() {
            return this.integer;
        }

        public void setString(String string) {
            this.string = string;
        }

        public void setInteger(int integer) {
            this.integer = integer;
        }

        public void doNothing() {
        }

    }

    class WrongTestingObject extends TestingObject {

        public void getFake() {

        }

        public Object getNull() {
            return null;
        }

    }

    @Test
    public void testGetGetters() {

        Method[] methods = Mapper.getGetters(obj);
        assertEquals(3, methods.length);
    }

    @Test
    public void testGetGetters_Pesimistic() {

        Method[] methods = Mapper.getGetters(obj);
        assertEquals(3, methods.length);
    }

    @Test
    public void testMap() {
        Map<String, Object> result = Mapper.map(obj);
        assertEquals(3, result.size());
        assertEquals(obj.getInteger(), result.get("integer"));
        assertEquals(obj.getString(), result.get("string"));
    }

    @Test
    public void testMap_NullField() {
        obj.setString(null);
        Map<String, Object> result = Mapper.map(obj);
        assertEquals(3, result.size());
        assertEquals(obj.getInteger(), result.get("integer"));
        assertEquals(obj.getString(), result.get("string"));
    }

       @Test
    public void testMap_InvalidGetters() {

        Map<String, Object> result = Mapper.map(wrong);
        assertEquals(4, result.size());
        assertEquals(wrong.getInteger(), result.get("integer"));
        assertEquals(wrong.getString(), result.get("string"));
        assertEquals(wrong.getNull(), result.get("null"));
    }


    /**
     * Test of getFieldNameFromGetter method, of class Mapper.
     */
}
