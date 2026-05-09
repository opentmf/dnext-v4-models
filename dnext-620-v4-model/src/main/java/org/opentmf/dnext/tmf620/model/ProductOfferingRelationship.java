package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.product.model.ProductSpecificationRelationship;
import org.opentmf.tmf620.model.IProductOfferingRelationship;

/**
 * A relationship between two product Offerings.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
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
    defaultImpl = ProductOfferingRelationship.class
)
@Required(fields = {"id"})
public class ProductOfferingRelationship extends ProductSpecificationRelationship implements IProductOfferingRelationship {

  /**
   * The association role for the source product offering.
   */
  private @SafeText String role;
}