package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * UsageState values for ResourceRefOrValue.
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
public enum ResourceRefOrValueUsageStateType {

  IDLE("idle"),
  ACTIVE("active"),
  BUSY("busy");

  private final String value;

  ResourceRefOrValueUsageStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ResourceRefOrValueUsageStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ResourceRefOrValueUsageStateType resourceRefOrValueUsageStateType : values()) {
      REVERSE_MAP.put(resourceRefOrValueUsageStateType.getValue(), resourceRefOrValueUsageStateType);
    }
  }

  @JsonCreator
  public static ResourceRefOrValueUsageStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
