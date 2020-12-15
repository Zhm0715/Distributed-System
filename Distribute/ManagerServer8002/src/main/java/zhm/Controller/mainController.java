package zhm.Controller;

import domain.Baggage;
import domain.Flight;
import domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zhm.Service.ManagerService;

@Controller
public class mainController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("Login")
    @ResponseBody
    public Boolean Login(@RequestBody Manager manager){
        System.out.println("8002Login");
        System.out.println(manager);
        return this.managerService.isLogin(manager);
    }

    @RequestMapping("AddB")
    @ResponseBody
    public void AddBaggage(@RequestBody Baggage baggage){
        System.out.println("8002AddB");
        this.managerService.AddBaggage(baggage);
    }

    @RequestMapping("AddF")
    @ResponseBody
    public void AddFlight(@RequestBody Flight flight){
        System.out.println("8002AddF");
        this.managerService.AddFlight(flight);
    }

}
