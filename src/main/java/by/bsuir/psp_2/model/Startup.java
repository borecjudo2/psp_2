package by.bsuir.psp_2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Startup implements Serializable {

  @Id
  @GeneratedValue
  private UUID id;

  @NonNull
  private int monthCount;

//  @NonNull
//  private int investCapital;

  @NonNull
  private int netProfit;

  @NonNull
  private int amortization;
}
