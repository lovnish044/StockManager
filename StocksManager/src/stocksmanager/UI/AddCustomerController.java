/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmanager.UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import stocksmanager.BO.CustomerBO;
import stocksmanager.DA.CustomerDA;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AddCustomerController implements Initializable {

    @FXML
    private RadioButton rbMale;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextArea txtAddress;
    @FXML
    private JFXTextField txtMobile;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXRadioButton rbAdd;
    @FXML
    private JFXRadioButton rbupdate;
    @FXML
    private JFXRadioButton rbFemale;

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
        rbupdate.setToggleGroup(tg);
        rbMale.setToggleGroup(tg);
        rbFemale.setToggleGroup(tg);

    }

    @FXML
    private void add(ActionEvent event) {
        CustomerBO customer = new CustomerBO();
        String name = "";
        if (rbMale.isSelected() == true) {
            name = "Male";
        } else {
            name = "Female";
        }
        customer.setGender(name);
        customer.setAddress(txtAddress.getText());
        customer.setEmail(txtEmail.getText());
        customer.setId(Integer.parseInt(txtId.getText()));
        customer.setName(txtName.getText());
        customer.setMobile(Long.parseLong(txtMobile.getText()));
        CustomerDA.add(customer);
    }

    @FXML
    private void update(ActionEvent event) {
        CustomerBO customer = new CustomerBO();
        String name = "";
        if (rbMale.isSelected() == true) {
            name = "Male";
        } else {
            name = "Female";
        }
        customer.setGender(name);
        customer.setAddress(txtAddress.getText());
        customer.setEmail(txtEmail.getText());
        customer.setId(Integer.parseInt(txtId.getText()));
        customer.setName(txtName.getText());
        customer.setMobile(Long.parseLong(txtMobile.getText()));
        CustomerDA.update(customer);
    }

    @FXML
    private void delete(ActionEvent event) {
        CustomerDA.delete(Integer.parseInt(txtId.getText()));
    }

    @FXML
    private void getById(ActionEvent event) {
        CustomerBO customer = CustomerDA.getById(Integer.parseInt(txtId.getText()));
        if (customer.getGender().equals("Male")) {
            rbMale.setSelected(true);
        } else {
            rbFemale.setSelected(true);
        }
        txtAddress.setText(customer.getAddress());
        txtMobile.setText(String.valueOf(customer.getMobile()));
        txtEmail.setText(String.valueOf(customer.getEmail()));
        txtName.setText(String.valueOf(customer.getName()));
        txtId.setText(String.valueOf(customer.getId()));
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
