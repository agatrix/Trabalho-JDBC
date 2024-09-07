package com.mycompany.repository;

import com.mycompany.entity.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author gusta
 */
public interface IDao<T extends Entity> {

    // Save
    public String getSaveStatment();

    public String getUpdateStatment();

    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, T e);

    public Long saveOrUpdate(T e);

    // Get by ID
    public String getFindByIdStatment();

    public T findById(Long id);

    // Get all
    public String getFindAllStatment();

    public List<T> findAll();

    // Trash
    public String getMoveToTrashStatement();
    public void moveToTrash(T e);

    public String getRestoreFromTrashStatement();
    public void restoreFromTrash(Long id); // OU T e

    public String getFindAllOnTrashStatement();
    public List<T> findAllOnTrash();

    // Assembly objects
    public T extractObject(ResultSet resultSet);

    public List<T> extractObjects(ResultSet resultSet);

}
