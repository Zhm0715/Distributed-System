package zhm.Controller;

import com.netflix.discovery.converters.Auto;
import domain.Baggage;
import domain.Flight;
import domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import zhm.Service.InfoShowService;
import zhm.Service.ManagerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class mainController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private InfoShowService infoShowService;

    @RequestMapping(path="/AirportMain")
    public String AirportMain(HttpServletRequest request){
        return "MainPage";
    }

    @RequestMapping("/AirportMain/FlightInfo")
    public String FlightInfo(){
        System.out.println("FlightInfo");
        return "FlightInfo";
    }

    @RequestMapping("/AirportMain/BaggageInfo")
    public String BaggageInfo(){
        System.out.println("BaggageInfo");
        return "BaggageInfo";
    }

    @RequestMapping("/AirportMain/Login")
    public String LoginPage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println("LoginPage");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session != null){
            return "ManagerPage";
        }
        return "ManagerLogin";
    }

    // 管理员登录

    @RequestMapping("/AirportMain/Manager")
    public String ManagerLogin(Manager manager, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println("ManagerLogin");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session != null){
            System.out.println(user_session);
            return "ManagerPage";
        }
        if(manager.getPassword() == null || manager.getUsername() == null){
            return "ForbidAccess";
        }
        Map<String, Object> parms = new HashMap<>();
        boolean successLogin = this.managerService.isLogin(manager);
        System.out.println(manager);
        System.out.println(successLogin);
        if(successLogin){       // 传递参数
            session.setAttribute("USER_SESSION", manager);
            return "ManagerPage";
        }
        return "FailLogin";                    // 返回登录失败界面
    }

}
