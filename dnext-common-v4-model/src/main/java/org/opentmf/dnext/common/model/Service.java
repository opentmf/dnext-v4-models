package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IService;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Service is a base class for defining the Service hierarchy. All Services are
 * characterized as either being possibly visible and usable by a Customer or
 * not. This gives rise to the two subclasses of Service: CustomerFacingService
 * and ResourceFacingService.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
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
    defaultImpl = Service.class
)
public class Service extends PaymentBase implements IService {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Is it a customer facing or resource facing service.
   */
  private @SafeText String category;

  /**
   * Date when the service ends.
   */
  private OffsetDateTime endDate;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * A list of feature associated with this service.
   */
  @JsonProperty("feature")
  private List<@Valid Feature> features;

  /**
   * If TRUE, this Service has already been started.
   */
  private Boolean hasStarted;

  /**
   * If true, the service is a ServiceBundle which regroup a service hierarchy. If
   * false, the service is a 'atomic' service (hierarchy leaf).
   */
  private Boolean isBundle;

  /**
   * If FALSE and hasStarted is FALSE, this particular Service has NOT been
   * enabled for use - if FALSE and hasStarted is TRUE then the service has
   * failed.
   */
  private Boolean isServiceEnabled;

  /**
   * If TRUE, this Service can be changed without affecting any other services.
   */
  private Boolean isStateful;

  /**
   * A list of notes made on this service.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * A list of places (Place [*]). Used to define a place useful for the service
   * (for example a geographical place where the service is installed).
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * List of: RelatedProductOrderItem (ProductOrder item) .The product order item
   * which triggered product creation/change/termination.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid RelatedProductOrderItem> productOrderItems;

  /**
   * A list of related entity in relationship with this service.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  /**
   * A list of characteristics that characterize this service
   * (ServiceCharacteristic [*]).
   */
  @JsonProperty("serviceCharacteristic")
  private List<@Valid Characteristic> serviceCharacteristics;

  /**
   * Date when the service was created (whatever its status).
   */
  private OffsetDateTime serviceDate;

  /**
   * A list of service order items related to this service.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid RelatedServiceOrderItem> serviceOrderItems;

  /**
   * A list of service relationships (ServiceRelationship [*]). Describes links
   * with other service(s) in the inventory.
   */
  @JsonProperty("serviceRelationship")
  private List<@Valid ServiceRelationship> serviceRelationships;

  /**
   * The specification from which this service was instantiated.
   */
  private @Valid ServiceSpecificationRef serviceSpecification;

  /**
   * Business type of the service.
   */
  private @SafeText String serviceType;

  /**
   * Date when the service starts.
   */
  private OffsetDateTime startDate;

  /**
   * This attribute is an enumerated integer that indicates how the Service is
   * started, such as: 0: Unknown; 1: Automatically by the managed environment; 2:
   * Automatically by the owning device; 3: Manually by the Provider of the
   * Service; 4: Manually by a Customer of the Provider; 5: Any of the above.
   */
  private @SafeText String startMode;

  /**
   * The life cycle state of the service, such as designed, reserved, active,
   * etc...
   */
  private @SafeText String state;

  private @SafeText String stateReason;

  /**
   * A list of supporting resources (SupportingResource [*]).Note: only Service of
   * type RFS can be associated with Resources.
   */
  @JsonProperty("supportingResource")
  private List<@Valid ResourceRef> supportingResources;

  /**
   * A list of supporting services (SupportingService [*]). A collection of
   * services that support this service (bundling, link CFS to RFS).
   */
  @JsonProperty("supportingService")
  private List<@Valid ServiceRefOrValue> supportingServices;
}