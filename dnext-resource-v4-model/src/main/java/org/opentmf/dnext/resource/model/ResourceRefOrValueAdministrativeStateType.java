package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * AdministrativeState values for ResourceRefOrValue.
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
public enum ResourceRefOrValueAdministrativeStateType {

  LOCKED("locked"),
  UNLOCKED("unlocked"),
  SHUTDOWN("shutdown");

  private final String value;

  ResourceRefOrValueAdministrativeStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ResourceRefOrValueAdministrativeStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ResourceRefOrValueAdministrativeStateType resourceRefOrValueAdministrativeStateType : values()) {
      REVERSE_MAP.put(resourceRefOrValueAdministrativeStateType.getValue(), resourceRefOrValueAdministrativeStateType);
    }
  }

  @JsonCreator
  public static ResourceRefOrValueAdministrativeStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
