package gz.maven.web.webTest;

import org.springframework.beans.factory.annotation.Autowired;
import gz.maven.web.service.CallRemoteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by gazizang on 17/3/10.
 */
public class TestServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
        Map<String, String[]> params = req.getParameterMap();

//        response.setContentType("text/json");
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.getWriter().println("sdhfajsdflk");

        String methodUrl = "/mvc/hello/new";
        String result = new CallRemoteService().httpPost(methodUrl);
        response.getWriter().println(result);
    }
}
