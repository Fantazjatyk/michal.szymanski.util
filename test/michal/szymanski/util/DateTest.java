/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class DateTest {

    public DateTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of dateStringValueOf method, of class Date.
     */
    @Test
    public void testDateStringValueOf() {
        int year = 2017;
        int month = 4;
        int day = 6;

        String result = Date.getDateToString(year, month, day, DateTimeFormatter.ISO_DATE);

        assertEquals("2017-04-06", result);
    }



    /**
     * Test of getLastAvaibleDayInMonth method, of class Date.
     */
    @Test
    public void testGetLastAvaibleDayInMonth() {
        int year = 2017;
        int month = 3;
        int lastDay = 31;

        int result = Date.getLastAvaibleDayInMonth(year, month);
        assertEquals(lastDay, result);
    }

    /**
     * Test of getArrayOfLastAvaibleDaysInMonths method, of class Date.
     */
    @Test
    public void testGetArrayOfLastAvaibleDaysInMonths() {
        int year = 2017;
        int febuary = 2;
        int febuaryLastDay = 28;
        int march = 3;
        int marchLastDay = 31;

        int[] result = Date.getArrayOfLastAvaibleDaysInMonths(year);

        assertEquals(febuaryLastDay, result[febuary]);
        assertEquals(marchLastDay, result[march]);
    }


    @Test
    public void testIsActualMonth(){
       int year = LocalDate.now().getYear();
       int month = LocalDate.now().getMonthValue();

       assertTrue(Date.isActualMonth(year, month));
    }

       @Test
    public void testIsActualMonth_Pesimistic(){
       int year = 2021;
       int month = LocalDate.now().getMonthValue();

       assertFalse(Date.isActualMonth(year, month));
    }


}
