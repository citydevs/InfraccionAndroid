package mx.citydevs.hackcdmx.httpconnection;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;

import mx.citydevs.hackcdmx.dialogues.Dialogues;

/**
 * Created by mikesaurio on 1/1/16.
 */
public class HttpConnection {
	public static final String TAG_CLASS = HttpConnection.class.getName();
	
	public static final String URL = "http://infracciones.herokuapp.com/";
    public static final String OFFICERS = "http://201.144.220.174/infracciones/api/personal/acreditado";
    public static final String INFRACTIONS = "http://201.144.220.174/infracciones/api/articulos/articulo_vigente";

    public static final String RANK = "cops/new?identification=%s&infraccion=%s&articulo=%s&coincidio=%s&documents=%s&copy=%s&latitude=19.4394829&longitude=-99.1823385&cop_id=830625";

    /**
     * Permite leer un BufferedReader y convertirlo en String
     * @param rd (Reader) BufferedReader a leer
     * @return (String) del BufferedReader enviado
     * @throws IOException
     */
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    /**
     * Permite hacer metodo GET por HTTP
     * @param url (String) url para el get
    */
    public static String GET(String url) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String string_json= null;
        InputStream is= null;
        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            string_json =  readAll(rd);
        } catch (Exception ex){
                Log.e(TAG_CLASS, ex.getMessage());
        }finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return string_json;
    }
}
