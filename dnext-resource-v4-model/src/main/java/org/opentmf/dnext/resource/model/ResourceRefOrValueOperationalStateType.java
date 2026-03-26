package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * OperationalState values for ResourceRefOrValue.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ResourceRefOrValueOperationalStateType {

  ENABLE("enable"),
  DISABLE("disable");

  private final String value;

  ResourceRefOrValueOperationalStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ResourceRefOrValueOperationalStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ResourceRefOrValueOperationalStateType resourceRefOrValueOperationalStateType : values()) {
      REVERSE_MAP.put(resourceRefOrValueOperationalStateType.getValue(), resourceRefOrValueOperationalStateType);
    }
  }

  @JsonCreator
  public static ResourceRefOrValueOperationalStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
