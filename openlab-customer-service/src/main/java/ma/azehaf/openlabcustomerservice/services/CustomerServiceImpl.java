package ma.azehaf.openlabcustomerservice.services;

import ma.azehaf.openlabcustomerservice.dto.CustomerRequestDTO;
import ma.azehaf.openlabcustomerservice.dto.CustomerResponseDTO;
import ma.azehaf.openlabcustomerservice.entities.Customer;
import ma.azehaf.openlabcustomerservice.mappers.CustomerMapper;
import ma.azehaf.openlabcustomerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        /*
            Mapping Objet Objet
         */
        //Customer customer = new Customer();
        //customer.setId(customerRequestDTO.getId());
        //customer.setName(customerRequestDTO.getName());
        //customer.setEmail(customerRequestDTO.getEmail());

        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        //customer.setId(UUID.randomUUID().toString());
        Customer saveCustomer = customerRepository.save(customer);

        //CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        //customerResponseDTO.setId(saveCustomer.getId());
        //customerResponseDTO.setName(saveCustomer.getName());
        //customerResponseDTO.setEmail(saveCustomer.getEmail());
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(customer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(customer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS =
                customers.stream().map(cust->customerMapper.customerToCustomerResponseDTO(cust)).collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
