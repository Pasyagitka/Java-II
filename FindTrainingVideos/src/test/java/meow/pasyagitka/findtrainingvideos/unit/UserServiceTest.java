package meow.pasyagitka.findtrainingvideos.unit;

import meow.pasyagitka.findtrainingvideos.service.UserService;
import org.hibernate.service.spi.ServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void existsUserByLogin() throws Exception{
        Assert.assertNotNull(userService.getByLogin("pasyagitka"));
    }

    @Test
    public void existsUserByLoginAndPassword() throws Exception{
        Assert.assertNotNull(userService.findByLoginAndPassword("pasyagitka","pasyagitka"));
    }
    @Test
    public void notExistsUserByLoginAndPassword() throws Exception{
        Assert.assertNull(userService.findByLoginAndPassword("pasyagitka","pasyagitka1"));
    }
    @Test
    public void getEmailsList() throws Exception{
        Assert.assertTrue(userService.getEmails().contains("lizavetazinovich@gmail.com"));
    }

}