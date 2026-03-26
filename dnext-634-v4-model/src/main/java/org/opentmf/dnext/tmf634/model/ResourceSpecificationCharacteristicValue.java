package org.opentmf.dnext.tmf634.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.TimePeriod;

/**
 * A number or text that can be assigned to a ResourceSpecCharacteristic.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = ResourceSpecificationCharacteristicValue.class
)
public class ResourceSpecificationCharacteristicValue extends Extensible {

  /**
   * If true, the Boolean Indicates if the value is the default value for a
   * characteristic.
   */
  private Boolean isDefault;

  /**
   * An indicator that specifies the inclusion or exclusion of the valueFrom and
   * valueTo attributes. If applicable, possible values are "open", "closed",
   * "closedBottom" and "closedTop".
   */
  private @SafeText String rangeInterval;

  /**
   * A regular expression constraint for given value.
   */
  private @SafeText String regex;

  /**
   * A length, surface, volume, dry measure, liquid measure, money, weight, time,
   * and the like. In general, a determinate quantity or magnitude of the kind
   * designated, taken as a standard of comparison for others of the same kind, in
   * assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.
   */
  private @SafeText String unitOfMeasure;

  /**
   * The period of time for which a value is applicable.
   */
  private @Valid TimePeriod validFor;

  /**
   * A discrete value that the characteristic can take on, or the actual value of
   * the characteristic.
   */
  private @SafeText String value;

  /**
   * The low range value that a characteristic can take on.
   */
  private Integer valueFrom;

  /**
   * The upper range value that a characteristic can take on.
   */
  private Integer valueTo;

  /**
   * A kind of value that the characteristic value can take on, such as numeric,
   * text and so forth.
   */
  private @SafeText String valueType;
}