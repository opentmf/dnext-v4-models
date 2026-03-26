package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IServiceSpecification;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * ServiceSpecification is a class that offers characteristics to describe a
 * type of service. Functionally, it acts as a template by which Services may be
 * instantiated. By sharing the same specification, these services would
 * therefore share the same set of characteristics.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ServiceSpecification.class
)
@Required(fields = {"name"})
public class ServiceSpecification extends BundledFeatureSpecification implements IServiceSpecification {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Attachments that may be of relevance to this specification, such as picture,
   * document, media.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A type of ServiceSpecification that belongs to a grouping of
   * ServiceSpecifications made available to the market. It inherits of all
   * attributes of ServiceSpecification.
   */
  @JsonProperty("bundledServiceSpecification")
  private List<@Valid BundledServiceSpecification> bundledServiceSpecifications;

  /**
   * This is a list of constraint references applied to this specification.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Relationship to another specification.
   */
  @JsonProperty("entitySpecRelationship")
  private List<@Valid EntitySpecificationRelationship> entitySpecRelationships;

  /**
   * A list of Features for this specification.
   */
  @JsonProperty("featureSpecification")
  private List<@Valid FeatureSpecification> featureSpecifications;

  /**
   * isBundle determines whether specification represents a single specification
   * (false), or a bundle of specifications (true).
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * ServiceSpecification model has been extended.
   */
  private @Valid ServiceSpecificationExtension pExtension;

  private @Valid ServiceSpecificationExtension pextension;

  /**
   * Parties who manage or otherwise have an interest in this specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A list of resource specification references (ResourceSpecificationRef [*]).
   * The ResourceSpecification is required for a service specification with type
   * ResourceFacingServiceSpecification (RFSS).
   */
  @JsonProperty("resourceSpecification")
  private List<@Valid ResourceSpecificationRef> resourceSpecifications;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * A list of service level specifications related to this service specification,
   * and which will need to be satisfiable for corresponding service instances;
   * e.g. Gold, Platinum.
   */
  @JsonProperty("serviceLevelSpecification")
  private List<@Valid ServiceLevelSpecificationRef> serviceLevelSpecifications;

  /**
   * A list of service specifications related to this specification, e.g.
   * migration, substitution, dependency or exclusivity relationship.
   */
  @JsonProperty("serviceSpecRelationship")
  private List<@Valid ServiceSpecRelationship> serviceSpecRelationships;

  /**
   * List of characteristics that the entity can take.
   */
  @JsonProperty("specCharacteristic")
  private List<@Valid CharacteristicSpecification> specCharacteristics;

  /**
   * Pointer to a schema that defines the target entity.
   */
  private @Valid TargetEntitySchema targetEntitySchema;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;

  /**
   * The period for which the entity is valid.
   */
  private @Valid TimePeriod validFor;

  private @SafeText String version;

  public ServiceSpecificationExtension getPExtension() {
    return pExtension;
  }

  public void setPExtension(ServiceSpecificationExtension pExtension) {
    this.pExtension = pExtension;
  }

  public ServiceSpecificationExtension getPextension() {
    return pextension;
  }

  public void setPextension(ServiceSpecificationExtension pextension) {
    this.pextension = pextension;
  }
}