package paymentManagementSystem.project.services;

import org.springframework.stereotype.Component;
import paymentManagementSystem.project.entities.Payment;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface PaymentService {
    List<Payment> getAll();
    Payment getById(Long id);
    Payment update(Long id, Payment payment);
    void deleteById(Long id);
    Payment create(Payment payment);
    String generation();
    BigDecimal paymentCalculation(String currency);
    List<Payment> findByKeyWord(String keyWord);
}
