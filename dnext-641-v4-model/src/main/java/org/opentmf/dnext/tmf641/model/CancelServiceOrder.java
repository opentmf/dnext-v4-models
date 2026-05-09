package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.CancelProductOrderBase;
import org.opentmf.dnext.common.model.CompletionCallback;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.ServiceOrderRef;
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
public class CancelServiceOrder extends CancelProductOrderBase implements ICancelServiceOrder {

  /**
   * Reason why the order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Attribute to define the cancellation type ethier immediateCancel or
   * gracefulCancel.
   */
  private @SafeText String cancellationType;

  /**
   * Attribute to define the callback information once the cancellation is
   * completed.
   */
  private @Valid CompletionCallback completionCallback;

  /**
   * an optional message describing the completion of the task if it is done as
   * expected or it is denied for a reason (like order in an state of PoNR).
   */
  private @SafeText String completionMessage;

  /**
   * Date when the order is cancelled.
   */
  private OffsetDateTime effectiveCancellationDate;

  /**
   * represents an Error.
   */
  private @Valid ErrorMessage errorMessage;

  /**
   * Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Date when the submitter wants the order to be cancelled.
   */
  private OffsetDateTime requestedCancellationDate;

  private Integer revision;

  /**
   * Service Order reference. Useful to understand the which was the Service order
   * through which the service was instantiated in the service inventory.
   */
  private @Valid ServiceOrderRef serviceOrder;
}