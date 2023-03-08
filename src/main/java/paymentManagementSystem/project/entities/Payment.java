package paymentManagementSystem.project.entities;

import lombok.Data;
import paymentManagementSystem.project.enums.Currency;
import paymentManagementSystem.project.enums.State;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String amount;
    private String currency;
    private String state;
}
