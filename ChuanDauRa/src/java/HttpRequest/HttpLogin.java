/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import static javax.ws.rs.client.Entity.json;
import org.json.JSONObject;

/**
 *
 * @author Man Pham
 */
public class HttpLogin {

    private static HttpURLConnection connection;
    private String jsonInput;
    public Boolean isNQL;
    private String erMessage;

    public String getErMessage() {
        return erMessage;
    }

    public void setErMessage(String erMessage) {
        this.erMessage = erMessage;
    }

    
    public Boolean getIsNQL() {
        return isNQL;
    }

    public void setIsNQL(Boolean isNQL) {
        this.isNQL = isNQL;
    }

    
    public String getJsonInput() {
        return jsonInput;
    }

    public void setJsonInput(String jsonInput) {
        this.jsonInput = jsonInput;
    }
    

    public HttpLogin() {
    }

    public HttpLogin(String id, String passW) {
        this.jsonInput = "{\"id\":\"" + id + "\",\"password\":\"" + passW + "\" }";
    }
    public HttpLogin(String id) {
        this.jsonInput = "{\"id\":\"" + id + "\" }";
    }

    public Boolean httpPostAccout(String url) throws MalformedURLException, UnsupportedEncodingException, IOException {
        StringBuilder responseContent = new StringBuilder();
        URL myurl = new URL(url);
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) myurl.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json;");
            con.setRequestProperty("Accept", "application/json,text/plain");
            con.setRequestProperty("Method", "POST");

            try (OutputStream os = con.getOutputStream()) {
                os.write(this.jsonInput.getBytes("UTF-8"));
            } catch (Exception e) {
                this.setErMessage(e.toString());
                return false;
            }
            StringBuilder sb = new StringBuilder();
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                String line;
                try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                    line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                }
                JSONObject Connect = new JSONObject(sb.toString());
                this.setIsNQL(Connect.getBoolean("isTruongKhoa"));
                return true;
            } else {
                this.setErMessage(con.getResponseCode() +" "+ con.getResponseMessage());
                return false;
            }
        } catch (IOException e) {
            this.setErMessage(e.toString());
            return false;
        } finally {
            try {
                con.disconnect();
            } catch (Exception e) {
            }
        }

    }

    public String httpGetAccout(String url) throws MalformedURLException, UnsupportedEncodingException, IOException {
        StringBuilder responseContent = new StringBuilder();
        URL myurl = new URL(url);
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) myurl.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json;");
            con.setRequestProperty("Accept", "application/json,text/plain");
            con.setRequestProperty("Method", "GET");

            StringBuilder sb = new StringBuilder();
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                String line;
                try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                    line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                }
                return sb.toString();
            } else {
                return "Error" + con.getResponseCode() + "Error" + " " + con.getResponseMessage();
            }
        } catch (IOException e) {
            return e.toString();
        } finally {
            try {
                con.disconnect();
            } catch (Exception e) {
            }
        }
    }

}
































