package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IQuantity;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-666: Account Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-668: Partnership Type</li>
 *   <li>TMF-669: Party Role Management API</li>
 *   <li>TMF-670: Payment Method Management API</li>
 *   <li>TMF-671: Promotion Management API</li>
 *   <li>TMF-681: Communication Management API</li>
 *   <li>TMF-683: Party Interaction Management API</li>
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
    defaultImpl = Quantity.class
)
public class Quantity extends Extensible implements IQuantity {

  /**
   * A quantity of something, typically the total of a thing or
   * <br/>things in number, size, value, extent, or money.
   */
  private BigDecimal amount;

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
   * The unit of measure for the quantity, such as meters, cubic
   * <br/>yards, kilograms [ISO 80000], and the currency referring to.
   */
  private @SafeText String units;
}