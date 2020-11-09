package zhm.core.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import zhm.core.domain.Baggage;

import java.util.List;
import zhm.core.domain.Baggage;

@Repository("baggageDao")
public interface BaggageDao {

    @Insert("insert into Baggage" +
            "(FlightID, FlightCompany, ActuallyArrive, BaggagePos) " +
            "value(#{FlightID}, #{FlightCompany}, #{ActuallyArrive}, #{BaggagePos})")
    void Add(Baggage baggage);

    @Select("select * from Baggage")
    List<Baggage> getAllList();
}
