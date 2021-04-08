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
import stocksmanager.BO.ItemBO;

/**
 *
 * @author DELL
 */
public class ItemDA extends AbstractDao {

    public static Connection conn = getConnection();

    public static void add(ItemBO item) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into item (id,name,quantity,unit_price,Manufacturer,mrp) values (?,?,?,?,?,?)");
            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setInt(3, item.getQty());
            ps.setFloat(4, item.getUnit_price());
            ps.setString(5, item.getManufacturer());
            ps.setFloat(6, item.getMrp());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void update(ItemBO item) {
        try {
            PreparedStatement ps = conn.prepareStatement("update item set name=?,quantity=?,unit_price=?,Manufacturer=?,mrp=? where id=? ");

            ps.setString(1, item.getName());
            ps.setInt(2, item.getQty());
            ps.setFloat(3, item.getUnit_price());
            ps.setString(4, item.getManufacturer());
            ps.setFloat(5, item.getMrp());
            ps.setInt(6, item.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from item where id=?");

            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static ItemBO getById(int id) {
        ItemBO item = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Select  id,name,quantity,unit_price,Manufacturer,mrp  from item where id=? ");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item = new ItemBO();
                item.setQty(rs.getInt(3));
                item.setUnit_price(rs.getFloat(4));
                item.setName(rs.getString(2));
                item.setManufacturer(rs.getString(5));
                item.setMrp(rs.getFloat(6));
                item.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return item;
    }

    public static ArrayList getAll() {
        ArrayList items = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("Select  id,name,quantity,unit_price,Manufacturer,mrp  from item  ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ItemBO item = new ItemBO();
                item.setQty(rs.getInt(3));
                item.setUnit_price(rs.getFloat(4));
                item.setName(rs.getString(2));
                item.setManufacturer(rs.getString(5));
                item.setMrp(rs.getFloat(6));
                item.setId(rs.getInt(1));
                items.add(item);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return items;
    }

    public static void UpdateQuantityById(int id, int quantity) {
        try {
            PreparedStatement ps = conn.prepareStatement("update item set quantity=? where id=? ");
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
