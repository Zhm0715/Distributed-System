package zhm.core.Service.Imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zhm.core.Dao.BaggageDao;
import zhm.core.Dao.FlightDao;
import zhm.core.Dao.ManagerDao;
import zhm.core.Service.ManagerService;
import zhm.core.domain.Baggage;
import zhm.core.domain.Flight;
import zhm.core.domain.Manager;

// @service交给IOC
// @Configurable和@Bean也可以达到相同的效果
@Service("managerService")
public class ManagerServiceImple implements ManagerService {

    @Qualifier("managerDao")
    @Autowired
    private ManagerDao managerDao;

    public ManagerDao getManagerDao() {
        return managerDao;
    }

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public boolean isLogin(Manager manager) {
        return this.managerDao.existManager(manager);
    }
}
