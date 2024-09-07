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
        
        try{
            u1 = new User("marcos","h@mail.cm","123",LocalDateTime.now());

            System.out.println(u1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        if(u1 != null){
            new UserDao().saveOrUpdate(u1);
            System.out.println(new UserDao().findById(1L));
        }
        
    }
}
