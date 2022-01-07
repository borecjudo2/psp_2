package by.bsuir.psp_2.service;

import by.bsuir.psp_2.model.Startup;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface StartupService {

  Startup save(int monthCount, int netProfit, int amortization, ObservableList<Startup> data);

  List<Startup> getAll();

  long calculatePaybackPeriod(int investCapital);
}
