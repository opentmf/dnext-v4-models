package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IProductRelationship;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Linked products to the one instantiate, such as [bundled] if the product is a
 * bundle and you want to describe the bundled products inside this bundle;
 * [reliesOn] if the product needs another already owned product to rely on
 * (e.g. an option on an already owned mobile access product) [targets] or
 * [isTargeted] (depending on the way of expressing the link) for any other kind
 * of links that may be useful.
 *
 * <p><br/>
 * <strong>Required:</strong> product, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = ProductRelationship.class
)
@Required(fields = {"product", "relationshipType"})
public class ProductRelationship extends CharacteristicRelationship implements IProductRelationship {

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue product;
}