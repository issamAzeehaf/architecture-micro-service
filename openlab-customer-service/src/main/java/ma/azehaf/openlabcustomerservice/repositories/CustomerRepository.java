package ma.azehaf.openlabcustomerservice.repositories;

import ma.azehaf.openlabcustomerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
