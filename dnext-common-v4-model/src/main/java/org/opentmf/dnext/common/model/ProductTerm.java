package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IProductTerm;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Description of a productTerm linked to this product. This represents a
 * commitment with a duration.
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
    defaultImpl = ProductTerm.class
)
public class ProductTerm extends NamedEntity implements IProductTerm {

  /**
   * Description of the productTerm.
   */
  private @SafeText String description;

  /**
   * Duration of the productTerm.
   */
  private @Valid Quantity duration;

  /**
   * productTerm validity period.
   */
  private @Valid TimePeriod validFor;
}