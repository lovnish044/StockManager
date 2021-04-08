/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmanager.BO;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class OrdersBO {

    int id, totalprice, quantity, customer;

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }
    ItemBO item;
    LocalDate dateoforder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemBO getItem() {
        return item;
    }

    public void setItem(ItemBO item) {
        this.item = item;
    }

    public LocalDate getDateoforder() {
        return dateoforder;
    }

    public void setDateoforder(LocalDate dateoforder) {
        this.dateoforder = dateoforder;
    }

    public String getORDERSTATUS() {
        return ORDERSTATUS;
    }

    public void setORDERSTATUS(String ORDERSTATUS) {
        this.ORDERSTATUS = ORDERSTATUS;
    }
    String ORDERSTATUS;

}
