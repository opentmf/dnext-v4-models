package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.tmf620.model.IProductOfferingPriceRelationship;

/**
 * Describes a non-composite relationship between product offering prices. For
 * example one price might be an discount alteration for another price.
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
    defaultImpl = ProductOfferingPriceRelationship.class
)
@Required(fields = {"id"})
public class ProductOfferingPriceRelationship extends RelatedEntityRefOrValue implements IProductOfferingPriceRelationship {

  /**
   * type of the relationship, for example override, discount, etc.
   */
  private @SafeText String relationshipType;
}