package zhm.Controller;

import domain.Baggage;
import domain.Flight;
import domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhm.Service.InfoShowService;
import zhm.Service.ManagerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("AirportMain/Manager")
public class ManagerController {

    @Autowired
    private InfoShowService infoShowService;

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/AddFlight")
    public void AddFlight(Flight flight, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AddFlight");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session == null){
            response.sendRedirect("/AirportMain/Login");
        }
        Map<String, Object> parms = new HashMap<>();
        this.managerService.AddFlight(flight);
        System.out.println("添加成功");
        response.sendRedirect("/AirportMain/Manager");
    }

    @RequestMapping("/AddBaggagePage")
    public String AddBaggagePage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("AddBaggagePage");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session == null){
            response.sendRedirect("/AirportMain/Login");
        }
        return "AddBaggage";
    }

    @RequestMapping("/AddFlightPage")
    public String AddFlightPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("AddFlightPage");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session == null){
            response.sendRedirect("/AirportMain/Login");
        }
        return "AddFlight";
    }

    @RequestMapping("/AddBaggage")
    public void AddBaggage(Baggage baggage, HttpServletResponse response, HttpServletRequest request) throws IOException{
        System.out.println("AddBaggage");
        HttpSession session = request.getSession();
        Manager user_session = (Manager) session.getAttribute("USER_SESSION");
        if(user_session == null){
            response.sendRedirect("/AirportMain/Login");
        }
        Map<String, Object> parms = new HashMap<>();
        parms.put("newFlight", baggage);
        this.managerService.AddBaggage(baggage);
        System.out.println("添加成功");
        response.sendRedirect("/AirportMain/Manager");
    }

}
