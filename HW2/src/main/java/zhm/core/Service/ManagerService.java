package zhm.core.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import zhm.core.Dao.ManagerDao;
import zhm.core.domain.Baggage;
import zhm.core.domain.Flight;
import zhm.core.domain.Manager;

public interface ManagerService {

    public boolean isLogin(Manager manager);

}