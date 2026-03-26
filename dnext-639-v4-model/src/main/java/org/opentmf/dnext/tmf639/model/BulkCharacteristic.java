package org.opentmf.dnext.tmf639.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> name, valueFrom, valueMask, valueTo<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
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
    defaultImpl = BulkCharacteristic.class
)
@Required(fields = {"valueTo", "valueMask", "name", "valueFrom"})
public class BulkCharacteristic extends Extensible {

  private @SafeText String counterType;

  private Boolean isIdentifier;

  /**
   * A boolean to decide if characteristic value must be populated to resource
   * name.
   */
  private Boolean isPopulateCharacteristicValueToResourceName;

  private Boolean isUnique;

  private Boolean isVisible;

  /**
   * The name of the characteristic.
   */
  private @SafeText String name;

  /**
   * A template string that contains an arbitrary number of characters.
   */
  private @SafeText String valueFrom;

  /**
   * A mask value that indicates which part of the valueFrom will be replaced with
   * the encoded counter.
   */
  private @SafeText String valueMask;

  /**
   * A template string that contains an arbitrary number of characters.
   */
  private @SafeText String valueTo;
}