package org.opentmf.dnext.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.RelationshipBase;
import org.opentmf.product.model.IProductSpecificationCharacteristicRelationship;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = ProductSpecificationCharacteristicRelationship.class
)
@Required(fields = {"id"})
public class ProductSpecificationCharacteristicRelationship extends RelationshipBase implements IProductSpecificationCharacteristicRelationship {

  /**
   * The order in which a CharacteristicSpecification appears
   * <br/>within another CharacteristicSpecification that defines a grouping of
   * <br/>CharacteristicSpecifications.
   */
  private Integer charSpecSeq;
}