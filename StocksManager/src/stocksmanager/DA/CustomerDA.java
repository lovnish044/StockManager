/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmanager.DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import stocksmanager.BO.CustomerBO;

/**
 *
 * @author DELL
 */
public class CustomerDA extends AbstractDao {

    public static Connection conn = getConnection();

    public static void add(CustomerBO customer) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into customer (id,name,address,mobile,email,gender) values (?,?,?,?,?,?)");
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());

            ps.setString(3, customer.getAddress());
            ps.setLong(4, customer.getMobile());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getGender());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void update(CustomerBO customer) {
        try {
            PreparedStatement ps = conn.prepareStatement("update customer set name=?, address=?,mobile=?, email=?, gender=? where id=? ");

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setLong(3, customer.getMobile());
            ps.setString(4, customer.getEmail());
            ps.setInt(6, customer.getId());
            ps.setString(5, customer.getGender());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void delete(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from customer where id=? ");

            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static CustomerBO getById(int id) {
        CustomerBO customer = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Select  id,name,address,mobile,email,gender from customer where id=? ");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new CustomerBO();
                customer.setAddress(rs.getString(3));
                customer.setMobile(rs.getInt(4));
                customer.setName(rs.getString(2));
                customer.setEmail(rs.getString(5));
                customer.setGender(rs.getString(6));
                customer.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return customer;
    }

    public static CustomerBO getLogin(int id, String Name) {
        CustomerBO customer = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Select  id,name,address,mobile,email,gender from customer where id=? and name=?");

            ps.setInt(1, id);
            ps.setString(2, Name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new CustomerBO();
                customer.setAddress(rs.getString(3));
                customer.setMobile(rs.getInt(4));
                customer.setName(rs.getString(2));
                customer.setEmail(rs.getString(5));
                customer.setGender(rs.getString(6));
                customer.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return customer;
    }

    public static ArrayList getAll() {
        ArrayList customers = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("Select  id,name,address,mobile,email,gender from customer");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerBO customer = new CustomerBO();
                customer.setAddress(rs.getString(3));
                customer.setMobile(rs.getInt(4));
                customer.setName(rs.getString(2));
                customer.setEmail(rs.getString(5));
                customer.setGender(rs.getString(6));
                customer.setId(rs.getInt(1));
                customers.add(customer);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return customers;
    }

}
