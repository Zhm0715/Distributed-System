package zhm.core.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
// 基于xml
public class RegisterController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest arg0,
                                      HttpServletResponse arg1) throws Exception {
        // 不配置视图解析器
//        return new ModelAndView("/WEB-INF/pages/register.jsp");
        // 配置视图解析器
        return new ModelAndView("register");
    }
}