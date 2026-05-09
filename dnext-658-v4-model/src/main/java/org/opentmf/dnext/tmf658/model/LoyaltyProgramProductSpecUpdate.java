package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.ResourceSpecificationRef;
import org.opentmf.dnext.common.model.ServiceSpecificationRef;
import org.opentmf.dnext.common.model.SpecificationBase;
import org.opentmf.dnext.common.model.TargetProductSchema;
import org.opentmf.dnext.product.model.BundledProductSpecification;
import org.opentmf.dnext.product.model.ProductSpecificationCharacteristic;
import org.opentmf.dnext.product.model.ProductSpecificationRelationship;
import org.opentmf.tmf658.model.ILoyaltyProgramProductSpecUpdate;

/**
 * The LoyaltyProgramProductSpec to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = LoyaltyProgramProductSpecUpdate.class
)
public class LoyaltyProgramProductSpecUpdate extends SpecificationBase implements ILoyaltyProgramProductSpecUpdate {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * The manufacturer or trademark of the specification.
   */
  private @SafeText String brand;

  /**
   * A type of ProductSpecification that belongs to a grouping of
   * ProductSpecifications made available to the market. It inherits of all
   * attributes of ProductSpecification.
   */
  @JsonProperty("bundledProductSpecification")
  private List<@Valid BundledProductSpecification> bundledProductSpecifications;

  /**
   * The condition of the product specification, such as active, inactive,
   * planned.
   */
  private @SafeText String lifeCycleStatus;

  /**
   * Collection of Rules.
   */
  @JsonProperty("loyaltyRule")
  private List<@Valid LoyaltyRule> loyaltyRules;

  private @SafeText String productNumber;

  /**
   * A characteristic quality or distinctive feature of a ProductSpecification.
   * The characteristic can be take on a discrete value, such as color, can take
   * on a range of values, (for example, sensitivity of 100-240 mV), or can be
   * derived from a formula (for example, usage time (hrs) = 30 - talk time *3).
   * Certain characteristics, such as color, may be configured during the ordering
   * or some other process.
   */
  @JsonProperty("productSpecCharacteristic")
  private List<@Valid ProductSpecificationCharacteristic> productSpecCharacteristics;

  /**
   * A migration, substitution, dependency or exclusivity relationship
   * between/among product specifications.
   */
  @JsonProperty("productSpecificationRelationship")
  private List<@Valid ProductSpecificationRelationship> productSpecificationRelationships;

  /**
   * The ResourceSpecification is required to realize a ProductSpecification.
   */
  @JsonProperty("resourceSpecification")
  private List<@Valid ResourceSpecificationRef> resourceSpecifications;

  /**
   * ServiceSpecification(s) required to realize a ProductSpecification.
   */
  @JsonProperty("serviceSpecification")
  private List<@Valid ServiceSpecificationRef> serviceSpecifications;

  /**
   * A target product schema reference. The reference object to the schema and
   * type of target product which is described by product specification.
   */
  private @Valid TargetProductSchema targetProductSchema;
}