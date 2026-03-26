package org.opentmf.dnext.tmf673.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf673.model.IGeographicAddressValidation;

/**
 * This resource is used to manage address validation request and response.
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
public class GeographicAddressValidation extends GeographicAddressValidationUpdate implements IGeographicAddressValidation {

  /**
   * When subclassing, this defines the super-class.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * When subclassing, this defines the subclass entity name.
   */
  @JsonProperty("@type")
  private @SafeText String atType;

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * An URI used to access to the address validation resource.
   */
  private URI href;

  /**
   * Unique identifier of the Address Validation.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}