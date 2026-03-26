package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf622.model.ICancelProductOrder;

/**
 * Request for cancellation an existing product order.
 *
 * <p><br/>
 * <strong>Required:</strong> productOrder<br/>
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
    defaultImpl = CancelProductOrder.class
)
@Required(fields = {"productOrder"})
public class CancelProductOrder extends CancelProductOrderCreate implements ICancelProductOrder {

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  /**
   * Date when the order is cancelled.
   */
  private OffsetDateTime effectiveCancellationDate;

  /**
   * Hyperlink to access the cancellation request.
   */
  private URI href;

  private Integer revision;

  private @SafeText String state;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}