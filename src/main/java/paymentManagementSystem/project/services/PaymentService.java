package paymentManagementSystem.project.services;

import org.springframework.stereotype.Component;
import paymentManagementSystem.project.entities.Payment;

import java.util.List;

@Component
public interface PaymentService {
    List<Payment> getAll();
    Payment getById(Long id);
    Payment update(Long id, Payment payment);
    void deleteById(Long id);
    Payment create(Payment payment);
}
