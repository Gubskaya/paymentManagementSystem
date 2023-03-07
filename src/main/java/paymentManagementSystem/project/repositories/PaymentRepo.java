package paymentManagementSystem.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paymentManagementSystem.project.entities.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
