package gz.maven.web.webTest;

import gz.maven.web.helper.JsonHelper;
import gz.maven.web.param.OrderParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gazizang on 17/3/8.
 */
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String json = JsonHelper.objectToJson(new OrderParam());
        OrderParam orderParam = JsonHelper.jsonToObject(json, OrderParam.class);

        response.setContentType("text/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(json);

//        response.setContentType("text/html");
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.getWriter().println("<h1>Hello Servlet!!!!, My Name is Marcus Li.</h1>");
//        response.getWriter().println("session = " + request.getSession(true).getId());
    }
}
