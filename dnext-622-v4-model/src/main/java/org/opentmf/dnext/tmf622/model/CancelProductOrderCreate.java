package org.opentmf.dnext.tmf622.model;

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
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.ProductOrderRef;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf622.model.ICancelProductOrderCreate;

/**
 * The CancelProductOrder to be created.
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
    defaultImpl = CancelProductOrderCreate.class
)
@Required(fields = {"productOrder"})
public class CancelProductOrderCreate extends Extensible implements ICancelProductOrderCreate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Reason why the order is cancelled.
   */
  private @SafeText String cancellationReason;

  private @SafeText String cancellationType;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier for Cancel Product Order entity.
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
   * ProductOrder (ProductOrder) .The product order which the recommendation is
   * related with.
   */
  private @Valid ProductOrderRef productOrder;

  /**
   * Date when the submitter wants the order to be cancelled.
   */
  private OffsetDateTime requestedCancellationDate;
}