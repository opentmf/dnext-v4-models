package org.opentmf.dnext.tmf639.model;

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
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.Feature;
import org.opentmf.dnext.common.model.IdentifierRange;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.RelatedPlaceRefOrValue;
import org.opentmf.dnext.common.model.RelatedProductOrderItem;
import org.opentmf.dnext.common.model.RelatedResourceOrderItem;
import org.opentmf.dnext.common.model.RelatedServiceOrderItem;
import org.opentmf.dnext.common.model.ResourceSpecificationRef;

/**
 * Pyhsical Resource entity.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
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
    defaultImpl = PhysicalResourceCreate.class
)
@Required(fields = {"name"})
public class PhysicalResourceCreate extends Extensible {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * List of: Configuration feature.
   */
  @JsonProperty("activationFeature")
  private List<@Valid Feature> activationFeatures;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
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
   * Extensions to support resource pooling management.
   */
  private @Valid IdentifierRange extensions;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Unique identifier of the account.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * This is a string attribute that defines the date of manufacture of this item
   * in the fixed format "dd/mm/yyyy". This is an optional attribute.
   */
  private OffsetDateTime manufactureDate;

  /**
   * A string used to give a name to the resource.
   */
  private @SafeText String name;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
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
   * This defines the current power status of the hardware item. Values include: 
   * 0: Unknown  1: Not Applicable  2: No Power Applied  3: Full Power Applied  4:
   * Power Save - Normal  5: Power Save - Degraded  6: Power Save - Standby  7:
   * Power Save - Critical  8: Power Save - Low Power Mode  9: Power Save -
   * Unknown 10: Power Cycle 11: Power Warning 12: Power Off.
   */
  private @SafeText String powerState;

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
  private List<Object> resourceRelationships;

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
   * This is a string that represents a manufacturer-allocated number used to
   * identify different instances of the same hardware item. The ModelNumber and
   * PartNumber attributes are used to identify different types of hardware items.
   * This is a REQUIRED attribute.
   */
  private @SafeText String serialNumber;

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
   */
  private @SafeText String usageState;

  /**
   * This is a string that identifies the version of this physical resource. This
   * is an optional attribute.
   */
  private @SafeText String versionNumber;
}