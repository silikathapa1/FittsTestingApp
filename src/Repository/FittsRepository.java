/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DatabaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FittsRepository {
   
    
    public static long insertToDetailsTable(String userName, int number_of_trials, int number_of_clicks, Time time, int distanceTravelled){
        try {
            
            Connection dbConnection = DatabaseConnection.dbConnection;
            
            String insertTableSQL = "INSERT INTO details_table"
                    + "(UserName, No_of_trials, No_of_clicks, Time, Distance_travelled,Status) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL,
                    Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, number_of_trials);
            preparedStatement.setInt(3, number_of_clicks);
            preparedStatement.setTime(4, time);
            preparedStatement.setInt(5, distanceTravelled);
            preparedStatement.setInt(6, 1);
            preparedStatement.executeUpdate();
            
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FittsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static long insertToTrialsTable(String userName, int number_of_trials, int number_of_clicks, long time, int distanceTravelled, int circleWidth, int amplitude){
        try {
            //get db connection 
            Connection dbConnection = DatabaseConnection.getConnection();
             String insertTableSQL = "INSERT INTO trails_table"
                    + "(username, trials, clicks, time, distance, CircleWidth, Amplitude) VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL,
                    Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, number_of_trials);
            preparedStatement.setInt(3, number_of_clicks);
            preparedStatement.setLong(4, time);
            preparedStatement.setInt(5, distanceTravelled);
            preparedStatement.setInt(6, circleWidth);
            preparedStatement.setInt(7, amplitude);
            preparedStatement.executeUpdate();
            
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FittsRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NullPointerException e){
            System.out.println("Null pointer exception");
        }
        return 0;
    }   
    
    
    
}
