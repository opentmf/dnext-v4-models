package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * A ProductOrderErrorMessage represents an error that causes a status change in
 * a product order.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ProductOrderErrorMessage.class
)
public class ProductOrderErrorMessage extends ProductOrderItemErrorMessage {

  /**
   * A list of order item references corresponded to this error.
   */
  @JsonProperty("productOrderItem")
  private List<Object> productOrderItems;
}