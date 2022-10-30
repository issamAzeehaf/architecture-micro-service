package ma.azehaf.ensetbillingservice.services;

import ma.azehaf.ensetbillingservice.dto.InvoiceRequestDTO;
import ma.azehaf.ensetbillingservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> invoiceByCustomerId(String customerId);
    List<InvoiceResponseDTO> allInvoices();

}
