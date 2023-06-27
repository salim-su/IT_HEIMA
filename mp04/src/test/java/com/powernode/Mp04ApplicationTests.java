package com.powernode;

import com.powernode.domain.User;
import com.powernode.service.impl.UserServiceImpl;
import com.powernode.service.impl.UserServiceImpl2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mp04ApplicationTests {
        @Autowired
        private UserServiceImpl userService1;

        @Autowired
        private UserServiceImpl2 userService2;

        @Test
        public void select1(){
            User user = userService1.getById(1L);
            System.out.println(user);
        }

        @Test
        public void select2(){
            User user = userService2.getById(1L);
            System.out.println(user);
        }
}
