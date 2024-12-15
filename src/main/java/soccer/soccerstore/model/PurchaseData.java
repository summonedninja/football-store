package soccer.soccerstore.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchaseData {
    private int creditNumber;
    private LocalDate datePurchaseData = LocalDate.now();
}
