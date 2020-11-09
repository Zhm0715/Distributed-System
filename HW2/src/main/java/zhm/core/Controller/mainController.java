package zhm.core.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhm.core.Service.BaggageService;
import zhm.core.Service.FlightService;
import zhm.core.Service.ManagerService;
import zhm.core.domain.Baggage;
import zhm.core.domain.Flight;
import zhm.core.domain.Manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

// 基于注解
@Controller
public class mainController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private BaggageService baggageService;
    /*
        html的连接：初始页面:localhost/zhm/
        test: localhost/zhm/test
        /test:localhost/test
     */

    // html里不用加/ RequestMapping里要加/

    @RequestMapping(path="/AirportMain")
    public String AirportMain(HttpServletRequest request){
        return "MainPage";
    }

    @RequestMapping("/AirportMain/FlightInfo")
    public String FlightInfo(){
        return "FlightInfo";
    }

    @RequestMapping("/AirportMain/BaggageInfo")
    public String BaggageInfo(){
        return "BaggageInfo";
    }

    @RequestMapping("/AirportMain/Login")
    public String LoginPage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
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
//        request.setCharacterEncoding("utf-8");
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
        System.out.println(manager);
        if(this.managerService.isLogin(manager)){       // 登录成功返回管理员界面
            session.setAttribute("USER_SESSION", manager);
            return "ManagerPage";
        }
        return "FailLogin";                    // 返回登录失败界面
    }

    // 添加数据

    @RequestMapping("/AirportMain/Manager/AddFlight")
    public void AddFlight(Flight flight, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session == null){
            response.sendRedirect("/zhm/AirportMain/Login");
        }
        this.flightService.AddFlight(flight);
        System.out.println("添加成功");
        response.sendRedirect("/zhm/AirportMain/Manager");
    }

    @RequestMapping("/AirportMain/Manager/AddBaggagePage")
    public String AddBaggagePage(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session == null){
            response.sendRedirect("/zhm/AirportMain/Login");
        }
        return "AddBaggage";
    }

    @RequestMapping("/AirportMain/Manager/AddFlightPage")
    public String AddFlightPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session == null){
            response.sendRedirect("/zhm/AirportMain/Login");
        }
        return "AddFlight";
    }

    @RequestMapping("/AirportMain/Manager/AddBaggage")
    public void AddBaggage(Baggage baggage, HttpServletResponse response, HttpServletRequest request) throws IOException{
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session == null){
            response.sendRedirect("/zhm/AirportMain/Login");
        }
        this.baggageService.AddBaggage(baggage);
        System.out.println("添加成功");
        response.sendRedirect("/zhm/AirportMain/Manager");
    }

    // ajax刷新数据

    @RequestMapping("/Airport/Manager/FlushBaggage")
    public void FlushBaggage(HttpServletResponse response) throws IOException {
//        response.setCharacterEncoding("utf-8");
        System.out.println("FlushBaggage");
        List<Baggage> baggageList = this.baggageService.FlushBaggage();
        List<String> ans = new ArrayList<String>();
        for (Baggage baggage:
             baggageList) {
            ans.add(baggage.toString());
        }
        System.out.println(ans);
        response.setContentType("text/javascript");
        response.getWriter().println(ans);
    }

    @RequestMapping("/Airport/Manager/FlushFlight")
    public void FlushFlight(HttpServletResponse response) throws IOException {
//        response.setCharacterEncoding("utf-8");
        System.out.println("FlushFlight");
        List<Flight> flightList = this.flightService.FlushFlight();
        List<String> ans = new ArrayList<String>();
        for (Flight flight:
             flightList) {
            ans.add(flight.toString());
        }
        System.out.println(ans);
        response.setContentType("text/javascript");
        response.getWriter().println(flightList);
    }

//    @RequestMapping("/test")
//    public String Test(){
//        return "test";
//    }

//    @RequestMapping("/intro")
//    public String Introduce(){
//        return "introduce.html";
//    }

//    @RequestMapping("/login")
//    public String login(){
//        return "login.jsp";
//    }
//
//    @RequestMapping("/register")
//    public String register(){
//        // 默认转发 register作为一个对象 请求被转发到register.jsp
//        return "register.jsp";
//        // 转发到一个请求方法
////        return "forward:/isLogin";
//        // 重定向到一个请求方法
////        return "redirect:/isRegister"; // redirect:/html/test.html 需要符合拦截规范
//    }
}
