package com.revature.daos;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//This Class is responsible for all things ROLE DATA. (RoleDAO == Role Data Access Object)
//This Class will access/query the roles table in the DB.
public class RoleDAO implements RoleDAOInterface{

    @Override
    public Role getRoleById(int id) {

        //use a try-with-resources block to open the connection or our Database
        try(Connection conn = ConnectionUtil.getConnection()){

            /*We need a String that holds the SQL command we want to run on the DB.
             This String has a wildcard/parameter/variable for the role_id (the ?)
             We have to take the user-inputted role id and put it into this wildcard*/
            String sql = "SELECT * FROM roles WHERE role_id = ?";

            //We need a PreparedStatement object to fill the wildcard in. (fill the ?)
            //PreparedStatements "prepare" a sql command before we send it to the database
            PreparedStatement ps = conn.prepareStatement(sql);

            //here, we are inserting a value for the ? wildcard
            //This is saying "The first wildcard will get filled by the id variable)
            ps.setInt(1, id);

            /*Here, we are execute the fully prepared SQL command that has been stored in the PreparedStatement.
            The results of the Query will be stored in a ResultSet object.*/
            ResultSet rs = ps.executeQuery();

            //rs.next() checks if there is any data in the ResultSet that we haven't accessed yet.
            if(rs.next()) {

                //Extract the Role data from the ResultSet. We need to use the all-args constructor to store all the data
                //to get data out of a ResultSet, we use the rs.get___() methods
                Role role = new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_title"),
                        rs.getInt("role_salary")
                );
                //Remember, this is just a constructor. we opened it up for the sake of cleaner code.

                return role; //return the Role object to the user!

            }

        } catch(SQLException e){
            System.out.println("error getting Role");
            e.printStackTrace(); //remember, printStackTrace() tells us our error message
            //VERY important for debugging, so we know what went wrong and where.
        }

        return null; //null will get returned if something goes wrong

    } //end of getRoleById() method

    @Override
    public boolean updateRoleSalary(int salary, String title) {

        try(Connection conn = ConnectionUtil.getConnection()){

            //Create the SQL String (to be filled with the values from the method parameters)
            String sql = "UPDATE roles SET role_salary = ? where role_title = ?";

            //Instantiate a PreparedStatement to fill in the variable wildcard values
            PreparedStatement ps = conn.prepareStatement(sql);

            //using ps.set___() we can fill the wildcard values in
            ps.setInt(1, salary);
            ps.setString(2, title);

            //execute the update! (We're not getting any data returned, so no need for a ResultSet object)
            ps.executeUpdate();
            //NOTE: executeUpdate() instead of executeQuery(). query is for SELECTS only

            //if we get this far in the try block, we can assume nothing went wrong. return true!
            return true;

        } catch(SQLException e){
            System.out.println("Update failed!!");
            e.printStackTrace(); //this is what gives us an error message in the console
        }

        return false;
    }


}
