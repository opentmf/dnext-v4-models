package org.opentmf.dnext.tmf634.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.CharacteristicValueSpecificationBase;

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
public class ResourceSpecificationCharacteristicValue extends CharacteristicValueSpecificationBase {

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
}