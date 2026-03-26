package org.opentmf.dnext.tmf663.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class ShoppingCartStateChangeEventPayload {

  /**
   * Shopping Cart resource is used for the temporarily selection and reservation
   * of product offerings in e-commerce, call center and retail purchase. Shopping
   * cart supports purchase of both physical and digital goods and service (e.g.
   * handset, telecom network service). Shopping Cart contain list of cart items,
   * a reference to customer (partyRole) or contact medium in case customer not
   * exist, and the total items price including promotions.
   */
  private @Valid ShoppingCart shoppingCart;
}