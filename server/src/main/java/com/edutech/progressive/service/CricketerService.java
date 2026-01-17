
package com.edutech.progressive.service;
 
import com.edutech.progressive.entity.Cricketer;
 
import java.sql.SQLException;

import java.util.List;
 
public interface CricketerService {
 
    List<Cricketer> getAllCricketers()throws SQLException;
 
    Integer addCricketer(Cricketer cricketer)throws SQLException;
 
    List<Cricketer> getAllCricketersSortedByExperience()throws SQLException;
 
    default void emptyArrayList() {

    }
 
    //Do not implement these methods in CricketerServiceImplArraylist.java class

    default void updateCricketer(Cricketer cricketer) {}
 
    default void deleteCricketer(int cricketerId) {}
 
    default Cricketer getCricketerById(int cricketerId) {

        return null;

    }
 
    //Do not implement these methods in CricketerServiceImplArraylist.java and CricketerServiceImplJdbc.java class

    default List<Cricketer> getCricketersByTeam(int teamId) {

        return null;

    }
 
}

 
