package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The ProductCharacteristic to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> valueType<br/>
 * </p>
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
    defaultImpl = ProductCharacteristicCreate.class
)
@Required(fields = {"valueType"})
public class ProductCharacteristicCreate extends ProductCharacteristicUpdate {

  /**
   * This field is custom non unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}