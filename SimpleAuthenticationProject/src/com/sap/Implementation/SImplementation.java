package com.sap.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.sap.Bean.RegisterBean;
import com.sap.Database.DatabaseConnection;
import com.sap.Interface.SInterface;

public class SImplementation implements SInterface {
    Connection con;

    @Override
    public int register(RegisterBean rb) {
        int result = 0;
        try {
            // Establishing the connection
            con = DatabaseConnection.createConnection();

            // SQL query for inserting data into the register table
            PreparedStatement ps = con.prepareStatement("INSERT INTO register VALUES(?,?,?,?,?,?)");

            // Setting the values from RegisterBean object
            ps.setInt(1, rb.getId());
            ps.setString(2, rb.getName());
            ps.setString(3, rb.getUsername());
            ps.setString(4, rb.getPassword());
            ps.setString(5, rb.getEmail());
            ps.setString(6, rb.getMobile());

            // Executing the update
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close(); // Close the connection
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}
}