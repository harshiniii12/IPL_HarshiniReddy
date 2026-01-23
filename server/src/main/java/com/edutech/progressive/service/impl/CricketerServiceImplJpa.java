package com.edutech.progressive.service.impl;
 
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.repository.CricketerRepository;
import com.edutech.progressive.service.CricketerService;
 
@Service
public class CricketerServiceImplJpa implements CricketerService {
 
    private final CricketerRepository cricketerRepository;
 
    @Autowired
    public CricketerServiceImplJpa(CricketerRepository cricketerRepository) {
        this.cricketerRepository = cricketerRepository;
    }
 
    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        return cricketerRepository.findAll();
    }
 
    @Override
    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        return cricketerRepository.save(cricketer).getCricketerId();
    }
 
    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException {
        List<Cricketer> list = cricketerRepository.findAll();
        list.sort(Comparator.comparing(Cricketer::getExperience)); // ascending
        return list;
    }
 
    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException {

        // save acts as update when ID is present
        cricketerRepository.save(cricketer);

    }
 
    @Override
    public void deleteCricketer(int cricketerId) throws SQLException {
        cricketerRepository.deleteById(cricketerId);
    }
 
    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException {
        return cricketerRepository.findByCricketerId(cricketerId).orElse(null);
    }
 
    @Override
    public List<Cricketer> getCricketersByTeam(int teamId) throws SQLException {
        return cricketerRepository.findByTeam_TeamId(teamId);

    }

}

 