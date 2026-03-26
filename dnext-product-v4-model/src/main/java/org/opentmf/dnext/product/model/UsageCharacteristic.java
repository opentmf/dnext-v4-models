package org.opentmf.dnext.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.CharacteristicRelationship;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.product.model.IUsageCharacteristic;

/**
 * Provides the value of a given characteristic.
 *
 * <p><br/>
 * <strong>Required:</strong> name, value<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = UsageCharacteristic.class
)
@Required(fields = {"name", "value"})
public class UsageCharacteristic extends NamedEntity implements IUsageCharacteristic {

  /**
   * List of: Another Characteristic that is related to the current
   * Characteristic;.
   */
  @JsonProperty("characteristicRelationship")
  private List<@Valid CharacteristicRelationship> characteristicRelationships;

  /**
   * The value of the characteristic.
   */
  private Object value;

  /**
   * Data type of the value of the characteristic.
   */
  private @SafeText String valueType;
}