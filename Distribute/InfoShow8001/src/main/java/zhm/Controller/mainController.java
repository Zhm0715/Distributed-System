package zhm.Controller;

import domain.Baggage;
import domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhm.Service.BaggageService;
import zhm.Service.FlightService;

import java.util.List;

@Controller
public class mainController {

    @Autowired
    private BaggageService baggageService;

    @Autowired
    private FlightService flightService;

    @RequestMapping("/FBaggage")
    @ResponseBody
    public List<Baggage> FlushBaggage(){
        System.out.println("8001FlushBaggage");
        return this.baggageService.FlushBaggage();
    }

    @RequestMapping("FFlight")
    @ResponseBody
    public List<Flight> FlushFlight(){
        System.out.println("8001FlushFlight");
        return this.flightService.FlushFlight();
    }

}
