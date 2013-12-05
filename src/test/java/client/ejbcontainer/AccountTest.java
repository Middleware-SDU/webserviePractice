package client.ejbcontainer;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.edu.sdu.webservice.ejbcontainer.module.User;
import cn.edu.sdu.webservice.ejbcontainer.service.UserService;

/**
 * Test webservice of EJB container
 * @author Yonggang Yuan
 *
 */

public class AccountTest {

    /* 纯属为了测试，因为hibernate4会控制MySQL的自动主键递增 */
    public static final int FIRST_ID = 21;

    static UserService userService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        UserServiceClient at = new UserServiceClient();
        userService = at.getManagerWebServicePort();
    }

    @Test
    public void testSave() {
        System.out.println("测试注册账户：-----------------------------");
        for(int i=0; i<10; i++) {
            System.out.println("注册账户：Yonggan-" + i);
            userService.save(new User("Yonggan-" + i, 100.00));
        }
    }

    @Test
    public void testFind() {
        System.out.println("测试查询余额：-----------------------------");
        User u = userService.find(FIRST_ID);
        System.out.println(u.getName() + "的余额是：" + u.getBalance());
    }

    @Test
    public void testUpdate() {
        System.out.println("测试存款：");
        User u = userService.find(FIRST_ID);
        System.out.println(u.getName() + "存款之前的余额：" + u.getBalance());
        System.out.println("往" + u.getName() + "存款100.00元！");
        System.out.println("往" + u.getName() + "存款之后的余额：" + u.deposit(100.00));
        userService.update(u);

        System.out.println("测试取款：");
        System.out.println(u.getName() + "取款之前的余额：" + u.getBalance());
        System.out.println("从" + u.getName() + "取款50.00元！");
        System.out.println("从" + u.getName() + "取款之后的余额：" + u.draw(50.0));
        userService.update(u);

        System.out.println("经过存取操作之后的余额：" + userService.find(FIRST_ID).getBalance());
    }

    @Test
    public void testDelete() {
        
    }

}
