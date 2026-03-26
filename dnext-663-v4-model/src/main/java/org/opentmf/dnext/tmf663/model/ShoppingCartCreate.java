package org.opentmf.dnext.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf663.model.IShoppingCartCreate;

/**
 * The ShoppingCart to be created.
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
    defaultImpl = ShoppingCartCreate.class
)
public class ShoppingCartCreate extends ShoppingCartUpdate implements IShoppingCartCreate {

  /**
   * Total amount of the shopping cart, usually of money, that represents the
   * actual price paid by the Customer for cart (considering only "Active" cart
   * items).
   */
  @JsonProperty("cartTotalPrice")
  private List<@Valid CartPrice> cartTotalPrices;

  private @Valid TimePeriod validFor;
}