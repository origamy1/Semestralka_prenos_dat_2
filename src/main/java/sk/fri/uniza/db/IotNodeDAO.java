package sk.fri.uniza.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import sk.fri.uniza.model.Field;
import sk.fri.uniza.model.HouseHold;
import sk.fri.uniza.model.IotNode;

import javax.ws.rs.WebApplicationException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class IotNodeDAO extends AbstractDAO<IotNode> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public IotNodeDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public IotNode create(IotNode iotNode) {
        currentSession().save(iotNode);
        return iotNode;
    }

    public IotNode create(IotNode iotNode, Long id) {
        final HouseHold houseHold = currentSession().get(HouseHold.class, id);
        if(houseHold == null){
            throw new WebApplicationException("Priradene zle ID, alebo prázdny household");


        }
        iotNode.setHouseHold(houseHold);
        currentSession().save(iotNode);
        return iotNode;
    }

    public IotNode findById(Long id) {
        return get(id);
    }

    public IotNode update(IotNode iotNode) {
        return (IotNode) currentSession().merge(iotNode);
    }

    public List<IotNode> findByHouseHold(Long houseHoldId) {
        return list(namedQuery("findBy_Household_Id")
                .setParameter("HouseHold_id", houseHoldId));
    }

    public List<IotNode> allIotNodes() {
        return list(namedQuery("find_All_nodes"));
    }
}
