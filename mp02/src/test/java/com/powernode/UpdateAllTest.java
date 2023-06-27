package com.powernode;

import com.powernode.domain.User;
import com.powernode.enums.GenderEnum;
import com.powernode.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateAllTest {

    @Autowired
    private UserService userService;

    @Test
    public void updateAll(){
//        User user = new User();
//        user.setGender(GenderEnum.MAN);
//
//        userService.saveOrUpdate(user,null);
    }
}
