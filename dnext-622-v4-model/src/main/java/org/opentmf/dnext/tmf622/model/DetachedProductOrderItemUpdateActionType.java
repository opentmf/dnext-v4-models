package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Action values for DetachedProductOrderItemUpdate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum DetachedProductOrderItemUpdateActionType {

  ADD("add"),
  MODIFY("modify"),
  DELETE("delete"),
  NO_CHANGE("noChange"),
  STATUS_CHANGE("statusChange"),
  STATUS_CHANGE_SUSPEND("statusChange.Suspend"),
  STATUS_CHANGE_RESUME("statusChange.Resume"),
  MODIFY_MIGRATION("modify.Migration"),
  MODIFY_TAKEOVER("modify.Takeover"),
  MODIFY_RELOCATION("modify.Relocation");

  private final String value;

  DetachedProductOrderItemUpdateActionType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, DetachedProductOrderItemUpdateActionType> REVERSE_MAP = new HashMap<>();

  static {
    for (DetachedProductOrderItemUpdateActionType detachedProductOrderItemUpdateActionType : values()) {
      REVERSE_MAP.put(detachedProductOrderItemUpdateActionType.getValue(), detachedProductOrderItemUpdateActionType);
    }
  }

  @JsonCreator
  public static DetachedProductOrderItemUpdateActionType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
