package paymentManagementSystem.project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import paymentManagementSystem.project.entities.Payment;
import paymentManagementSystem.project.repositories.PaymentRepo;
import paymentManagementSystem.project.services.PaymentService;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;

    @Override
    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepo.getReferenceById(id);
    }

    @Override
    public Payment update(Long id, Payment payment) {
        Payment oldPayment = paymentRepo.findById(id).get();
        oldPayment.setAmount(payment.getAmount());
        oldPayment.setCode(payment.getCode());
        oldPayment.setState(payment.getState());
        oldPayment.setCurrency(payment.getAmount());
        paymentRepo.save(oldPayment);
        return oldPayment;
    }

    @Override
    public void deleteById(Long id) {
        paymentRepo.deleteById(id);
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepo.save(payment);
    }
}
