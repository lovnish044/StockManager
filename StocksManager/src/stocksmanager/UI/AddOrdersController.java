/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmanager.UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import stocksmanager.BO.CustomerBO;
import stocksmanager.BO.ItemBO;
import stocksmanager.BO.OrdersBO;
import stocksmanager.DA.CustomerDA;
import stocksmanager.DA.ItemDA;
import stocksmanager.DA.OrdersDA;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AddOrdersController implements Initializable {

    @FXML
    private JFXRadioButton rbAdd;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtItem;
    @FXML
    private JFXTextField txtTotal;
    @FXML
    private JFXTextField txtQuantity;
    @FXML
    private JFXTextField txtOrder;
    @FXML
    private JFXRadioButton rbUpdate;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private DatePicker dpDateOfOrder;
    @FXML
    private JFXTextField txtC_id;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtMrp;
    @FXML
    private JFXTextField txtUnit_price;
    @FXML
    private JFXTextField txtCname;
    @FXML
    private JFXTextField txtMobile;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXComboBox cbItems;
    @FXML
    private ImageView ivItemImage;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ToggleGroup tg = new ToggleGroup();
        rbAdd.setToggleGroup(tg);
        rbUpdate.setToggleGroup(tg);
        if (stocksmanager.StocksManager.customer != null) {
            txtC_id.setText("" + stocksmanager.StocksManager.customer.getId());
            txtCname.setText("" + stocksmanager.StocksManager.customer.getName());
            txtMobile.setText("" + stocksmanager.StocksManager.customer.getMobile());
            txtEmail.setText("" + stocksmanager.StocksManager.customer.getEmail());

            txtId.setDisable(true);
            rbAdd.setDisable(true);
            rbUpdate.setDisable(true);
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
        }
        cbItems.getItems().addAll(ItemDA.getAll());

    }

    @FXML
    private void add(ActionEvent event) {
        OrdersBO orders = new OrdersBO();
        orders.setDateoforder(dpDateOfOrder.getValue());
        orders.setItem(ItemDA.getById(Integer.parseInt(txtItem.getText())));
        orders.setId(Integer.parseInt(txtId.getText()));
        orders.setQuantity(Integer.parseInt(txtQuantity.getText()));
        orders.setTotalprice(Integer.parseInt(txtTotal.getText()));
        orders.setORDERSTATUS(txtOrder.getText());
        orders.setCustomer(Integer.parseInt(txtC_id.getText()));

        int stock_qty = ItemDA.getById(Integer.parseInt(txtItem.getText())).getQty();
        int qty = Integer.parseInt(txtQuantity.getText());
        int new_qty = stock_qty - qty;
        if (new_qty > 0) {
            ItemDA.UpdateQuantityById(ItemDA.getById(Integer.parseInt(txtItem.getText())).getId(), new_qty);
            OrdersDA.add(orders);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("unavailable quantity");
            alert.showAndWait();
        }

    }

    @FXML
    private void update(ActionEvent event) {
        OrdersBO orders = new OrdersBO();
        orders.setDateoforder(dpDateOfOrder.getValue());
        orders.setItem(ItemDA.getById(Integer.parseInt(txtItem.getText())));
        orders.setId(Integer.parseInt(txtId.getText()));
        orders.setQuantity(Integer.parseInt(txtQuantity.getText()));
        orders.setTotalprice(Integer.parseInt(txtTotal.getText()));
        orders.setORDERSTATUS(txtOrder.getText());
        orders.setCustomer(Integer.parseInt(txtC_id.getText()));
        OrdersDA.update(orders);
    }

    @FXML
    private void delete(ActionEvent event) {
        OrdersDA.delete(Integer.parseInt(txtId.getText()));
    }

    @FXML
    private void getById(ActionEvent event) {
        OrdersBO orders = OrdersDA.getById(Integer.parseInt(txtId.getText()));
        dpDateOfOrder.setValue(orders.getDateoforder());
        txtItem.setText(String.valueOf(orders.getItem().getId()));
        txtQuantity.setText(String.valueOf(orders.getQuantity()));
        txtTotal.setText(String.valueOf(orders.getTotalprice()));
        txtOrder.setText(String.valueOf(orders.getORDERSTATUS()));
        txtId.setText(String.valueOf(orders.getId()));
        txtC_id.setText(String.valueOf(orders.getCustomer()));
    }

    @FXML
    private void getItemById(ActionEvent event) {
        ItemBO item = ItemDA.getById(Integer.parseInt(txtItem.getText()));
        txtName.setText(item.getName());
        txtMrp.setText(String.valueOf(item.getMrp()));
        txtUnit_price.setText(String.valueOf(item.getUnit_price()));

    }

    @FXML
    private void getCustomerById(ActionEvent event) {
        CustomerBO customer = CustomerDA.getById(Integer.parseInt(txtC_id.getText()));
        txtCname.setText(customer.getName());
        txtMobile.setText(String.valueOf(customer.getMobile()));
        txtEmail.setText(customer.getEmail());

    }

    @FXML
    private void rbAddClick(ActionEvent event) {
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnAdd.setDisable(false);
    }

    @FXML
    private void rbUPDATEClick(ActionEvent event) {
        btnAdd.setDisable(true);
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
    }

    @FXML
    private void populateItem(ActionEvent event) {
        ItemBO item = (ItemBO) cbItems.getSelectionModel().getSelectedItem();

        txtId.setText(String.valueOf(item.getId()));
        txtName.setText(item.getName());
        txtUnit_price.setText(String.valueOf(item.getUnit_price()));
        txtMrp.setText(String.valueOf(item.getMrp()));
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\DELL\\Desktop\\pics\\" + item.getName() + ".jpg");
            Image image = new Image(in);
            ivItemImage.setImage(image);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
