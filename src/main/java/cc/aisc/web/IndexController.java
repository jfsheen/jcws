package cc.aisc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sjf on 16-4-24.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
}
