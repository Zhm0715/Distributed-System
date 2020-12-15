package zhm.Controller;


import domain.Baggage;
import domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhm.Service.InfoShowService;
import zhm.Service.ManagerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Airport/Flush")
public class FlushController {

    @Autowired
    private InfoShowService infoShowService;

    // ajax刷新

    @RequestMapping("/FlushBaggage")
    public void FlushBaggage(HttpServletResponse response) throws IOException {
        System.out.println("FlushBaggage");
        List<Baggage> baggageList = this.infoShowService.FlushBaggage();
        List<String> ans = new ArrayList<String>();
        for (Baggage baggage:
                baggageList) {
            ans.add(baggage.toString());
        }
        System.out.println(ans);
        response.setContentType("text/javascript");
        response.getWriter().println(ans);
    }

    @RequestMapping("/FlushFlight")
    public void FlushFlight(HttpServletResponse response) throws IOException {
        System.out.println("FlushFlight");
        List<Flight> flightList = this.infoShowService.FlushFlight();
        List<String> ans = new ArrayList<String>();
        for (Flight flight:
                flightList) {
            ans.add(flight.toString());
        }
        System.out.println(ans);
        response.setContentType("text/javascript");
        response.getWriter().println(flightList);
    }

}
