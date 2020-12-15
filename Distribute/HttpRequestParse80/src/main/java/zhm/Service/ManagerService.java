package zhm.Service;

import com.netflix.ribbon.proxy.annotation.Http;
import domain.Baggage;
import domain.Flight;
import domain.Manager;
import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ManagerServer8002")
public interface ManagerService {

    @RequestMapping(value = "Login", method = RequestMethod.POST)
    Boolean isLogin(@RequestBody Manager manager);

    @RequestMapping("AddB")
    void AddBaggage(@RequestBody Baggage baggage);

    @RequestMapping("AddF")
    void AddFlight(@RequestBody Flight flight);

}
