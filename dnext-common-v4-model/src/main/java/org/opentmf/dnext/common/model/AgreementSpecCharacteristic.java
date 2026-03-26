package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAgreementSpecCharacteristic;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A characteristic quality or distinctive feature of an agreement.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = AgreementSpecCharacteristic.class
)
public class AgreementSpecCharacteristic extends NamedEntity implements IAgreementSpecCharacteristic {

  /**
   * If true, the Boolean indicates that the characteristic is configurable.
   */
  private Boolean configurable;

  /**
   * A narrative that explains in detail what the characteristic is.
   */
  private @SafeText String description;

  /**
   * List of: A number or text that can be assigned to an agreement specification
   * characteristic.
   */
  @JsonProperty("specCharacteristicValue")
  private List<@Valid AgreementSpecCharacteristicValue> specCharacteristicValues;

  private @Valid TimePeriod validFor;

  /**
   * A kind of value that the characteristic can take on, such as numeric, text
   * and so forth.
   */
  private @SafeText String valueType;
}