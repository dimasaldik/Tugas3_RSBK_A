package coreservlets;

import java.util.*;
import javax.faces.bean.*;

@ManagedBean
public class Purchases {
  private String[] cheapItems =
    { "Headseat", "uwu", "Earphone" };
  private List<String> mediumItems =
    new ArrayList<>();
  private Map<String,String> valuableItems =
    new HashMap<>();
  private boolean isEverythingOK = true;

  public Purchases() {
    mediumItems.add("yee");
    mediumItems.add("Meja");
    mediumItems.add("Bunga");
    valuableItems.put("low", "Biola");
    valuableItems.put("medium", "Bola Basket");
    valuableItems.put("high", "Bola Sepak");
  }

  public String[] getCheapItems() {
    return(cheapItems);
  }

  public List<String> getMediumItems() {
    return(mediumItems);
  }

  public Map<String,String> getValuableItems() {
    return(valuableItems);
  }

  public String purchaseItems() {
    isEverythingOK = Utils.doBusinessLogic(this);
    isEverythingOK = Utils.doDataAccessLogic(this);
    if (isEverythingOK) {
      return("purchase-success");
    } else {
      return("purchase-failure");
    }
  }
}