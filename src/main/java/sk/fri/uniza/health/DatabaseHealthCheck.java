package sk.fri.uniza.health;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.hibernate.UnitOfWork;
import sk.fri.uniza.db.DataDAO;
import sk.fri.uniza.db.FieldDAO;
import sk.fri.uniza.db.HouseHoldDAO;
import sk.fri.uniza.db.IotNodeDAO;
import sk.fri.uniza.model.*;

import java.time.LocalDateTime;

public class DatabaseHealthCheck extends HealthCheck {

    private HouseHoldDAO houseHoldDAO;
    private FieldDAO fieldDAO;
    private IotNodeDAO iotNodeDAO;
    private DataDAO dataDAO;

    public DatabaseHealthCheck(HouseHoldDAO houseHoldDAO,
                               IotNodeDAO iotNodeDAO, FieldDAO fieldDAO,
                               DataDAO dataDAO) {
        this.houseHoldDAO = houseHoldDAO;
        this.fieldDAO = fieldDAO;
        this.iotNodeDAO = iotNodeDAO;
        this.dataDAO = dataDAO;
    }

    @Override
    @UnitOfWork
    protected Result check() throws Exception {
//        // Testovanie, či už v databáze neexstuje Household
//        HouseHold holdDAOById = houseHoldDAO.findById((long) 1);
//        if (holdDAOById != null) return Result.healthy();
//        HouseHold houseHold = new HouseHold();
//        houseHold.setCity("Žilina");
//        houseHold.setState("Slovakia");
//        houseHold.setStreet("Okružná");
//        houseHold.setZip("01001");
//        houseHold.setContactPerson(
//                new ContactPerson("Ferko", "Mrkvicka",
//                        "0907888777", "f.mrkvicka@fri.uniza.sk"));
//        houseHold = houseHoldDAO.create(houseHold);

        return Result.healthy();
    }
}
