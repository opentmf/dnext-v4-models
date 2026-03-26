package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * State values for DetachedProductOrderItemUpdate.
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
public enum DetachedProductOrderItemUpdateStateType {

  ACKNOWLEDGED("acknowledged"),
  REJECTED("rejected"),
  PENDING("pending"),
  HELD("held"),
  IN_PROGRESS("inProgress"),
  IN_PROGRESS_PRE_ORDER_ITEM_PLUG_IN_COMPLETED("inProgress.preOrderItemPlugIn.completed"),
  IN_PROGRESS_NESTED_ORDER_COMPLETED("inProgress.nestedOrder.completed"),
  IN_PROGRESS_POST_ORDER_ITEM_PLUG_IN_COMPLETED("inProgress.postOrderItemPlugIn.completed"),
  CANCELLED("cancelled"),
  COMPLETED("completed"),
  FAILED("failed"),
  ASSESSING_CANCELLATION("assessingCancellation"),
  PENDING_CANCELLATION("pendingCancellation");

  private final String value;

  DetachedProductOrderItemUpdateStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, DetachedProductOrderItemUpdateStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (DetachedProductOrderItemUpdateStateType detachedProductOrderItemUpdateStateType : values()) {
      REVERSE_MAP.put(detachedProductOrderItemUpdateStateType.getValue(), detachedProductOrderItemUpdateStateType);
    }
  }

  @JsonCreator
  public static DetachedProductOrderItemUpdateStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
