package com.mycompany.user;

import com.mycompany.repository.Dao;
import com.mycompany.repository.DbConnection;
import com.mycompany.user.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        return "insert into " + TABLE + "(nome, email, senha, ultimoAcesso, ativo)  values (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set descricao = ?, progresso = ?, conclusao = ? where id = ?";
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
            
            pstmt.setObject(4,e.getUltimoAcesso(), java.sql.Types.DATE);
            
            pstmt.setBoolean(5, e.isAtivo());

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(4, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, descricao, progresso, conclusao, excluido"
                + " from tarefa where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, descricao, progresso, conclusao, excluido"
                + " from tarefa"
                + " where exlcuido = false";
    }

    @Override
    public String getMoveToTrashStatement() {
        return "update " + TABLE + " set excluido = true"
                + " where id = ?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "update " + TABLE + " set excluido = false"
                + " where id = ?";
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "select * from " + TABLE + " where excluido = true";
    }

    @Override
    public User extractObject(ResultSet resultSet) {

        User user = null;

        try {
            user = new User();
            user.setId(resultSet.getLong("id"));
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    public List<User> findByProgressLessThan20() {
        
        final String SQL = "select *"
                + " from " + TABLE 
                + " where progresso < 20";
        
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

    public List<User> findByDescription(String description) {
        
        final String SQL = "select *"
                + " from " + TABLE 
                + " where descricao"
                + " like ?";
        
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(SQL)) {

            preparedStatement.setString(1, "%" + description + "%");

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

    @Override
    public void moveToTrash(User e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void restoreFromTrash(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> findAllOnTrash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
