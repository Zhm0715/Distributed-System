package zhm.Service.Imple;

import domain.Baggage;
import domain.Flight;
import domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import zhm.DAO.BaggageDao;
import zhm.DAO.FlightDao;
import zhm.DAO.ManagerDao;
import zhm.Service.ManagerService;

@Service
@Component
public class ManagerServiceImple implements ManagerService {

    @Autowired
    private BaggageDao baggageDao;

    @Autowired
    private FlightDao flightDao;

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Boolean isLogin(Manager manager) {
        System.out.println(manager);
        return this.managerDao.existManager(manager);
    }

    @Override
    public void AddBaggage(Baggage baggage) {
        Integer key = this.baggageDao.Add(baggage);
    }

    @Override
    public void AddFlight(Flight flight) {
        this.flightDao.Add(flight);
    }

}
