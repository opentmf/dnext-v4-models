package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * TemplateEngine values for CommunicationMessageTemplate.
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
public enum CommunicationMessageTemplateTemplateEngineType {

  THYMELEAF("thymeleaf");

  private final String value;

  CommunicationMessageTemplateTemplateEngineType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CommunicationMessageTemplateTemplateEngineType> REVERSE_MAP = new HashMap<>();

  static {
    for (CommunicationMessageTemplateTemplateEngineType communicationMessageTemplateTemplateEngineType : values()) {
      REVERSE_MAP.put(communicationMessageTemplateTemplateEngineType.getValue(), communicationMessageTemplateTemplateEngineType);
    }
  }

  @JsonCreator
  public static CommunicationMessageTemplateTemplateEngineType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
