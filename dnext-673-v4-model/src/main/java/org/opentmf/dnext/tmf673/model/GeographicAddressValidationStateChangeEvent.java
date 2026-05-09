package org.opentmf.dnext.tmf673.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf673.model.IGeographicAddressValidationStateChangeEvent;

/**
 * The notification data structure.
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
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = GeographicAddressValidationStateChangeEvent.class
)
public class GeographicAddressValidationStateChangeEvent extends QuoteCreateEventBase implements IGeographicAddressValidationStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid GeographicAddressValidationStateChangeEventPayload event;
}