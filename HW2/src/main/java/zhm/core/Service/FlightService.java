package zhm.core.Service;

import zhm.core.domain.Flight;

import java.util.List;

public interface FlightService {
    void AddFlight(Flight flight);

    List<Flight> FlushFlight();
}
