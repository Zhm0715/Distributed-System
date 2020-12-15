package zhm.Service;

import domain.Baggage;
import domain.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("InfoShow8001")
public interface InfoShowService {

    @RequestMapping("FBaggage")
    List<Baggage> FlushBaggage();

    @RequestMapping("FFlight")
    List<Flight> FlushFlight();

}
