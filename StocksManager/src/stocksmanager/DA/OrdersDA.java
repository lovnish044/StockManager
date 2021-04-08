/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmanager.DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import stocksmanager.BO.OrdersBO;

/**
 *
 * @author DELL
 */
public class OrdersDA extends AbstractDao {

    public static Connection conn = getConnection();

    public static void add(OrdersBO orders) {
        System.out.println("...............");
        try {
            PreparedStatement ps = conn.prepareStatement("insert into orders (id,item_id,dateoforder,totalprice,quantity,ORDERSTATUS,customer_id) values (?,?,?,?,?,?,?)");
            ps.setInt(1, orders.getId());
            ps.setInt(2, orders.getItem().getId());
            ps.setString(3, orders.getDateoforder().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            ps.setInt(4, orders.getTotalprice());
            ps.setInt(5, orders.getQuantity());
            ps.setString(6, orders.getORDERSTATUS());
            ps.setInt(7, orders.getCustomer());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void update(OrdersBO orders) {
        System.out.println("...............");
        try {
            PreparedStatement ps = conn.prepareStatement("update orders set item_id=?,dateoforder=?,totalprice=?,quantity=?,ORDERSTATUS=?,customer_id=?  where id=? ");
            ps.setInt(1, orders.getItem().getId());
            ps.setString(2, orders.getDateoforder().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            ps.setInt(3, orders.getTotalprice());
            ps.setInt(4, orders.getQuantity());
            ps.setString(5, orders.getORDERSTATUS());
            ps.setInt(6, orders.getId());
            ps.setInt(7, orders.getCustomer());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void delete(int id) {

        try {
            PreparedStatement ps = conn.prepareStatement("delete from orders where  id=?");

            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static OrdersBO getById(int id) {
        OrdersBO orders = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Select  id,item_id,dateoforder,totalprice,quantity,ORDERSTATUS,customer_id  from orders where id=? ");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders = new OrdersBO();
                orders.setId(rs.getInt(1));
                orders.setItem(ItemDA.getById(rs.getInt(2)));
                orders.setDateoforder(LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                orders.setTotalprice(rs.getInt(4));
                orders.setQuantity(rs.getInt(5));
                orders.setORDERSTATUS(rs.getString(6));
                orders.setCustomer(rs.getInt(7));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return orders;
    }

    public static ArrayList getAll() {
        ArrayList or = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("Select  id,item_id,dateoforder,totalprice,quantity,ORDERSTATUS,customer_id  from orders");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrdersBO orders = new OrdersBO();
                orders.setId(rs.getInt(1));
                orders.setItem(ItemDA.getById(rs.getInt(2)));
                orders.setDateoforder(LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                orders.setTotalprice(rs.getInt(4));
                orders.setQuantity(rs.getInt(5));
                orders.setORDERSTATUS(rs.getString(6));
                orders.setCustomer(rs.getInt(7));
                or.add(orders);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return or;
    }

    public static ArrayList getAllbyCustomerId(int customer_id) {
        ArrayList or = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("Select  id,item_id,dateoforder,totalprice,quantity,ORDERSTATUS from orders where customer_id=?");
            ps.setInt(1, customer_id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrdersBO orders = new OrdersBO();
                orders.setId(rs.getInt(1));
                orders.setItem(ItemDA.getById(rs.getInt(2)));
                orders.setDateoforder(LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                orders.setTotalprice(rs.getInt(4));
                orders.setQuantity(rs.getInt(5));
                orders.setORDERSTATUS(rs.getString(6));
                or.add(orders);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return or;
    }
}
