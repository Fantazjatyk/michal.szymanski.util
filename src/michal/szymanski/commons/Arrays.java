/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.commons;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class Arrays{

    public static String[] convertAnyArrayToStringArray(Object[] objs){
        String[] result = new String[objs.length];

        for(int i = 0; i < result.length; i++){
            result[i] = String.valueOf(objs[i]);
        }
        return result;
    }
}
