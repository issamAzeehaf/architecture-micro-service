package ma.azehaf.ensetbillingservice.mappers;

import ma.azehaf.ensetbillingservice.dto.InvoiceRequestDTO;
import ma.azehaf.ensetbillingservice.dto.InvoiceResponseDTO;
import ma.azehaf.ensetbillingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
