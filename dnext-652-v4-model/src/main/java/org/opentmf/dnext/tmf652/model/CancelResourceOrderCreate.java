package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.CompletionCallback;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.ResourceOrderRef;
import org.opentmf.tmf652.model.ICancelResourceOrderCreate;

/**
 * The CancelResourceOrder to be created.
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
    defaultImpl = CancelResourceOrderCreate.class
)
@Required(fields = {"resourceOrder"})
public class CancelResourceOrderCreate extends Extensible implements ICancelResourceOrderCreate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Reason why the order is cancelled.
   */
  private @SafeText String cancellationReason;

  private @SafeText String cancellationType;

  /**
   * The context provided in callbackContext field of completionCallback.
   */
  private @Valid CompletionCallback completionCallback;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * id of the cancellation request (this is not an order id).
   */
  @SafeId
  @Size(max = 100)
  private String id;

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
}