package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Status values for LoyaltyProgramProduct.
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
public enum LoyaltyProgramProductStatusType {

  CREATED("created"),
  PENDING_ACTIVE("pendingActive"),
  CANCELLED("cancelled"),
  ACTIVE("active"),
  PENDING_TERMINATE("pendingTerminate"),
  TERMINATED("terminated"),
  SUSPENDED("suspended"),
  ABORTED("aborted");

  private final String value;

  LoyaltyProgramProductStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, LoyaltyProgramProductStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (LoyaltyProgramProductStatusType loyaltyProgramProductStatusType : values()) {
      REVERSE_MAP.put(loyaltyProgramProductStatusType.getValue(), loyaltyProgramProductStatusType);
    }
  }

  @JsonCreator
  public static LoyaltyProgramProductStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
