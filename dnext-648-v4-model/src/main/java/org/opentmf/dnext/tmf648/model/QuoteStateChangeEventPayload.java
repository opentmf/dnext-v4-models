package org.opentmf.dnext.tmf648.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf648.model.IQuoteStateChangeEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class QuoteStateChangeEventPayload implements IQuoteStateChangeEventPayload {

  /**
   * Quote can be used to negotiate service and product acquisition or
   * modification between a customer and a service provider. Quote contain list of
   * quote items, a reference to customer (partyRole), a list of productOffering
   * and attached prices and conditions.
   */
  private @Valid Quote quote;
}