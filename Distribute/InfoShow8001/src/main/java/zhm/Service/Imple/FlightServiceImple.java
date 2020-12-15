package zhm.Service.Imple;

import com.netflix.discovery.converters.Auto;
import domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import zhm.DAO.FlightDao;
import zhm.Service.FlightService;

import java.util.List;

@Service
@Component
public class FlightServiceImple implements FlightService {

    @Autowired
    private FlightDao flightDao;

    @Override
    public List<Flight> FlushFlight(){
        return this.flightDao.getAllList();
    }

}
