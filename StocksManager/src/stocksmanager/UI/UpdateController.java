/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmanager.UI;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class UpdateController implements Initializable {

    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnNew;
    @FXML
    private JFXButton btnCheck;
    @FXML
    private Label lblWelcome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblWelcome.setText("Welcome, " + stocksmanager.StocksManager.customer.getName());
    }

    @FXML
    private void updateprofile(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void neworder(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("AddOrders.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void checkorder(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("ViewOrders.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
