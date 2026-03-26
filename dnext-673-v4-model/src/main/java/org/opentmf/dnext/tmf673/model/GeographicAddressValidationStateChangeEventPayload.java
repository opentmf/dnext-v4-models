package org.opentmf.dnext.tmf673.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf673.model.IGeographicAddressValidationStateChangeEventPayload;

/**
 * The event data structure.
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
public class GeographicAddressValidationStateChangeEventPayload implements IGeographicAddressValidationStateChangeEventPayload {

  /**
   * This resource is used to manage address validation request and response.
   */
  private @Valid GeographicAddressValidation geographicAddressValidation;
}