package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * State values for CommunicationMessage.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-681: Communication Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum CommunicationMessageStateType {

  INITIAL("initial"),
  IN_PROGRESS("inProgress"),
  COMPLETED("completed"),
  CANCELLED("cancelled"),
  FAILED("failed");

  private final String value;

  CommunicationMessageStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CommunicationMessageStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (CommunicationMessageStateType communicationMessageStateType : values()) {
      REVERSE_MAP.put(communicationMessageStateType.getValue(), communicationMessageStateType);
    }
  }

  @JsonCreator
  public static CommunicationMessageStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
