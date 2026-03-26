package org.opentmf.dnext.tmf673.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.general.model.GeographicAddress;

/**
 * The GeographicAddressValidation to be updated.
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
public class GeographicAddressValidationUpdate {

  /**
   * List of: Structured textual way of describing how to find a Property in an
   * urban area (country properties are often defined differently). Note : Address
   * corresponds to SID UrbanPropertyAddress.
   */
  @JsonProperty("alternateGeographicAddress")
  private List<@Valid GeographicAddress> alternateGeographicAddresses;

  /**
   * Indicator provided by the requester to specify if alternate addresses must be
   * provided in case of partial or fail result.
   */
  private Boolean provideAlternative;

  /**
   * Geographic address validation update request state
   * <br/><p>Recommended values: accepted, terminatedWithError, inProgress, done.
   *
   * @see org.opentmf.dnext.tmf673.model.GeographicAddressStateType
   */
  private @SafeText String state;

  /**
   * the address as submitted to validation.
   */
  private @Valid GeographicAddress submittedGeographicAddress;

  /**
   * the correct form of the validated address in case of validation success.
   */
  private @Valid GeographicAddress validGeographicAddress;

  /**
   * Date when the address validation is performed.
   */
  private OffsetDateTime validationDate;

  /**
   * Result of the address validation (success, partial, fails).
   */
  private @SafeText String validationResult;
}