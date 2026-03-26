package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.RelationshipBase;

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
    defaultImpl = ProductOfferingPriceCharacteristicRelationship.class
)
public class ProductOfferingPriceCharacteristicRelationship extends RelationshipBase {

  /**
   * The order in which a CharacteristicSpecification appears within another
   * CharacteristicSpecification that defines a grouping of
   * CharacteristicSpecifications.
   */
  private Integer charSpecSeq;
}