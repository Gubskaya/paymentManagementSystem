package paymentManagementSystem.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import paymentManagementSystem.project.entities.Payment;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    @Query("SELECT sum(amount) FROM Payment WHERE currency = :currency AND state = 'DONE'")
    BigDecimal filterByCurrency(@PathVariable("currency") String currency);

    @Query("SELECT id FROM Payment WHERE keyWord = :keyWord ")
    List<Long> findPaymentByKeyWord(@PathVariable("keyWord") String keyWord);



}
