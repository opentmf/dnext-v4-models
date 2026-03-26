package org.opentmf.dnext.tmf663.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Status values for ShoppingCart.
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
public enum ShoppingCartStatusType {

  CANCELLED("cancelled"),
  COMPLETED("completed"),
  CHECKED_OUT("checkedOut"),
  PARTIALLY_CHECKED_OUT("partiallyCheckedOut"),
  ACTIVE("active");

  private final String value;

  ShoppingCartStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ShoppingCartStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (ShoppingCartStatusType shoppingCartStatusType : values()) {
      REVERSE_MAP.put(shoppingCartStatusType.getValue(), shoppingCartStatusType);
    }
  }

  @JsonCreator
  public static ShoppingCartStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
