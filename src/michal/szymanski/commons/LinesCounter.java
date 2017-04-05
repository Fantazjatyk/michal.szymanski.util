/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class LinesCounter {

    public enum LineBreak {

        HTML("\r\n"),
        UNIX("\n"),
        WINDOWS("");

        String lineBreak;

        LineBreak(String string) {
            this.lineBreak = string;
        }

        public String getLineBreak() {
            return this.lineBreak;
        }
    }

    public static int countLines(String input1, LineBreak lineBreak) {
        Pattern pattern = Pattern.compile(lineBreak.getLineBreak(), Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input1);
        int linesCount = 0;

        while (!matcher.hitEnd()) {
            if (matcher.find()) {
                linesCount++;
            }
        }
        linesCount++;
        return linesCount;
    }

    private static Matcher prepareMatcher(String regexp, String input) {
        Pattern pattern = Pattern.compile(regexp, Pattern.MULTILINE);
        return pattern.matcher(input);
    }

    public static int countEmptyLines(String input, LineBreak lineBreak) {
        int emptyLines = 0;
        int offset = input.indexOf(lineBreak.getLineBreak());

        if (offset == -1) {
            return 0;
        }

        int patternLenght = lineBreak.getLineBreak().length();

        Matcher matcher = prepareMatcher(lineBreak.getLineBreak(), input);

        int lastMatchedID = 0;
        while (!matcher.hitEnd()) {
            while (matcher.find(offset)) { // matcher find
                matcher.region(offset, offset + patternLenght);
                if (matcher.find()) { // if(zaraz po nim jest kolejny){
                    int matchedStart = matcher.start();

                    if (matchedStart == lastMatchedID && offset != 0) {
                        emptyLines++;
                        offset = matcher.end();
                    } else {
                        lastMatchedID = offset + patternLenght;
                        offset = offset + patternLenght;
                    }
                } else {
                    offset = offset + patternLenght;
                }
            }
        }
        return emptyLines;
    }
}
