package zhm.core.Service.Imple;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import zhm.core.Dao.FlightDao;
import zhm.core.Service.FlightService;
import zhm.core.domain.Flight;

import java.util.List;

public class FlightServiceImple implements FlightService {

    @Qualifier("flightDao")
    @Autowired
    private FlightDao flightDao;

//    @Insert("insert into Flight() value()")
    @Override
    public void AddFlight(Flight flight) {
        this.flightDao.Add(flight);
    }

//    @Select("Select * from Flight")
    public List<Flight> FlushFlight(){
        return this.flightDao.getAllList();
    }
}
