package org.opentmf.dnext.tmf673.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * State values for GeographicAddress.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum GeographicAddressStateType {

  ACCEPTED("accepted"),
  TERMINATED_WITH_ERROR("terminatedWithError"),
  IN_PROGRESS("inProgress"),
  DONE("done");

  private final String value;

  GeographicAddressStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, GeographicAddressStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (GeographicAddressStateType geographicAddressStateType : values()) {
      REVERSE_MAP.put(geographicAddressStateType.getValue(), geographicAddressStateType);
    }
  }

  @JsonCreator
  public static GeographicAddressStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
