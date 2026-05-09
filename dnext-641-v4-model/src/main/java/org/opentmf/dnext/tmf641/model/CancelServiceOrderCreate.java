package org.opentmf.dnext.tmf641.model;

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
import org.opentmf.dnext.common.model.ServiceOrderRef;
import org.opentmf.tmf641.model.ICancelServiceOrderCreate;

/**
 * The CancelServiceOrder to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> serviceOrder<br/>
 * </p>
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
    defaultImpl = CancelServiceOrderCreate.class
)
@Required(fields = {"serviceOrder"})
public class CancelServiceOrderCreate extends Extensible implements ICancelServiceOrderCreate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

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
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of a cancel service Order entity.
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

  /**
   * Service Order reference. Useful to understand the which was the Service order
   * through which the service was instantiated in the service inventory.
   */
  private @Valid ServiceOrderRef serviceOrder;
}