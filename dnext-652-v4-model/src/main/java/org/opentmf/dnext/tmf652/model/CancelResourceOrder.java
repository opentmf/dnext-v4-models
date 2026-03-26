package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf652.model.ICancelResourceOrder;

/**
 * Request for cancellation an existing resource order.
 *
 * <p><br/>
 * <strong>Required:</strong> resourceOrder<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = CancelResourceOrder.class
)
@Required(fields = {"resourceOrder"})
public class CancelResourceOrder extends CancelResourceOrderCreate implements ICancelResourceOrder {

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  /**
   * Date when the order is cancelled.
   */
  private OffsetDateTime effectiveCancellationDate;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * Tracks the lifecycle status of the cancellation request, such as
   * Acknowledged, Rejected, InProgress, Pending and so on.
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done, rejected.
   *
   * @see org.opentmf.dnext.tmf652.model.CancelResourceOrderStateType
   */
  private @SafeText String state;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}