package com.mycompany.useracesso;

import com.mycompany.user.User;
import com.mycompany.user.UserDao;
import java.time.LocalDate;

/**
 * Classe main
 * @author gusta
 */
public class UserAcesso {

    public static void main(String[] args) {
    
        User u1 = null;
        
        try{
            u1 = new User("marcos","h@mail.cm","123",LocalDate.now());
            u1.setId(1L);
            System.out.println(u1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        if(u1 != null){
            new UserDao().saveOrUpdate(u1);
        }
        
    }
}
