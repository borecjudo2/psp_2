package by.bsuir.psp_2.view;

import by.bsuir.psp_2.model.Startup;
import by.bsuir.psp_2.service.StartupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class StartupView implements Serializable {

  @Autowired
  private StartupService startupService;

  @FXML
  private TableView<Startup> table;

//  @FXML
//  private TextField textFieldInvestCapital;

  @FXML
  private TextField textFieldMonthCount;

  @FXML
  private TextField textFieldNetProfit;

  @FXML
  private TextField textFieldAmortization;

  @FXML
  private TextField textFieldInvestCapital;

  private ObservableList<Startup> data;

  @FXML
  public void initialize() {}

  @PostConstruct
  public void init() {
    List<Startup> contacts = startupService.getAll();
    data = FXCollections.observableArrayList(contacts);

    // Столбцы таблицы
    TableColumn<Startup, String> id = new TableColumn<>("Id");
    id.setCellValueFactory(new PropertyValueFactory<>("id"));

    TableColumn<Startup, String> monthCount = new TableColumn<>("Month count");
    monthCount.setCellValueFactory(new PropertyValueFactory<>("monthCount"));

    TableColumn<Startup, String> netProfit = new TableColumn<>("Net profit");
    netProfit.setCellValueFactory(new PropertyValueFactory<>("netProfit"));

    TableColumn<Startup, String> amortization = new TableColumn<>("Amortization");
    amortization.setCellValueFactory(new PropertyValueFactory<>("amortization"));

    table.getColumns().setAll(id, monthCount, netProfit, amortization);

    table.setItems(data);
  }

  @FXML
  public void addStartUp() {
    int monthCount = Integer.parseInt(textFieldMonthCount.getText());
    int netProfit = Integer.parseInt(textFieldNetProfit.getText());
    int amortization = Integer.parseInt(textFieldAmortization.getText());

    startupService.save(monthCount, netProfit, amortization, data);

    cleanInputFields();
  }

  private void cleanInputFields() {
    textFieldMonthCount.setText("");
    textFieldNetProfit.setText("");
    textFieldAmortization.setText("");
  }

  @FXML
  public void calculatePaybackPeriod() {
    int investCapital = Integer.parseInt(textFieldInvestCapital.getText());
    long paybackPeriod = startupService.calculatePaybackPeriod(investCapital);

    Notifications.create()
        .title("Payback Period")
        .text("Payback Period is " + paybackPeriod)
        .hideAfter(Duration.seconds(10))
        .position(Pos.CENTER).showConfirm();

    textFieldInvestCapital.setText("");
  }
}
