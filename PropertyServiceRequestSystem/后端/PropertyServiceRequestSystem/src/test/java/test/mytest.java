package test;

import com.gdpu.PropertyServiceRequestSystem;
import com.gdpu.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PropertyServiceRequestSystem.class)
public class mytest {


    @Autowired
    private JwtHelper jwtHelper;
    @Test
    public void createToken(){
        String token = jwtHelper.createToken(Long.valueOf("10"));
        System.out.println("token = " + token);
    }
}
