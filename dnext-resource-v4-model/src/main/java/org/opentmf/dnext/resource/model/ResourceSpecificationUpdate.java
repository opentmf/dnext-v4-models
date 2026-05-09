package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.FeatureSpecification;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.ResourceSpecificationExtension;
import org.opentmf.dnext.common.model.SpecificationBase;
import org.opentmf.dnext.common.model.TargetResourceSchema;
import org.opentmf.resource.model.IResourceSpecificationUpdate;

/**
 * The ResourceSpecification to be updated.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ResourceSpecificationUpdate.class
)
public class ResourceSpecificationUpdate extends SpecificationBase implements IResourceSpecificationUpdate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Complements the description of an element (for instance a resource) through
   * video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A type of ResourceSpecification that belongs to a grouping of
   * ResourceSpecifications made available to the market. It inherits of all
   * attributes of ResourceSpecification.
   */
  @JsonProperty("bundledResourceSpecification")
  private List<@Valid BundledResourceSpecification> bundledResourceSpecifications;

  /**
   * Category of the target resource like NetworkConnectivity, PhysicalLinks,
   * Generic, L2Network and so on.
   */
  private @SafeText String category;

  /**
   * A list of Features for this specification.
   */
  @JsonProperty("featureSpecification")
  private List<@Valid FeatureSpecification> featureSpecifications;

  /**
   * ResourceSpecification model has been extended.
   */
  private @Valid ResourceSpecificationExtension pExtension;

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
}