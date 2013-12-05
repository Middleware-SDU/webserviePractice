package cn.edu.sdu.webservice.ejbcontainer.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cn.edu.sdu.webservice.ejbcontainer.module.User;


/**
 * 
 * @author Yonggang Yuan
 *
 */

@Stateless
@Remote(UserService.class)

@WebService(
    name="UserService"
    , serviceName="UserService"
    , portName="UserServicePort"
    , targetNamespace="http://ejbcontainer.webservice.sdu.edu.cn/"
)
public class UserServiceBean implements UserService {

    @PersistenceContext(unitName="account") protected EntityManager em;

    @Override
    public void save(User entity) {
        em.persist(entity);
    }

    @Override
    public User update(User entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(Object entityId) {
        em.remove(em.getReference(User.class, entityId));
    }

    @Override
    public User find(Object entityId) {
        return em.find(User.class, entityId);
    }

}
