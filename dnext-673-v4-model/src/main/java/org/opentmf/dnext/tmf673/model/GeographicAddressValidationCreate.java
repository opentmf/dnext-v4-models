package org.opentmf.dnext.tmf673.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.general.model.GeographicAddress;

/**
 * The GeographicAddressValidation to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> provideAlternative, submittedGeographicAddress<br/>
 * </p>
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
@Required(fields = {"provideAlternative", "submittedGeographicAddress"})
public class GeographicAddressValidationCreate {

  /**
   * Unique identifier of the Address Validation.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Indicator provided by the requester to specify if alternate addresses must be
   * provided in case of partial or fail result.
   */
  private Boolean provideAlternative;

  /**
   * the address as submitted to validation.
   */
  private @Valid GeographicAddress submittedGeographicAddress;
}