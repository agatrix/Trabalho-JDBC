package com.mycompany.useracesso;

import com.mycompany.user.User;
import com.mycompany.user.UserDao;
import java.time.LocalDateTime;

/**
 * Classe main
 * @author gusta
 */
public class UserAcesso {

    public static void main(String[] args) {
    
        User u1 = null;
        User u2 = null;
        
        try{
            u1 = new User("heuller","h@mail.cm","123",LocalDateTime.now());
            u1.setId(1L);
            u1.setAtivo(false);
            u2 = new User("marcos","m@mail.cm","435",LocalDateTime.of(2023, 9, 7, 14, 30));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        if(u1 != null){
            new UserDao().saveOrUpdate(u1);
            System.out.println(new UserDao().findALLAtivo());
        }
        
    }
}
