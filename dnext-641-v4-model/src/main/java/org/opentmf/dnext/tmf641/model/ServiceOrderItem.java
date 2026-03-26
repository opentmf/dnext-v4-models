package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AppointmentRef;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.dnext.common.model.ServiceRefOrValue;
import org.opentmf.tmf641.model.IServiceOrderItem;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> action, service<br/>
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
    defaultImpl = ServiceOrderItem.class
)
@Required(fields = {"service", "action"})
public class ServiceOrderItem extends Entity implements IServiceOrderItem {

  /**
   * The action to be carried out on the Service. Can be: add, modify, delete,
   * noChange.
   */
  private @SafeText String action;

  /**
   * An appointment that was set up with a related party for this order item.
   */
  private @Valid AppointmentRef appointment;

  /**
   * Complements the description of an element (for instance a resource) (for
   * instance a resource) through video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A list of order items embedded to this order item.
   */
  @JsonProperty("errorMessage")
  private List<@Valid ServiceOrderItemErrorMessage> errorMessages;

  /**
   * Characteristic of the given serviceOrderItem.
   */
  @JsonProperty("orderItemCharacteristic")
  private List<@Valid Characteristic> orderItemCharacteristics;

  private @Valid ServiceOrderItem preInflightOrderChangeServiceOrderItem;

  /**
   * Quantity ordered.
   */
  private Integer quantity;

  /**
   * A list of related entity in relationship with this service order item.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  /**
   * This value is passed by POF and represents the Camunda Flow Instance Id.
   */
  @SafeId
  @Size(max = 100)
  private String relatedProductFlowInstanceId;

  /**
   * The Service to be acted on by the order item.
   */
  private @Valid ServiceRefOrValue service;

  /**
   * A list of order items embedded to this order item.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItem> serviceOrderItems;

  /**
   * A list of order items related to this order item.
   */
  @JsonProperty("serviceOrderItemRelationship")
  private List<@Valid ServiceOrderItemRelationship> serviceOrderItemRelationships;

  /**
   * State of the order item: described in the state machine diagram. This is the
   * requested state.
   */
  private @SafeText String state;

  /**
   * The life cycle state reason of the resource.
   */
  private @SafeText String stateReason;
}