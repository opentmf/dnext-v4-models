package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CharacteristicValueSpecification (620, 633, 634, 658)</li>
 *   <li>FeatureSpecificationCharacteristic (633, 634)</li>
 *   <li>FeatureSpecificationCharacteristicValue (634)</li>
 *   <li>ResourceSpecificationCharacteristicValue (634)</li>
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
    defaultImpl = CharacteristicValueSpecificationBase.class
)
public abstract class CharacteristicValueSpecificationBase extends Extensible {

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
   * A kind of value that the characteristic value can take on, such as numeric,
   * text and so forth.
   */
  private @SafeText String valueType;
}