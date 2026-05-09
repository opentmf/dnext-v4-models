package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ICartItemRelationship;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Relationship among cart items mainly other than hierarchical relationships
 * such as "RelyOn", "DependentOn", "Shipping" etc.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-663: Shopping Cart Management API</li>
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
    defaultImpl = CartItemRelationship.class
)
public class CartItemRelationship extends Extensible implements ICartItemRelationship {

  /**
   * Hyperlink reference.
   */
  private URI href;

  @SafeId
  @Size(max = 100)
  private String id;

  private @SafeText String relationshipType;
}