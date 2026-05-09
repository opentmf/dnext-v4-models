package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf622.model.IProductOrderUpdate;

/**
 * The ProductOrder to be updated.
 *
 * <p><br/>
 * <strong>Required:</strong> productOrderItem<br/>
 * </p>
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
    defaultImpl = ProductOrderUpdate.class
)
@Required(fields = {"productOrderItem"})
public class ProductOrderUpdate extends ProductOrderCreate implements IProductOrderUpdate {

  /**
   * Date when the order is cancelled. This is used when order is cancelled.
   */
  private OffsetDateTime cancellationDate;

  /**
   * Reason why the order is cancelled. This is used when order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Expected delivery date amended by the provider.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * Indicates if the order is an ongoing inflight order change.
   */
  private Boolean isOngoingInflightOrderChange;

  private Boolean pointOfNoReturnIFOC;
}