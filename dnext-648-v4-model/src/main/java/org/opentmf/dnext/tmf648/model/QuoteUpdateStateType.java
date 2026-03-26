package org.opentmf.dnext.tmf648.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * State values for QuoteUpdate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum QuoteUpdateStateType {

  IN_PROGRESS("inProgress"),
  PENDING("pending"),
  CANCELLED("cancelled"),
  APPROVED("approved"),
  ACCEPTED("accepted"),
  REJECTED("rejected");

  private final String value;

  QuoteUpdateStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, QuoteUpdateStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (QuoteUpdateStateType quoteUpdateStateType : values()) {
      REVERSE_MAP.put(quoteUpdateStateType.getValue(), quoteUpdateStateType);
    }
  }

  @JsonCreator
  public static QuoteUpdateStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
