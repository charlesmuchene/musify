package validation;

import dev.cstv.musify.domain.User;
import dev.cstv.musify.domain.UserCredentials;
import dev.cstv.musify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class userValidationTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context/applicationContext.xml");
    UserService userService=(UserService) context.getBean("userServiceImpl");

    @Test
    public void testUser(){

        User user=new User();
        user.setFirstName("Steven");
        user.setLastName("Katabalwa");
        user.setUserCredentials(new UserCredentials(user,"ste","pass","email@gmail.com"));

        userService.save(user);

    }

}
