package org.opentmf.dnext.tmf629.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.customer.model.Customer;
import org.opentmf.tmf629.model.ICustomerCreateEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-629: Customer Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CustomerCreateEventPayload implements ICustomerCreateEventPayload {

  private @Valid Customer customer;
}