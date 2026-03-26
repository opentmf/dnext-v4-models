package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.CompletionCallback;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf652.model.IResourceOrderCreate;

/**
 * The Resource Order to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> orderItem<br/>
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
    defaultImpl = ResourceOrderCreate.class
)
@Required(fields = {"orderItem"})
public class ResourceOrderCreate extends NamedEntity implements IResourceOrderCreate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Complements the description of an element (for instance a resource) (for
   * instance a resource) through video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  private @SafeText String batchWorkflowName;

  /**
   * Used to categorize the order from a business perspective that can be useful
   * for the OM system.
   */
  private @SafeText String category;

  /**
   * The context provided in callbackContext field of completionCallback.
   */
  private @Valid CompletionCallback completionCallback;

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * free-text description of the Resource Order.
   */
  private @SafeText String description;

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * DEPRECATED: Use externalReference Instead. ID given by the consumer (to
   * facilitate searches afterwards).
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * List of: An identification of an entity that is owned by or originates in a
   * software system different from the current system, for example a ProductOrder
   * handed off from a commerce platform into an order handling system. The
   * structure identifies the system itself, the nature of the entity within the
   * system (e.g. class name) and the unique ID of the entity within the system.
   * It is anticipated that multiple external IDs can be held for a single entity,
   * e.g. if the entity passed through multiple systems on the way to the current
   * system. In this case the consumer is expected to sequence the IDs in the
   * array in reverse order of provenance, i.e. most recent system first in the
   * list.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalId> externalReferences;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Characteristic of the given resourceOrder.
   */
  @JsonProperty("orderCharacteristic")
  private List<@Valid Characteristic> orderCharacteristics;

  /**
   * Date when the order was created.
   */
  private OffsetDateTime orderDate;

  /**
   * A list of resource order items to be processed by this order.
   */
  @JsonProperty("orderItem")
  private List<@Valid ResourceOrderItem> orderItems;

  /**
   * Name of the Resource Order type.
   */
  private @SafeText String orderType;

  /**
   * A way that can be used by consumers to prioritize orders in OM system (from 0
   * to 4 : 0 is the highest priority, and 4 the lowest).
   */
  private Integer priority;

  /**
   * A list of related entity in relationship with this resource order item.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Requested delivery date from the requester perspective.
   */
  private OffsetDateTime requestedCompletionDate;

  /**
   * Order start date wished by the requester.
   */
  private OffsetDateTime requestedStartDate;

  /**
   * Date when the order was actually started.
   */
  private OffsetDateTime startDate;

  private @SafeText String state;
}