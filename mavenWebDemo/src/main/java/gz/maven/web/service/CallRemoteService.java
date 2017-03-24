package gz.maven.web.service;


import com.google.gson.JsonObject;
import gz.maven.web.constant.Constants;
import gz.maven.web.helper.JsonHelper;
import gz.maven.web.model.Response;
import gz.maven.web.model.User;
import gz.maven.web.util.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gazizang on 17/3/19.
 */
public class CallRemoteService {
    public String httpPost(String method) {
        String url = Constants.url + method;
        HttpPost httpPost = new HttpPost(url);
        HttpClient httpClient = HttpClients.createDefault();

        User user = new User();
        user.setUserName("request");
        user.setAge(21);

        List<NameValuePair> params = new LinkedList<NameValuePair>();
        params.add(new BasicNameValuePair("data", JsonHelper.objectToJson(user)));
//        params.add(new BasicNameValuePair("userName", "request"));
//        params.add(new BasicNameValuePair("age", "21"));

        try {

            httpPost.setEntity(new StringEntity(JsonHelper.objectToJson(user), ContentType.APPLICATION_JSON));
//            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = httpClient.execute(httpPost);
            String result = response.getEntity().toString();

            return result;
//            return HttpUtil.post(url, params);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
