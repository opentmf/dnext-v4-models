package org.opentmf.dnext.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.ProductSpecificationExtension;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.ResourceSpecificationRef;
import org.opentmf.dnext.common.model.ServiceSpecificationRef;
import org.opentmf.dnext.common.model.TargetProductSchema;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.product.model.IProductSpecification;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = ProductSpecification.class
)
public class ProductSpecification extends BundledProductSpecification implements IProductSpecification {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * A list of attachments (Attachment [*]). Complements the
   * <br/>description of an element (for instance a product)
   * <br/>through video, pictures..
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * The manufacturer or trademark of the specification.
   */
  private @SafeText String brand;

  /**
   * A list of bundled product specifications
   * <br/>(BundledProductSpecification [*]). A type of
   * <br/>ProductSpecification that belongs to a grouping of
   * <br/>ProductSpecifications made available to the market. It
   * <br/>inherits of all attributes of ProductSpecification.
   */
  @JsonProperty("bundledProductSpecification")
  private List<@Valid BundledProductSpecification> bundledProductSpecifications;

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * Description of this entity.
   */
  private @SafeText String description;

  /**
   * External reference of the individual or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Bundle determines whether a
   * <br/>productSpecification represents a single (false),or a bundle (true).
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

  private @Valid ProductSpecificationExtension pExtension;

  /**
   * An identification number assigned to uniquely
   * <br/>identity the specification.
   */
  private @SafeText String productNumber;

  /**
   * A list of product spec characteristics
   * <br/>(ProductSpecCharacteristic [*]). A characteristic quality
   * <br/>or distinctive feature of a ProductSpecification. The
   * <br/>characteristic can be take on a discrete value, such as
   * <br/>color, can take on a range of values, (for example,
   * <br/>sensitivity of 100-240 mV), or can be derived from a
   * <br/>formula (for example, usage time (hrs) = 30 - talk time*3). Certain
   * characteristics, such as color, may be
   * <br/>configured during the ordering or some other process.
   */
  @JsonProperty("productSpecCharacteristic")
  private List<@Valid ProductSpecificationCharacteristic> productSpecCharacteristics;

  /**
   * A list of product specification relationships
   * <br/>(ProductSpecificationRelationship [*]). A migration,
   * <br/>substitution, dependency or exclusivity relationship
   * <br/>between/among product specifications.
   */
  @JsonProperty("productSpecificationRelationship")
  private List<@Valid ProductSpecificationRelationship> productSpecificationRelationships;

  /**
   * A list of related party references (RelatedPartyRef [*]).
   * <br/>A related party defines party or party role linked to a
   * <br/>specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A list of resource specification references
   * <br/>(ResourceSpecificationRef [*]). The
   * <br/>ResourceSpecification is required to realize a
   * <br/>ProductSpecification.
   */
  @JsonProperty("resourceSpecification")
  private List<@Valid ResourceSpecificationRef> resourceSpecifications;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * A list of service specification references
   * <br/>(ServiceSpecificationRef [*]). ServiceSpecification(s)
   * <br/>required to realize a ProductSpecification.
   */
  @JsonProperty("serviceSpecification")
  private List<@Valid ServiceSpecificationRef> serviceSpecifications;

  /**
   * The reference object to the schema and type of target product which is
   * described by product specification.
   */
  private @Valid TargetProductSchema targetProductSchema;

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
}