package paymentManagementSystem.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentManagementSystem.project.entities.Payment;
import paymentManagementSystem.project.repositories.PaymentRepo;

@Service
public class PaymentService {
    private final PaymentRepo paymentRepo;

    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public Payment getPayment(Long id) {
        return paymentRepo.getReferenceById(id);
    }

    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }


}
