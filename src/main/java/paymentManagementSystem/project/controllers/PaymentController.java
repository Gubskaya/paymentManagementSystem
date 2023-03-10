package paymentManagementSystem.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import paymentManagementSystem.project.entities.Payment;
import paymentManagementSystem.project.services.PaymentService;
import paymentManagementSystem.project.services.impl.PaymentServiceImpl;

import java.math.BigDecimal;
import java.util.List;

@RestController
//@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payment> payments() {
        return paymentService.getAll();
    }

    @GetMapping("/getPayment/{id}")
    public Payment getById(@PathVariable("id") Long id) {
        return paymentService.getById(id);
    }

    @PostMapping("/makePayment")
    public Payment makePayment(@RequestBody Payment payment) {
        payment.setCode(paymentService.generation());
        return paymentService.create(payment);
    }

    @DeleteMapping("/deletePayment/{id}")
    public void deletePayment(@PathVariable("id") Long id) {
        paymentService.deleteById(id);
    }

    @PostMapping("/updatePayment/{id}")
    public Payment updatePayment(@PathVariable("id") Long id,@RequestBody Payment payment) {
        return paymentService.update(id, payment);
    }

    @GetMapping("/calculating/{currency}")
    public BigDecimal paymentCalculation(@PathVariable("currency") String currency) {
        return paymentService.paymentCalculation(currency);
    }

    @GetMapping("/keyWord/{keyWord}")
    public List<Payment> findByKeyWord(@PathVariable("keyWord") String keyWord) {
        return paymentService.findByKeyWord(keyWord);
    }

}
