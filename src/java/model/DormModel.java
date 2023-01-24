/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author strix
 */
public class DormModel {
    private Connection DBconn;
    private String userCity;
    private int id;
    private int userSpace;
    private String dormName;
    private String address;
    private int addPrice;
    private String dormContact;
    private String dormImage;
    //for find dorm variables
    private int userBudget;
    private int userBudgetMax;
    //for login
    private String username;
    
    public DormModel(Connection con, String user){//constructor for Logging in
        this.DBconn = con;
        this.username = user;
    }
            
    public DormModel(Connection con, int dormId){ //constructor for delete listing
        this.DBconn = con;
        this.id = dormId;
    }
    
    
    public DormModel(Connection con, String city, int budget, int budgetMax, int space){ //constructor for search listing
        this.DBconn = con;
        this.userCity = city;
        this.userBudget = budget;
        this.userBudgetMax = budgetMax;
        this.userSpace = space;

    }
    //constructor for add listing
    public DormModel( Connection con, String dormName, String dormCity, String dormAddress, int roomPrice, int bedSpace, String dormContact, String imageLink){
        this.DBconn = con;
        this.dormName = dormName;
        this.userCity = dormCity;
        this.address = dormAddress;
        this.addPrice = roomPrice;
        this.userSpace = bedSpace;
        this.dormContact = dormContact;
        this.dormImage = imageLink;
    } 
    //constructor for update listing
    public DormModel( Connection con, int dormId, String dormName, String dormCity, String dormAddress, int roomPrice, int bedSpace, String dormContact, String imageLink){
        this.DBconn = con;
        this.id = dormId;
        this.dormName = dormName;
        this.userCity = dormCity;
        this.address = dormAddress;
        this.addPrice = roomPrice;
        this.userSpace = bedSpace;
        this.dormContact = dormContact;
        this.dormImage = imageLink;
    } 
    
    public ResultSet getOutput() throws SQLException{
        String query = "SELECT * FROM dorm_list WHERE dorm_city = ? AND bed_space = ? AND room_price BETWEEN ? AND ?";
        PreparedStatement ps = this.DBconn.prepareStatement(query);
        ps.setString(1, this.userCity);
        ps.setInt(2, this.userSpace);
        ps.setInt(3, this.userBudget);
        ps.setInt(4, this.userBudgetMax);
        ResultSet output = ps.executeQuery();
  
        return output;
    } 
    
    public ResultSet addOutput() throws SQLException{
        String query = "INSERT INTO dorm_list (dorm_name, dorm_city, dorm_address, room_price, bed_space, dorm_contact, image_link)"
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = this.DBconn.prepareStatement(query);
        ps.setString(1, this.dormName);
        ps.setString(2, this.userCity);
        ps.setString(3, this.address);
        ps.setInt(4, this.addPrice);
        ps.setInt(5, this.userSpace);
        ps.setString(6, this.dormContact);
        ps.setString(7, this.dormImage);
        ps.executeUpdate();
        
        String query2 = "SELECT * FROM dorm_list WHERE dorm_city = ? AND BED_SPACE = ? AND ROOM_PRICE = ?";
        PreparedStatement ps2 = this.DBconn.prepareStatement(query2);
        ps2.setString(1, this.userCity);
        ps2.setInt(2, this.userSpace);
        ps2.setInt(3, this.addPrice);
        ResultSet output = ps2.executeQuery();
  
        return output;
    } 
        public ResultSet getAddOutput() throws SQLException{


        String query2 = "SELECT * FROM dorm_list WHERE dorm_city = ? AND bed_space = ? AND room_price = ?";
        PreparedStatement ps2 = this.DBconn.prepareStatement(query2);
        ps2.setString(1, this.userCity);
        ps2.setInt(2, this.userSpace);
        ps2.setInt(3, this.addPrice);
        ResultSet output = ps2.executeQuery();
  
        return output;
    } 
    
        public int deleteListing() throws SQLException{
        
            String query = "DELETE FROM dorm_list WHERE dorm_id = ?";
            PreparedStatement ps = this.DBconn.prepareStatement(query);
            ps.setInt(1, this.id);
            
            
            ps.executeUpdate();
            
            return 1;
        }
        
        public ResultSet updateOutput() throws SQLException{
        String query = "UPDATE dorm_list SET dorm_name = ?, dorm_city = ?, dorm_address = ?, room_price = ?, bed_space = ?, dorm_contact = ?, image_link = ? WHERE dorm_id = ?";
        PreparedStatement ps = this.DBconn.prepareStatement(query);
        ps.setString(1, this.dormName);
        ps.setString(2, this.userCity);
        ps.setString(3, this.address);
        ps.setInt(4, this.addPrice);
        ps.setInt(5, this.userSpace);
        ps.setString(6, this.dormContact);
        ps.setString(7, this.dormImage);
        ps.setInt(8, this.id);

        ps.executeUpdate();
        
        String query2 = "SELECT * FROM dorm_list WHERE dorm_id = ?";
        PreparedStatement ps2 = this.DBconn.prepareStatement(query2);
        ps2.setInt(1, this.id);
        ResultSet output = ps2.executeQuery();
  
        return output;
    } 
    public ResultSet getUpdateOutput() throws SQLException{

        
        String query = "SELECT * FROM dorm_list WHERE dorm_id = ?";
        PreparedStatement ps = this.DBconn.prepareStatement(query);
        ps.setInt(1, this.id);
        ResultSet output = ps.executeQuery();

  
        return output;
    }
    
    public Boolean getUser() throws SQLException{
         try
        {
            String query = "SELECT username FROM accounts";
            Statement stmt = this.DBconn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                String uname = rs.getString("username");
                if(!uname.equals(this.username))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
         return false;
        
    }
        
    public ResultSet getPass() throws SQLException{
        String query = "SELECT * FROM dorm_user WHERE username = ?";
        PreparedStatement ps = this.DBconn.prepareStatement(query);
        ps.setString(1, this.username);

        ResultSet output = ps.executeQuery();
  
        return output;
    }
}
