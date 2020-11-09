package zhm.core.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import zhm.core.domain.Flight;

import java.util.List;

@Repository("flightDao")
public interface FlightDao {

    @Insert("insert into Flight(FlightID, FlightCompany, BeginPos, " +
            "DestPos, StopOver, PlaneGo, PlaneArrive, ActuallyArrive, " +
            "FlightBuilding, GoDoor, ReadyPos, FlightState)" +
            "value(#{FlightID}, #{FlightCompany}, #{BeginPos}, #{DestPos}, " +
            "#{StopOver}, #{PlaneGo}, #{PlaneArrive}, #{ActuallyArrive}, #{FlightBuilding}, " +
            "#{GoDoor}, #{ReadyPos}, #{FlightState})")
    void Add(Flight flight);

    @Select("select * from Flight")
    List<Flight> getAllList();
}
