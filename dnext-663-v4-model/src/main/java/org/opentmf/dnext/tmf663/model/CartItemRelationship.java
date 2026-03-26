package org.opentmf.dnext.tmf663.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.tmf663.model.ICartItemRelationship;

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
public class CartItemRelationship extends Entity implements ICartItemRelationship {

  private @SafeText String relationshipType;
}