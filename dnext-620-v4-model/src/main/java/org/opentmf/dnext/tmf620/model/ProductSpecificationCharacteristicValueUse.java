package org.opentmf.dnext.tmf620.model;

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
import org.opentmf.dnext.common.model.ProductSpecificationRef;
import org.opentmf.tmf620.model.IProductSpecificationCharacteristicValueUse;

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
    defaultImpl = ProductSpecificationCharacteristicValueUse.class
)
public class ProductSpecificationCharacteristicValueUse extends CharacteristicBase implements IProductSpecificationCharacteristicValueUse {

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
   * A list of product spec characteristic values
   * <br/>(ProductSpecCharacteristicValue [1..*]). A number or
   * <br/>text that can be assigned to a
   * <br/>ProductSpecCharacteristic.
   */
  @JsonProperty("productSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> productSpecCharacteristicValues;

  /**
   * A product specification reference
   * <br/>(ProductSpecificationRef). A ProductSpecification is a
   * <br/>detailed description of a tangible or intangible object
   * <br/>made available externally in the form of a
   * <br/>ProductOffering to customers or other parties playing a
   * <br/>party role.
   */
  private @Valid ProductSpecificationRef productSpecification;

  /**
   * This (optional) field provides a link to the schema describing the value
   * type.
   */
  private URI valueSchemaLocation;
}