package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.BundledFeatureSpecification;
import org.opentmf.dnext.common.model.FeatureSpecification;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TimePeriod;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-resource: resource</li>
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
    defaultImpl = ResourceSpecificationBase.class
)
public abstract class ResourceSpecificationBase extends BundledFeatureSpecification {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Complements the description of an element (for instance a resource) (for
   * instance a resource) through video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Category of the target resource like NetworkConnectivity, PhysicalLinks,
   * Generic, L2Network and so on.
   */
  private @SafeText String category;

  /**
   * Description of this entity.
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
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

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
   * The period for which the entity is valid.
   */
  private @Valid TimePeriod validFor;

  private @SafeText String version;
}