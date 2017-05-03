/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.util.collection;

import java.util.Collection;
import java.util.Optional;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class ClassGroupingMapTest {

    ClassGroupingMap map;

    public ClassGroupingMapTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.map = new ClassGroupingMap();
    }

    /**
     * Test of getGroup method, of class ClassGroupingMap.
     */
    @Test
    public void testGetGroup() {
        map.put(new String());
        Collection result = map.getGroup(String.class);

        assertFalse(result.isEmpty());

    }

    /**
     * Test of constainsGroup method, of class ClassGroupingMap.
     */
    @Test
    public void testConstainsGroup() {
        map.put(new String());
        assertTrue(map.constainsGroup(String.class));
    }

    /**
     * Test of removeGroup method, of class ClassGroupingMap.
     */
    @Test
    public void testRemoveGroup() {
        map.put(new String());
        assertTrue(map.constainsGroup(String.class));
        map.removeGroup(String.class);
        assertFalse(map.constainsGroup(String.class));
    }

    /**
     * Test of groupSize method, of class ClassGroupingMap.
     */
    @Test
    public void testGroupSize() {
        map.put(new String());
        map.put(new String());
        map.put(new Double(10.5));
        map.put(new Integer(10));
        assertEquals(2, map.groupSize(String.class));
    }

    /**
     * Test of size method, of class ClassGroupingMap.
     */
    @Test
    public void testSize() {
        map.put(new String());
        map.put(new String());
        map.put(new Double(10.5));
        map.put(new Integer(10));
        map.put(new Integer(11));

        assertEquals(5, map.totalSize());
    }

    /**
     * Test of put method, of class ClassGroupingMap.
     */
    @Test
    public void testPut() {
        map.put(new String());

        assertTrue(map.constainsGroup(String.class));
        assertFalse(map.getGroup(String.class).isEmpty());
    }

    /**
     * Test of clear method, of class ClassGroupingMap.
     */
    @Test
    public void testClear() {
        map.put(new String());
        map.put(new String());
        map.put(new Double(10.5));
        map.put(new Integer(10));
        map.clear();
        assertEquals(0, map.totalSize());
    }

    /**
     * Test of isEmpty method, of class ClassGroupingMap.
     */
    @Test
    public void testIsEmpty() {
        map.put(new String());
        map.put(new String());
        assertFalse(map.isEmpty());
    }

    /**
     * Test of getAnyOf method, of class ClassGroupingMap.
     */
    @Test
    public void testGetAnyOf() {
        map.put(new String("ala"));
        map.put(new String());
        map.put(new Double(10.5));
        map.put(new Integer(10));

        Optional result = map.getAnyOf(String.class);

        assertTrue(result.isPresent());
    }

    /**
     * Test of toMap method, of class ClassGroupingMap.
     */
    /**
     * Test of contains method, of class ClassGroupingMap.
     */
    @Test
    public void testContains() {
        map.put(new String());
        assertFalse(map.contains(new String("ala")));
    }

    @Test
    public void testContainsOptimistic() {
        String string = "ala";
        map.put(string);
        assertTrue(map.contains(string));
    }

    /**
     * Test of toMap method, of class ClassGroupingMap.
     */
    @Test
    public void testToMap() {
    }

    /**
     * Test of remove method, of class ClassGroupingMap.
     */
    @Test
    public void testRemoveOptimistic() {
        String string = "ala";
        map.put(string);
        map.remove(string);
        assertFalse(map.contains(string));
    }

    @Test
    public void testRemovePesimistic() {
        String string = "ala";
        map.put(string);
        map.remove(new String());
        assertTrue(map.contains(string));
    }

    /**
     * Test of remove method, of class ClassGroupingMap.
     */
    @Test
    public void testRemove() {
    }

    /**
     * Test of putAll method, of class ClassGroupingMap.
     */
    @Test
    public void testPutAll() {
    }

    @Test
    public void getMergedGroups() {
        map.put(new String("ala"));
        map.put(new String());
        map.put(new Double(10.5));
        map.put(new Integer(10));

        Collection result = map.getMergedGroup(String.class, Double.class, Integer.class);
        assertEquals(4, result.size());
    }

}
