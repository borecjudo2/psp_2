package by.bsuir.psp_2.service.impl;

import by.bsuir.psp_2.model.Startup;
import by.bsuir.psp_2.repo.StartupRepository;
import by.bsuir.psp_2.service.StartupService;
import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Service
@AllArgsConstructor
public class StartupServiceImpl implements StartupService {

  private final StartupRepository repository;

  @Override
  public Startup save(int monthCount, int netProfit, int amortization, ObservableList<Startup> data) {
    Startup startup = new Startup(monthCount, netProfit, amortization);

    repository.save(startup);
    data.add(startup);

    return startup;
  }

  @Override
  public List<Startup> getAll() {
    return (List<Startup>) repository.findAll();
  }

  @Override
  public long calculatePaybackPeriod(int investCapital) {
    long sumCashFlow = 0;
    int paybackPeriod = 0;

    for (Startup startup : getAll()) {
      if (investCapital < sumCashFlow) {
        break;
      }
      ++paybackPeriod;
      sumCashFlow += startup.getNetProfit() + startup.getAmortization();
    }

    return paybackPeriod;
  }
}

