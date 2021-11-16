package nio01;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientDemo {
    public static void main(String[] args) {
        String url = "http://localhost:8801";
        try {
            System.out.println(HttpClientDemo.httpGet(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String httpGet(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {//请求体内容
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }

        return null;
    }

}


