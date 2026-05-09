package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ICharacteristicValueSpecification;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * specification of a value (number or text or an object) that can be assigned
 * to a Characteristic.
 *
 * <p><br/>
 * <strong>Required:</strong> value, valueType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = CharacteristicValueSpecification.class
)
@Required(fields = {"valueType", "value"})
public class CharacteristicValueSpecification extends CharacteristicValueSpecificationBase implements ICharacteristicValueSpecification {

  @JsonProperty("default")
  private Boolean defaultValue;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

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
  private Object value;

  /**
   * The low range value that a characteristic can take on.
   */
  private Integer valueFrom;

  /**
   * The upper range value that a characteristic can take on.
   */
  private Integer valueTo;
}