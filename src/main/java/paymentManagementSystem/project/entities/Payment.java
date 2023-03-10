package paymentManagementSystem.project.entities;

import lombok.Data;
import paymentManagementSystem.project.enums.Currency;
import paymentManagementSystem.project.enums.State;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal amount;
    private String currency;
    private String state;
    private String keyWord;



   /* @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private State state;*/
}
