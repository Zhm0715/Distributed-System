package zhm.DAO;

import domain.Baggage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Mapper
public interface BaggageDao {

    @Insert("insert into Baggage" +
            "(FlightID, FlightCompany, ActuallyArrive, BaggagePos) " +
            "value(#{FlightID}, #{FlightCompany}, #{ActuallyArrive}, #{BaggagePos})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")       // 主键返回
    Integer Add(Baggage baggage);

}
