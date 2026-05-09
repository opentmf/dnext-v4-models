package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.ProductOfferingRef;
import org.opentmf.dnext.product.model.CatalogUpdateBase;

/**
 * The Category to be updated.
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
    defaultImpl = CategoryUpdate.class
)
public class CategoryUpdate extends CatalogUpdateBase {

  /**
   * External reference of the individual or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * If true, this Boolean indicates that the category is a root of categories.
   */
  private Boolean isRoot;

  /**
   * parent category.
   */
  private @Valid CategoryRef parent;

  /**
   * Unique identifier of the parent category.
   */
  @SafeId
  @Size(max = 100)
  private String parentId;

  /**
   * A product offering represents entities that are orderable from the provider
   * of the catalog, this resource includes pricing information.
   */
  @JsonProperty("productOffering")
  private List<@Valid ProductOfferingRef> productOfferings;

  /**
   * The category resource is used to group product offerings, service and
   * resource candidates in logical containers. Categories can contain other
   * (sub-)categories and/or product offerings.
   */
  @JsonProperty("subCategory")
  private List<@Valid CategoryRef> subCategories;
}