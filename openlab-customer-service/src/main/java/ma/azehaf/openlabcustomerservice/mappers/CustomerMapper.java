package ma.azehaf.openlabcustomerservice.mappers;

import ma.azehaf.openlabcustomerservice.dto.CustomerRequestDTO;
import ma.azehaf.openlabcustomerservice.dto.CustomerResponseDTO;
import ma.azehaf.openlabcustomerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);

}
