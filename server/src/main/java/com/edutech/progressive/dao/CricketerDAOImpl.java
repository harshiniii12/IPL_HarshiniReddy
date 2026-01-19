package com.edutech.progressive.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Cricketer;
 
public class CricketerDAOImpl implements CricketerDAO{
    Connection con = DatabaseConnectionManager.getConnection();
 
    @Override
    public int addCricketer(Cricketer cricketer) throws SQLException{
        String sql = "INSERT INTO cricketer (team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cricketer.getTeamId());
            ps.setString(2, cricketer.getCricketerName());
            ps.setInt(3, cricketer.getAge());
            ps.setString(4, cricketer.getNationality());
            ps.setInt(5, cricketer.getExperience());
            ps.setString(6, cricketer.getRole());
            ps.setInt(7, cricketer.getTotalRuns());
            ps.setInt(8, cricketer.getTotalWickets());
 
            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    cricketer.setCricketerId(rs.getInt(1));
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return -1;
    }
 
    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException{
        String sql = "SELECT * FROM cricketer WHERE cricketer_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cricketerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cricketer cricketer = new Cricketer();
                cricketer.setCricketerId(rs.getInt("cricketer_id"));
                cricketer.setTeamId(rs.getInt("team_id"));
                cricketer.setCricketerName(rs.getString("cricketer_name"));
                cricketer.setAge(rs.getInt("age"));
                cricketer.setNationality(rs.getString("nationality"));
                cricketer.setExperience(rs.getInt("experience"));
                cricketer.setRole(rs.getString("role"));
                cricketer.setTotalRuns(rs.getInt("total_runs"));
                cricketer.setTotalWickets(rs.getInt("total_wickets"));
                return cricketer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException{
        String sql = "UPDATE cricketer SET team_id = ?, cricketer_name = ?, age = ?, nationality = ?, experience = ?, role = ?, total_runs = ?, total_wickets = ? WHERE cricketer_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cricketer.getTeamId());
            ps.setString(2, cricketer.getCricketerName());
            ps.setInt(3, cricketer.getAge());
            ps.setString(4, cricketer.getNationality());
            ps.setInt(5, cricketer.getExperience());
            ps.setString(6, cricketer.getRole());
            ps.setInt(7, cricketer.getTotalRuns());
            ps.setInt(8, cricketer.getTotalWickets());
            ps.setInt(9, cricketer.getCricketerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public void deleteCricketer(int cricketerId){
        String sql = "DELETE FROM cricketer WHERE cricketer_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cricketerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // throw e;
        }
    }
 
    @Override
    public List<Cricketer> getAllCricketers() throws SQLException{
        List<Cricketer> cricketers = new ArrayList<>();
        String sql = "SELECT * FROM cricketer";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int cricketerId = resultSet.getInt("cricketer_id");
                int teamId = resultSet.getInt("team_id");
                String cricketerName = resultSet.getString("cricketer_name");
                int age = resultSet.getInt("age");
                String nationality = resultSet.getString("nationality");
                int experience = resultSet.getInt("experience");
                String role = resultSet.getString("role");
                int totalRuns = resultSet.getInt("total_runs");
                int totalWickets = resultSet.getInt("total_wickets");
                cricketers.add(new Cricketer(cricketerId, teamId, cricketerName, age, nationality, experience, role, totalRuns, totalWickets));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cricketers;
    }
 
}