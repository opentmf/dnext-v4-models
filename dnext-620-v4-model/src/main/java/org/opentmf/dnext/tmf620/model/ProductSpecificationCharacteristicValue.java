package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.TimePeriod;

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
public class ProductSpecificationCharacteristicValue {

  /**
   * This field provides a link to the schema describing extended entity REST
   * resource.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * Indicates the type of entity.
   */
  @JsonProperty("@type")
  private @SafeText String atType;

  /**
   * Indicates if the value is the default value for a
   * <br/>characteristic.
   */
  private Boolean isDefault;

  /**
   * An indicator that specifies the inclusion or exclusion of the
   * <br/>valueFrom and valueTo attributes. If applicable, possible values are
   * <br/>"open", "closed", "closedBottom" and "closedTop".
   */
  private @SafeText String rangeInterval;

  /**
   * Regular expression to define constraint on the allowed
   * <br/>value.
   */
  private @SafeText String regex;

  /**
   * Could be minutes, GB.
   */
  private @SafeText String unitOfMeasure;

  /**
   * The period of time for which a value is applicable.
   */
  private @Valid TimePeriod validFor;

  /**
   * A discrete value that the characteristic can take on. The type of
   * <br/>value is determined by ‘valueType’ characteristic.
   */
  private @SafeText String value;

  /**
   * The low range value that a characteristic can take on.
   */
  private @SafeText String valueFrom;

  /**
   * The upper range value that a characteristic can take on.
   */
  private @SafeText String valueTo;

  /**
   * A kind of value that the characteristic can take on, such as
   * <br/>numeric, text, and so forth.
   */
  private @SafeText String valueType;
}