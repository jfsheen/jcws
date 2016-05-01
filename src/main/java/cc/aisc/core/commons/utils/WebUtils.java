package cc.aisc.core.commons.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sjf on 16-5-1.
 */
public abstract class WebUtils extends org.apache.shiro.web.util.WebUtils {

    public static boolean isAjax(HttpServletRequest request) {
        return "XmlHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }

    public static void sendJson(HttpServletResponse response, String json) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
