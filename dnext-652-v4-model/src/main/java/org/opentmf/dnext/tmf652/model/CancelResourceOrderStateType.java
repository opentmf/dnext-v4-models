package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * State values for CancelResourceOrder.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum CancelResourceOrderStateType {

  ACKNOWLEDGED("acknowledged"),
  TERMINATED_WITH_ERROR("terminatedWithError"),
  IN_PROGRESS("inProgress"),
  DONE("done"),
  REJECTED("rejected");

  private final String value;

  CancelResourceOrderStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CancelResourceOrderStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (CancelResourceOrderStateType cancelResourceOrderStateType : values()) {
      REVERSE_MAP.put(cancelResourceOrderStateType.getValue(), cancelResourceOrderStateType);
    }
  }

  @JsonCreator
  public static CancelResourceOrderStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
