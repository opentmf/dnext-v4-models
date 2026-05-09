package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IShoppingCartRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * It's a Shopping Cart that has been executed previously.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
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
    defaultImpl = ShoppingCartRef.class
)
@Required(fields = {"id"})
public class ShoppingCartRef extends Entity implements IShoppingCartRef {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * Name of the related entity.
   */
  private @SafeText String name;
}