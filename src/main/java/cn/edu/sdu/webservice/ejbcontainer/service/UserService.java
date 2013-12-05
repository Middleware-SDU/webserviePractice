package cn.edu.sdu.webservice.ejbcontainer.service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import cn.edu.sdu.webservice.ejbcontainer.module.User;


/**
 * 
 * @author Yonggang Yuan
 *
 */

@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public interface UserService {

    /**
     * 保存一个实体
     * @param entity
     */
    public void save(User entity);

    /**
     * 更新一个实体
     * @param entity
     * @return 
     */
    public User update(User entity);

    /**
     * 删除一个实体
     * @param entityid 实体ID
     */
    public void delete(Object entityid);

    /**
     * 根据实体的ID获得实体
     * @param <T>
     * @param entityId实体id
     * @return
     */
    public User find(Object entityId);

}
