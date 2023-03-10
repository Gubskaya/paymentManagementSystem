package paymentManagementSystem.project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentManagementSystem.project.entities.Payment;
import paymentManagementSystem.project.repositories.PaymentRepo;
import paymentManagementSystem.project.services.PaymentService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
//@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepo.findById(id).get();
    }

    @Override
    public Payment update(Long id, Payment payment) {
        Payment oldPayment = paymentRepo.findById(id).get();
        oldPayment.setAmount(payment.getAmount());
        //oldPayment.setCode(payment.getCode());
        oldPayment.setState(payment.getState());
        oldPayment.setCurrency(payment.getCurrency());
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

    @Override
    public String generation() {
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 8) {
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            return saltStr;
        }

    @Override
    public BigDecimal paymentCalculation(String currency) {
        return paymentRepo.filterByCurrency(currency);
    }

    @Override
    public List<Payment> findByKeyWord(String keyWord) {
        List<Long> ids = paymentRepo.findPaymentByKeyWord(keyWord);
        return paymentRepo.findAllById(ids);
    }
}
