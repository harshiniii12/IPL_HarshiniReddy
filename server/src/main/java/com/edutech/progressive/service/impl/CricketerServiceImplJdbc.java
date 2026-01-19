package com.edutech.progressive.service.impl;
 
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
 
import com.edutech.progressive.dao.CricketerDAO;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;
 
public class CricketerServiceImplJdbc implements CricketerService {
    private CricketerDAO cricketerDAO;
 
    public CricketerServiceImplJdbc(CricketerDAO cricketerDAO) {
        this.cricketerDAO = cricketerDAO;
    }
 
    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        try {
            return cricketerDAO.getAllCricketers();
        } catch (SQLException e) {
            throw e;
        }
    }
 
    @Override
    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        try {
            return cricketerDAO.addCricketer(cricketer);
        } catch (SQLException e) {
            throw e;
        }
    }
 
    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException {
        try {
            List<Cricketer> sortCricketers = cricketerDAO.getAllCricketers();
            Collections.sort(sortCricketers);
            return sortCricketers;
        } catch (SQLException e) {
            throw e;
        }
    }
 
    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException {
        try {
            cricketerDAO.updateCricketer(cricketer);
        } catch (SQLException e) {
            throw e;
        }
    }
 
    @Override
    public void deleteCricketer(int cricketerId) throws SQLException {
        try {
            cricketerDAO.deleteCricketer(cricketerId);
        } catch (SQLException e) {
            throw e;
        }
    }
 
    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException {
        try {
            return cricketerDAO.getCricketerById(cricketerId);
        } catch (SQLException e) {
            throw e;
        }
    }
 
}