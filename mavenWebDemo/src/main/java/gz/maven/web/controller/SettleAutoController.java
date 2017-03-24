package gz.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import gz.maven.web.param.OrderParam;

/**
 * Created by tiffanytang on 16/6/13.
 */
@Controller
@RequestMapping("/qa/auto")
public class SettleAutoController {


    @RequestMapping("/page")
    public String index(Model model) {
        return "order/settle_auto";
    }

    @ResponseBody
    @RequestMapping(value = "/settle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Object saveDataByParam(OrderParam orderParam) {  //总的原则，方法每个阶段只要是错误不成功  一律抛错  中断流程
        ModelMap modelMap = new ModelMap();
        orderParam.fixParam();

        return null;
    }
}

