package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf641.model.ICancelServiceOrder;

/**
 * Request for cancellation an existing Service order.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = CancelServiceOrder.class
)
public class CancelServiceOrder extends CancelServiceOrderCreate implements ICancelServiceOrder {

  /**
   * an optional message describing the completion of the task if it is done as
   * expected or it is denied for a reason (like order in an state of PoNR).
   */
  private @SafeText String completionMessage;

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  /**
   * Date when the order is cancelled.
   */
  private OffsetDateTime effectiveCancellationDate;

  /**
   * represents an Error.
   */
  private @Valid ErrorMessage errorMessage;

  private Integer revision;

  /**
   * Tracks the lifecycle status of the cancellation request, such as
   * Acknowledged, Rejected, InProgress, Pending and so on.
   */
  private @SafeText String state;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}