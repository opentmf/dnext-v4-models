package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Attachment;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.ProductSpecificationExtension;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.ResourceSpecificationRef;
import org.opentmf.dnext.common.model.ServiceSpecificationRef;
import org.opentmf.dnext.common.model.TargetProductSchema;
import org.opentmf.dnext.product.model.BundledProductSpecification;
import org.opentmf.dnext.product.model.CatalogUpdateBase;
import org.opentmf.dnext.product.model.ProductSpecificationCharacteristic;
import org.opentmf.dnext.product.model.ProductSpecificationRelationship;

/**
 * The ProductSpecification to be updated.
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
    defaultImpl = ProductSpecificationUpdate.class
)
public class ProductSpecificationUpdate extends CatalogUpdateBase {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid Attachment> attachments;

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

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * isBundle determines whether a productSpecification represents a single
   * productSpecification (false), or a bundle of productSpecification (true).
   */
  private Boolean isBundle;

  private @Valid ProductSpecificationExtension pExtension;

  private @Valid ProductSpecificationExtension pextension;

  /**
   * An identification number assigned to uniquely identity the specification.
   */
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

  public ProductSpecificationExtension getPExtension() {
    return pExtension;
  }

  public void setPExtension(ProductSpecificationExtension pExtension) {
    this.pExtension = pExtension;
  }

  public ProductSpecificationExtension getPextension() {
    return pextension;
  }

  public void setPextension(ProductSpecificationExtension pextension) {
    this.pextension = pextension;
  }
}