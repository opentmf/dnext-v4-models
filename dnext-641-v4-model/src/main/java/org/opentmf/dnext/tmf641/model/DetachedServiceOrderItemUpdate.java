package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AppointmentRef;
import org.opentmf.dnext.common.model.InflightOrderChangeUpdate;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.dnext.common.model.ServiceRefOrValue;

/**
 * The ServiceOrder to be updated.
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
    defaultImpl = DetachedServiceOrderItemUpdate.class
)
public class DetachedServiceOrderItemUpdate extends InflightOrderChangeUpdate {

  /**
   * The action to be carried out on the Service. Can be: add, modify, delete,
   * noChange.
   */
  private @SafeText String action;

  /**
   * Reason explanation of the serviceOrder action.
   */
  private @SafeText String actionReason;

  /**
   * Refers an appointment, such as a Customer presentation or internal meeting or
   * site visit.
   */
  private @Valid AppointmentRef appointment;

  /**
   * A list of order items embedded to this order item.
   */
  @JsonProperty("errorMessage")
  private List<@Valid ServiceOrderItemErrorMessage> errorMessages;

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
   * A Service to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the Service entity and not the RelatedServiceRefOrValue class itself.
   */
  private @Valid ServiceRefOrValue service;

  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItem> serviceOrderItems;

  /**
   * A list of order items related to this order item.
   */
  @JsonProperty("serviceOrderItemRelationship")
  private List<@Valid ServiceOrderItemRelationship> serviceOrderItemRelationships;

  /**
   * Reason explanation of the service state.
   */
  private @SafeText String stateReason;
}