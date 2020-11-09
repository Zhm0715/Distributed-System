package zhm.core.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
// 基于xml
public class LoginController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest arg0,
                                      HttpServletResponse arg1) throws Exception {
        return new ModelAndView("login");
    }
}