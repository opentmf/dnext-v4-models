package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.FeatureSpecification;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TargetResourceSchema;
import org.opentmf.dnext.common.model.TimePeriod;

/**
 * The ResourceFunctionSpecification to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ResourceFunctionSpecificationUpdate {

  /**
   * Complements the description of an element (for instance a resource) (for
   * instance a resource) through video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A type of ResourceFunctionSpecification that belongs to a grouping of
   * ResourceFunctionSpecifications made available to the market. It inherits of
   * all attributes of ResourceFunctionSpecification.
   */
  @JsonProperty("bundledResourceFunctionSpecification")
  private List<@Valid BundledResourceFunctionSpecification> bundledResourceFunctionSpecifications;

  /**
   * Category of the target resource like NetworkConnectivity, PhysicalLinks,
   * Generic, L2Network and so on.
   */
  private @SafeText String category;

  /**
   * External connection point specifications. These are the service access points
   * (SAP) where inputs and outputs of the function are available.
   */
  @JsonProperty("connectionPointSpecification")
  private List<@Valid ConnectionPointSpecificationRef> connectionPointSpecifications;

  /**
   * Internal connectivity potential specifications.
   */
  @JsonProperty("connectivitySpecification")
  private List<@Valid ResourceGraphSpecification> connectivitySpecifications;

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * A list of Features for this specification.
   */
  @JsonProperty("featureSpecification")
  private List<@Valid FeatureSpecification> featureSpecifications;

  /**
   * A flag indicates that if this resource function specification is a bundled
   * specification (true) or single (false).
   */
  private Boolean isBundle;

  /**
   * Used to indicate the current lifecycle status of the resource specification.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;

  /**
   * A related party defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A characteristic quality or distinctive feature of a ResourceSpecification.
   * The characteristic can be take on a discrete description, such as color, can
   * take on a range of values, (for example, sensitivity of 100-240 mV), or can
   * be derived from a formula (for example, usage time (hrs) = 30 - talk time
   * *3). Certain characteristics, such as color, may be configured during the
   * ordering or some other process.
   */
  @JsonProperty("resourceSpecCharacteristic")
  private List<@Valid ResourceSpecificationCharacteristic> resourceSpecCharacteristics;

  /**
   * A migration, substitution, dependency or exclusivity relationship
   * between/among resource specifications.
   */
  @JsonProperty("resourceSpecRelationship")
  private List<@Valid ResourceSpecificationRelationship> resourceSpecRelationships;

  /**
   * A target resource schema reference. The reference object to the schema and
   * type of target resource which is described by resource specification.
   */
  private @Valid TargetResourceSchema targetResourceSchema;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;

  /**
   * Resource Specification version.
   */
  private @SafeText String version;
}