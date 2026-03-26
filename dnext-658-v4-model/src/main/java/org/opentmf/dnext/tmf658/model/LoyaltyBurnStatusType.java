package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Status values for LoyaltyBurn.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum LoyaltyBurnStatusType {

  RECEIVED("received"),
  REJECTED("rejected"),
  RECYCLED("recycled"),
  GUIDED("guided"),
  RATED("rated"),
  RERATED("rerated"),
  BILLED("billed");

  private final String value;

  LoyaltyBurnStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, LoyaltyBurnStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (LoyaltyBurnStatusType loyaltyBurnStatusType : values()) {
      REVERSE_MAP.put(loyaltyBurnStatusType.getValue(), loyaltyBurnStatusType);
    }
  }

  @JsonCreator
  public static LoyaltyBurnStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
