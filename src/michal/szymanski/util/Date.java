/*
 * The MIT License
 *
 * Copyright 2017 Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package michal.szymanski.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com.
 */
public class Date {

    public static String getDateToString(int year, int month, int day, DateTimeFormatter format) {
        LocalDate localDate = LocalDate.of(year, month, day);

        return localDate.format(format);
    }

    public static int getLastAvaibleDayInMonth(int year, int month) {

        return isActualMonth(year, month) ? LocalDate.now().getDayOfMonth() : LocalDate.of(year, month, 1).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    }

    public static int[] getArrayOfLastAvaibleDaysInMonths(int year) {
        int[] months = new int[12];

        for (int i = 1; i < months.length; i++) {
            months[i] = Date.getLastAvaibleDayInMonth(year, i);
        }

        return months;
    }

    public static boolean isActualMonth(int year, int month) {
        int actualYear = LocalDate.now().getYear();
        int actualMonth = LocalDate.now().getMonthValue();

        return (year == actualYear && month == actualMonth);
    }
}
