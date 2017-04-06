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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com.
 */
public abstract class Mapper {

    public static Map<String, Object> map(Object o) {
        Map map = new HashMap();

        Method[] getters = getGetters(o);
        java.util.Arrays.stream(getters).forEach((el) -> {
            map.put(getFieldNameFromGetter(el.getName()), getGetterResult(el, o));
        });

        return map;
    }

    public static Method[] getGetters(Object o) {
        Method[] methods = o.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (!methods[i].getName().startsWith("get") || methods[i].getReturnType().getTypeName().equals("void")) {
                methods[i] = null;
            }
        }
        Object[] result = java.util.Arrays.stream(methods).filter((el)->!Objects.isNull(el)).toArray();
        return java.util.Arrays.copyOf(result, result.length, Method[].class);
    }

    private static String getFieldNameFromGetter(String name) {
        String result = name.replace("get", "");
        Character start = result.charAt(0);
        Character lowercaseStart = Character.toLowerCase(start);
        result = result.replace(start, lowercaseStart);
        return result;
    }

    private static Object getGetterResult(Method method, Object invoker) {
        Object field = null;
        try {
            field = method.invoke(invoker);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return field;
    }

}
