/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmanager.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import stocksmanager.DA.OrdersDA;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ViewOrdersController implements Initializable {

    @FXML
    private TableColumn<?, ?> tcId;
    @FXML
    private TableColumn<?, ?> tcName;
    @FXML
    private TableColumn<?, ?> tcPrice;
    @FXML
    private TableColumn<?, ?> tcQuantity;
    @FXML
    private TableView tvOrders;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("item"));
        tcPrice.setCellValueFactory(new PropertyValueFactory("totalprice"));
        tcQuantity.setCellValueFactory(new PropertyValueFactory("quantity"));

        tvOrders.getItems().addAll(OrdersDA.getAllbyCustomerId(stocksmanager.StocksManager.customer.getId()));

    }

}
