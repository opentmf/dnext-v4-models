package org.opentmf.dnext.tmf637.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf637.model.IProductBatchEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-637: Product Inventory Management API</li>
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
    defaultImpl = ProductBatchEvent.class
)
public class ProductBatchEvent extends QuoteCreateEventBase implements IProductBatchEvent {

  /**
   * The event data structure.
   */
  private @Valid ProductBatchEventPayload event;
}