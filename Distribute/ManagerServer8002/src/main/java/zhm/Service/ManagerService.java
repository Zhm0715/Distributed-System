package zhm.Service;

import domain.Baggage;
import domain.Flight;
import domain.Manager;

public interface ManagerService {

    Boolean isLogin(Manager manager);

    void AddBaggage(Baggage baggage);

    void AddFlight(Flight flight);
}
