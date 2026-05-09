package org.opentmf.dnext.tmf673.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.general.model.GeographicAddress;
import org.opentmf.tmf673.model.IGeographicAddressValidationUpdate;

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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = GeographicAddressValidationUpdate.class
)
public class GeographicAddressValidationUpdate extends GeographicAddressValidationCreate implements IGeographicAddressValidationUpdate {

  /**
   * List of: Structured textual way of describing how to find a Property in an
   * urban area (country properties are often defined differently). Note : Address
   * corresponds to SID UrbanPropertyAddress.
   */
  @JsonProperty("alternateGeographicAddress")
  private List<@Valid GeographicAddress> alternateGeographicAddresses;

  /**
   * Geographic address validation update request state
   * <br/><p>Recommended values: accepted, terminatedWithError, inProgress, done.
   *
   * @see org.opentmf.dnext.tmf673.model.GeographicAddressStateType
   */
  private @SafeText String state;

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