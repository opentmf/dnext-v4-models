package org.opentmf.dnext.tmf641.model;

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
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf641.model.IServiceOrderCreate;

/**
 * The ServiceOrder to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> serviceOrderItem, serviceOrderItemIds<br/>
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
    defaultImpl = ServiceOrderCreate.class
)
@Required(fields = {"serviceOrderItem", "serviceOrderItemIds"})
public class ServiceOrderCreate extends Entity implements IServiceOrderCreate {

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
   * Date when the order is cancelled. This is used when order is cancelled.
   */
  private OffsetDateTime cancellationDate;

  /**
   * Reason why the order is cancelled. This is used when order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Used to categorize the order, useful for the OM system, such as: Broadband,
   * TVOption.
   */
  private @SafeText String category;

  /**
   * Extra information about a given entity.
   */
  private @Valid CompletionCallback completionCallback;

  /**
   * A free-text description of the service order.
   */
  private @SafeText String description;

  /**
   * The error(s) cause an order status change.
   */
  @JsonProperty("errorMessage")
  private List<@Valid ServiceOrderErrorMessage> errorMessages;

  /**
   * ID given by the consumer to facilitate searches.
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * A list of jeopardy alerts related to this order.
   */
  @JsonProperty("jeopardyAlert")
  private List<@Valid ServiceOrderJeopardyAlert> jeopardyAlerts;

  /**
   * A list of milestones related to this order.
   */
  @JsonProperty("milestone")
  private List<@Valid ServiceOrderMilestone> milestones;

  /**
   * Extra-information about the order; e.g. useful to add extra delivery
   * information that could be useful for a human process.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Contact attached to the order to send back information regarding this order.
   */
  private @SafeText String notificationContact;

  /**
   * Characteristic of the given serviceOrder.
   */
  @JsonProperty("orderCharacteristic")
  private List<@Valid Characteristic> orderCharacteristics;

  /**
   * A list of service orders related to this order (e.g. prerequisite, dependent
   * on).
   */
  @JsonProperty("orderRelationship")
  private List<@Valid ServiceOrderRelationship> orderRelationships;

  /**
   * Can be used by consumers to prioritize orders in a Service Order Management
   * system.
   */
  private @SafeText String priority;

  /**
   * A list of related entity in relationship with this service order item.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  /**
   * A list of parties which are involved in this order and the role they are
   * playing.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Requested delivery date from the requesters perspective.
   */
  private OffsetDateTime requestedCompletionDate;

  /**
   * Order start date wished by the requester.
   */
  private OffsetDateTime requestedStartDate;

  /**
   * A list of service order items to be processed by this order.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItem> serviceOrderItems;

  @JsonProperty("serviceOrderItemIds")
  private List<@SafeText String> serviceOrderItemIdses;

  private @SafeText String state;

  /**
   * The life cycle state reason of the resource.
   */
  private @SafeText String stateReason;
}