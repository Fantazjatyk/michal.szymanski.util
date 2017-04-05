/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.commons;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.HttpMethod;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class URLs {

    public static String getMimeTypeOf(URL url) {
        HttpURLConnection connection;
        String result = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(HttpMethod.HEAD);
            connection.connect();
            result = connection.getContentType();
        } catch (Exception e) {

        }
        return result;
    }

}
