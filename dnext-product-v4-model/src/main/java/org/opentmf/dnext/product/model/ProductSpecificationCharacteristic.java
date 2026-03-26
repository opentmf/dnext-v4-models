package org.opentmf.dnext.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.CharacteristicBase;
import org.opentmf.dnext.common.model.CharacteristicValueSpecification;
import org.opentmf.product.model.IProductSpecificationCharacteristic;

/**
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
    defaultImpl = ProductSpecificationCharacteristic.class
)
public class ProductSpecificationCharacteristic extends CharacteristicBase implements IProductSpecificationCharacteristic {

  /**
   * This (optional) field provides a link to the schema describing the value
   * type.
   */
  @JsonProperty("@valueSchemaLocation")
  private URI atValueSchemaLocation;

  /**
   * Category of the characteristic.
   */
  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * If true, it indicates that the characteristic value can be changed.
   */
  private Boolean isModifiable;

  /**
   * A list of product spec char relationships
   * <br/>(ProductSpecCharRelationship [*]). An aggregation,migration,
   * substitution, dependency or exclusivity
   * <br/>relationship between/among
   * <br/>productSpecCharacteristics.
   */
  @JsonProperty("productSpecCharRelationship")
  private List<@Valid ProductSpecificationCharacteristicRelationship> productSpecCharRelationships;

  /**
   * A list of product spec characteristic values
   * <br/>(ProductSpecificationCharacteristicValue [*]). A number or text
   * <br/>that can be assigned to a ProductSpecCharacteristic.
   */
  @JsonProperty("productSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> productSpecCharacteristicValues;

  /**
   * This (optional) field provides a link to the schema describing the value
   * type.
   */
  private URI valueSchemaLocation;
}