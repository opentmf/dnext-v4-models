package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentBase;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.CharacteristicValueSpecification;

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
    defaultImpl = ProductCharacteristic.class
)
public class ProductCharacteristic extends AttachmentBase {

  /**
   * Category of the characteristic.
   */
  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  private @SafeText String characteristicType;

  /**
   * If true, it indicates that the ProductCharacteristic value can be configured
   * at run time by a consumer that uses the catalog to place an order or change
   * product in product inventory.
   */
  private Boolean configurable;

  /**
   * Description of this entity.
   */
  private @SafeText String description;

  /**
   * An indicator that specifies that the values for the characteristic can be
   * extended by adding new values when instantiating a characteristic for a
   * product..
   */
  private Boolean extensible;

  /**
   * If true, it indicates that the characteristic value can be changed.
   */
  private Boolean isModifiable;

  /**
   * An indicator that specifies if a value is unique for the specification.
   * Possible values are; "unique while value is in effectand unique whether value
   * is in effect or not.
   */
  private Boolean isUnique;

  /**
   * Shows entered fields can be seen or not.
   */
  private Boolean isVisible;

  /**
   * Fields are mandatory or not.
   */
  private Boolean mandatory;

  /**
   * The maximum number of instances a CharacteristicValue can take on.
   */
  private Integer maxCardinality;

  /**
   * The minimum number of instances a CharacteristicValue can take on.
   */
  private Integer minCardinality;

  /**
   * A list of product characteristic values (ProductCharacteristicValue [*]). A
   * number or text that can be assigned to a ProductCharacteristic.
   */
  @JsonProperty("productCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> productCharacteristicValues;

  /**
   * A rule or principle represented in regular expression used to derive the
   * value of a characteristiC value.
   */
  private @SafeText String regex;

  /**
   * This (optional) field provides a link to the schema describing the value
   * type.
   */
  private URI valueSchemaLocation;

  /**
   * A kind of value that the characteristic value can take on, such as numeric,
   * text and so forth.
   */
  private @SafeText String valueType;
}