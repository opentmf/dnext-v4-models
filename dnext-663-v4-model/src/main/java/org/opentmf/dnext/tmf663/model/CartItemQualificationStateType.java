package org.opentmf.dnext.tmf663.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * QualificationState values for CartItem.
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
public enum CartItemQualificationStateType {

  INITIAL("initial"),
  QUALIFIED("qualified"),
  UNQUALIFIED("unqualified");

  private final String value;

  CartItemQualificationStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CartItemQualificationStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (CartItemQualificationStateType cartItemQualificationStateType : values()) {
      REVERSE_MAP.put(cartItemQualificationStateType.getValue(), cartItemQualificationStateType);
    }
  }

  @JsonCreator
  public static CartItemQualificationStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
