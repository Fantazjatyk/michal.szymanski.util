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
package michal.szymanski.commons;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com.
 */
public class Strings {

    public static String[] cutMatchingFragments(String source, String regexp, boolean ignoreCase) {
        List<String> result = new ArrayList();
        if (ignoreCase) {
            regexp = regexp.toLowerCase();
        }

        if (regexp.isEmpty()) {
            return new String[0];
        }
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(source);

        while (!matcher.hitEnd()) {
            if (matcher.find()) {
                result.add(matcher.group());
            }
        }

        return result.toArray(new String[0]);
    }

    public static String[] splitByCommas(String input) {
        String[] result = input.trim().split("\\s*,\\s*");
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].trim();
        }

        return result;
    }

    public static int countCharacters(String text) {
        return text.replaceAll("\\s+", "").length();
    }

}
