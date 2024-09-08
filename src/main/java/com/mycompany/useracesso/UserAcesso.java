package com.mycompany.useracesso;

import com.mycompany.user.User;
import com.mycompany.user.UserDao;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Classe main
 * @author gusta
 */
public class UserAcesso {

    public static void main(String[] args) {
        OffsetDateTime.now(ZoneOffset.UTC);
        User A = null;
        User B = null;
        User C = null;
        User D = null;
        User E = null;
        User F = null;
        
        try{
            A = new User("Ana Zaira","a.zaira@mail.com","123",
                    LocalDateTime.of(
                        (LocalDate.now().minusDays(1L)),(LocalTime.of(17, 0))));
            new UserDao().saveOrUpdate(A);
            
            B = new User("Beatriz Yana","b.yana@mail.com","456",
                    LocalDateTime.of((LocalDate.now()),(LocalTime.of(3,0))));
            new UserDao().saveOrUpdate(B);
            
            C = new User("Cecilia Xerxes","c.xerxes@mail.com","789",
                    LocalDateTime.of(
                            (LocalDate.now().minusDays(2L)),(LocalTime.of(12,0))));
            new UserDao().saveOrUpdate(C);
            
            //User D podemos criar passando data como NUll e define ativo como false
            //D = new User("Debora Wendel","d.wendel@mail.cm","147",null);
            //Ou adicionando um por um, não colocar a data define como NULL
            D = new User();
            D.setName("Debora Wendel");
            D.setEmail("debora.w@mail.com");
            D.setSenha("147");
            D.setAtivo(false);
            new UserDao().saveOrUpdate(D);
            
            E = new User("Eugenia Vale","e.vale@mail.com","258",
                    LocalDateTime.of((LocalDate.now()),(LocalTime.of(6,0))));
            new UserDao().saveOrUpdate(E);
            
            F = new User("Fernanda Uchoa","f.uchoa@mail.com","369",
                    LocalDateTime.of(
                        (LocalDate.now().minusDays(1L)),(LocalTime.of(23,59))));
            F.setAtivo(false);
            new UserDao().saveOrUpdate(F);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        if(A != null){
              A.setUltimoAcesso(LocalDateTime.now());
              new UserDao().saveOrUpdate(A);
//            
//            new UserDao().excluirUserbyID(3L);
//            System.out.println(new UserDao().findALLAtivo());
        }
        if(C != null){
            C.setAtivo(false);
            new UserDao().saveOrUpdate(C);
        }
        if(D != null){
            D.setEmail("d.wendel@mail.com");
            D.setSenha("&Yh4$Wu9");
            new UserDao().saveOrUpdate(D);
        }
        if(E != null){
            E.setUltimoAcesso(LocalDateTime.now());
            E.setSenha("&asdfqwerty");
            new UserDao().saveOrUpdate(E);
        }
        
        System.out.println("Impressão do 3º Elemento:");
        System.out.println(new UserDao().findById(3L));
        System.out.println("Impressão de Todos:");
        System.out.println(new UserDao().findAll());
        System.out.println("Impressão de Todos Ativos = True:");
        System.out.println(new UserDao().findALLAtivo());
        
        new UserDao().excluirUserbyID(4L);
    }
}
