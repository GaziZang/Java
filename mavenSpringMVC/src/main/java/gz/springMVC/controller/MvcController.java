package gz.springMVC.controller;

import gz.springMVC.helper.JsonHelper;
import gz.springMVC.model.Response;
import gz.springMVC.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gazizang on 17/3/15.
 */
@Controller
@RequestMapping("/mvc")
public class MvcController {
    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String postHello(@RequestParam(value = "data", required = false) String data){
        System.out.println(data);
        return JsonHelper.objectToJson(new Response());
    }

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(@RequestParam("data") String data){
        System.out.println(data);
        return JsonHelper.objectToJson(new Response());
    }
}
