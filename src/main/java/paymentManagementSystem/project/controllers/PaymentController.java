package paymentManagementSystem.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import paymentManagementSystem.project.entities.Payment;
import paymentManagementSystem.project.services.PaymentService;
import paymentManagementSystem.project.services.impl.PaymentServiceImpl;

@RestController
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/getPayment/{id}")
    public Payment getById(@PathVariable("id") Long id) {
        return paymentService.getById(id);
    }

    @PostMapping("/makePayment")
    public Payment makePayment(Payment payment) {
        return paymentService.create(payment);
    }

    @DeleteMapping("/deletePayment/{id}")
    public void deletePayment(Long id) {
        paymentService.deleteById(id);
    }

    @PostMapping("/updatePayment/{id}")
    public Payment updatePayment(Long id, Payment payment) {
        return paymentService.update(id, payment);
    }

}
