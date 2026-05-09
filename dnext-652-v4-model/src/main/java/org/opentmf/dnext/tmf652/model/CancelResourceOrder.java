package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.CancelProductOrderBase;
import org.opentmf.dnext.common.model.CompletionCallback;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.ResourceOrderRef;
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
public class CancelResourceOrder extends CancelProductOrderBase implements ICancelResourceOrder {

  /**
   * Reason why the order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * gracefulCancel.
   */
  private @SafeText String cancellationType;

  /**
   * The context provided in callbackContext field of completionCallback.
   */
  private @Valid CompletionCallback completionCallback;

  /**
   * Date when the order is cancelled.
   */
  private OffsetDateTime effectiveCancellationDate;

  /**
   * Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Date when the submitter wants the order to be cancelled.
   */
  private OffsetDateTime requestedCancellationDate;

  private @Valid ResourceOrderRef resourceOrder;

  /**
   * Version number of the entity.
   */
  private Integer revision;
}