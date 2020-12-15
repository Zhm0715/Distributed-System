package zhm.DAO;

import domain.Flight;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Mapper
public interface FlightDao {

    @Insert("insert into Flight(FlightID, FlightCompany, BeginPos, " +
            "DestPos, StopOver, PlaneGo, PlaneArrive, ActuallyArrive, " +
            "FlightBuilding, GoDoor, ReadyPos, FlightState)" +
            "value(#{FlightID}, #{FlightCompany}, #{BeginPos}, #{DestPos}, " +
            "#{StopOver}, #{PlaneGo}, #{PlaneArrive}, #{ActuallyArrive}, #{FlightBuilding}, " +
            "#{GoDoor}, #{ReadyPos}, #{FlightState})")
    Integer Add(Flight flight);

}
