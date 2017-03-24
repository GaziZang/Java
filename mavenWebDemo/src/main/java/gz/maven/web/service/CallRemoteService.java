package gz.maven.web.service;


import com.google.gson.JsonObject;
import gz.maven.web.constant.Constants;
import gz.maven.web.helper.JsonHelper;
import gz.maven.web.model.Response;
import gz.maven.web.model.User;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gazizang on 17/3/19.
 */
public class CallRemoteService {
    public String httpPost(String method){
        HttpClient httpClient = new DefaultHttpClient();
        String url = Constants.url + method;
        HttpPost httpPost = new HttpPost(url);
        String result = "";
        try
        {
            User user = new User();
            user.setUserName("request");
            user.setAge(21);
//            StringEntity entity = new StringEntity(JsonHelper.objectToJson(user), "UTF-8");
//            entity.setContentEncoding("UTF-8");
//            entity.setContentType("application/json");

            List<NameValuePair> params = new LinkedList<NameValuePair>();
            params.add(new BasicNameValuePair("user", JsonHelper.objectToJson(user)));

            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            result = EntityUtils.toString(httpResponse.getEntity());
            Response response = JsonHelper.jsonToObject(result, Response.class);
            System.out.println(response);

        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
