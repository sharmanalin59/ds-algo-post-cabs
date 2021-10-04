package algo;


import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Nalin {

    /*static  class JsonResult {
        private String Title;
        private String Year;
        private String imdbID;
    }
    public static void main(String[] args) throws IOException {
        String urlString = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
        *//*URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman");
        URLConnection conn = url.openConnection();
        conn.connect();
        System.out.println(conn.getContent());*//*


        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "val");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

    }*/
}
