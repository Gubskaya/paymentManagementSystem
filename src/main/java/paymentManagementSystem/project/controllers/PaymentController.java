package paymentManagementSystem.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import paymentManagementSystem.project.entities.Payment;
import paymentManagementSystem.project.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        paymentService.deletePayment(id);
    }


}
