package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CharacteristicSpecification (633, 667)</li>
 *   <li>ProductSpecificationCharacteristic (620, 658)</li>
 *   <li>ProductSpecificationCharacteristicValueUse (620)</li>
 *   <li>ResourceSpecificationCharacteristic (634)</li>
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
    defaultImpl = CharacteristicBase.class
)
public abstract class CharacteristicBase extends Extensible {

  /**
   * Characteristic value type such as simple, choice, range.
   */
  private @SafeText String characteristicType;

  /**
   * If true, the Boolean indicates that the target Characteristic is
   * configurable.
   */
  private Boolean configurable;

  /**
   * A narrative that explains the CharacteristicSpecification.
   */
  private @SafeText String description;

  /**
   * An indicator that specifies that the values for the characteristic can be
   * extended by adding new values when instantiating a characteristic for a
   * resource.
   */
  private Boolean extensible;

  /**
   * Reference of the entity.
   */
  private URI href;

  /**
   * Unique ID for the characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * An indicator that specifies if a value is unique for the specification.
   * Possible values are; "unique while value is in effect" and "unique whether
   * value is in effect or not".
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
   * The maximum number of instances a CharacteristicValue can take on. For
   * example, zero to five phone numbers in a group calling plan, where five is
   * the value for the maxCardinality.
   */
  private Integer maxCardinality;

  /**
   * The minimum number of instances a CharacteristicValue can take on. For
   * example, zero to five phone numbers in a group calling plan, where zero is
   * the value for the minCardinality.
   */
  private Integer minCardinality;

  /**
   * A word, term, or phrase by which this characteristic specification is known
   * and distinguished from other characteristic specifications.
   */
  private @SafeText String name;

  /**
   * A rule or principle represented in regular expression used to derive the
   * value of a characteristic value.
   */
  private @SafeText String regex;

  /**
   * The period of time for which a characteristic is applicable.
   */
  private @Valid TimePeriod validFor;

  /**
   * A kind of value that the characteristic can take on, such as numeric, text
   * and so forth.
   */
  private @SafeText String valueType;
}