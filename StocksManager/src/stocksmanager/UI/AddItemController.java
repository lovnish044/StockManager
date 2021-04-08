/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmanager.UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import stocksmanager.BO.ItemBO;
import stocksmanager.DA.ItemDA;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AddItemController implements Initializable {

    @FXML
    private AnchorPane txtID;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtQuantity;
    @FXML
    private JFXTextField txtUnit_Price;
    @FXML
    private JFXTextField txtManufacturer;
    @FXML
    private JFXTextField txtMrp;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXRadioButton rbAdd;
    @FXML
    private JFXRadioButton rbUpdate;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ToggleGroup tg = new ToggleGroup();
        rbAdd.setToggleGroup(tg);
        rbUpdate.setToggleGroup(tg);

        // TODO
    }

    @FXML
    private void add(ActionEvent event) {
        ItemBO item = new ItemBO();
        item.setName(txtName.getText());
        item.setManufacturer(txtManufacturer.getText());
        item.setId(Integer.parseInt(txtId.getText()));
        item.setQty(Integer.parseInt(txtQuantity.getText()));
        item.setMrp(Float.parseFloat(txtMrp.getText()));
        item.setUnit_price(Float.parseFloat(txtUnit_Price.getText()));
        ItemDA.add(item);
    }

    @FXML
    private void update(ActionEvent event) {
        ItemBO item = new ItemBO();
        item.setName(txtName.getText());
        item.setManufacturer(txtManufacturer.getText());
        item.setId(Integer.parseInt(txtId.getText()));
        item.setQty(Integer.parseInt(txtQuantity.getText()));
        item.setMrp(Float.parseFloat(txtMrp.getText()));
        item.setUnit_price(Float.parseFloat(txtUnit_Price.getText()));
        ItemDA.update(item);
    }

    @FXML
    private void delete(ActionEvent event) {
        ItemDA.delete(Integer.parseInt(txtId.getText()));
    }

    @FXML
    private void getById(ActionEvent event) {
        ItemBO item = ItemDA.getById(Integer.parseInt(txtId.getText()));
        System.out.println(item);

        txtManufacturer.setText(item.getManufacturer());
        txtMrp.setText(String.valueOf(item.getMrp()));
        txtQuantity.setText(String.valueOf(item.getQty()));
        txtUnit_Price.setText(String.valueOf(item.getUnit_price()));
        txtName.setText(String.valueOf(item.getName()));
        txtId.setText(String.valueOf(item.getId()));
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

}
