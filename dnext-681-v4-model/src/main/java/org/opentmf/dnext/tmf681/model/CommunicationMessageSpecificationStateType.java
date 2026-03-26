package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * State values for CommunicationMessageSpecification.
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
public enum CommunicationMessageSpecificationStateType {

  WORKING("working"),
  ACTIVE("active"),
  INACTIVE("inactive");

  private final String value;

  CommunicationMessageSpecificationStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CommunicationMessageSpecificationStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (CommunicationMessageSpecificationStateType communicationMessageSpecificationStateType : values()) {
      REVERSE_MAP.put(communicationMessageSpecificationStateType.getValue(), communicationMessageSpecificationStateType);
    }
  }

  @JsonCreator
  public static CommunicationMessageSpecificationStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
