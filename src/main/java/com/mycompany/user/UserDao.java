package com.mycompany.user;

import com.mycompany.repository.Dao;
import com.mycompany.repository.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe UserDao
 *
 * <code>
 * CREATE TABLE user (
 * id bigint unsigned not null AUTO_INCREMENT,
 * nome varchar(150) not null,
 * email varchar(255) not null,
 * senha varchar(64) not null,
 * ultimoAcesso date not null,
 * ativo booleano default true,
 * PRIMARY KEY (`id`)
 * );
 * 
 * </code>
 * @author gusta
 */
public class UserDao extends Dao<User>{
    public static final String TABLE = "user";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(nome, email, senha, ultimoAcesso, ativo)"
                + " values (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set nome = ?, email = ?, senha = ?,"
                + " ultimoAcesso = ?, ativo = ?"
                + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, User e) {
        try {
            pstmt.setString(1, e.getName());
            // OR
            // pstmt.setObject(1, e.getDescription(), java.sql.Types.VARCHAR);

            // Null values
            // NOT! pstmt.setByte(2, e.getProgress());
            pstmt.setString(2, e.getEmail());

            // LocalDate
            pstmt.setString(3, e.getSenha());
            
            pstmt.setTimestamp(4, Timestamp.valueOf(e.getUltimoAcesso()));
            
            pstmt.setBoolean(5, e.isAtivo());

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(6, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, nome, email, senha, ultimoAcesso, ativo"
                + " from "+ TABLE +" where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, nome, email, senha, ultimoAcesso, ativo"
                + " from "+ TABLE;
    }
    
   

    @Override
    public User extractObject(ResultSet resultSet) {

        User user = null;

        try {
            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("nome"));
            user.setEmail(resultSet.getString("email"));
            user.setSenha(resultSet.getString("senha"));
            user.setUltimoAcesso(
                    resultSet.getObject("ultimoAcesso",LocalDateTime.class));
            user.setAtivo(resultSet.getBoolean("ativo"));
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
    
    public List<User> findALLAtivo() {
        
        final String SQL = "select *"
                + " from " + TABLE 
                + " where ativo"
                + " like true";
        
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(SQL)) {

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

}
