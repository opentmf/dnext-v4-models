package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IResourceRefOrValue;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
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
    defaultImpl = ResourceRefOrValue.class
)
public class ResourceRefOrValue extends EntityRef implements IResourceRefOrValue {

  /**
   * Feature that needs to be activated for the resource.
   */
  @JsonProperty("activationFeature")
  private List<@Valid Feature> activationFeatures;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
   * <br/><p>Recommended values: locked, unlocked, shutdown.
   *
   * @see org.opentmf.dnext.resource.model.ResourceRefOrValueAdministrativeStateType
   */
  private @SafeText String administrativeState;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Category of the concrete resource. e.g. Gold, Silver for MSISDN concrete
   * resource.
   */
  private @SafeText String category;

  /**
   * free-text description of the resource.
   */
  private @SafeText String description;

  /**
   * A date time( DateTime). The date till the resource is operating.
   */
  private OffsetDateTime endOperatingDate;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
   * <br/><p>Recommended values: enable, disable.
   *
   * @see org.opentmf.dnext.resource.model.ResourceRefOrValueOperationalStateType
   */
  private @SafeText String operationalState;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
   * not the RelatedPlaceRefOrValue class itself.
   */
  private @Valid RelatedPlaceRefOrValue place;

  /**
   * List of: RelatedProductOrderItem (ProductOrder item) .The product order item
   * which triggered product creation/change/termination.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid RelatedProductOrderItem> productOrderItems;

  /**
   * A list of related entity in relationship with this service order item.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("resourceCharacteristic")
  private List<@Valid Characteristic> resourceCharacteristics;

  /**
   * A list of resource order items related to this resource.
   */
  @JsonProperty("resourceOrderItem")
  private List<@Valid RelatedResourceOrderItem> resourceOrderItems;

  @JsonProperty("resourceRelationship")
  private List<@Valid ResourceRelationship> resourceRelationships;

  private @Valid ResourceSpecificationRef resourceSpecification;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
   */
  private @SafeText String resourceStatus;

  /**
   * A field that identifies the specific version of an instance of a resource.
   */
  private @SafeText String resourceVersion;

  /**
   * List of: RelatedServiceOrderItem (a ServiceOrder item) .The service order
   * item which triggered service creation/change/termination.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid RelatedServiceOrderItem> serviceOrderItems;

  /**
   * A date time( DateTime). The date from which the resource is operating.
   */
  private OffsetDateTime startOperatingDate;

  /**
   * Reason explanation of the product status.
   */
  private @SafeText String statusReason;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
   * <br/><p>Recommended values: idle, active, busy.
   *
   * @see org.opentmf.dnext.resource.model.ResourceRefOrValueUsageStateType
   */
  private @SafeText String usageState;
}