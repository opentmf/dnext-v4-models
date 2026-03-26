package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf632.model.IOrganizationIdentification;

/**
 * Represents our registration of information used as proof of identity by an
 * organization.
 *
 * <p><br/>
 * <strong>Required:</strong> identificationId, identificationType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = OrganizationIdentification.class
)
@Required(fields = {"identificationType", "identificationId"})
public class OrganizationIdentification extends Entity implements IOrganizationIdentification {

  /**
   * An attachment by value or by reference. An attachment complements the
   * description of an element, for example through a document, a video, a
   * picture.
   */
  private @Valid AttachmentRefOrValue attachment;

  /**
   * The identity card document number.
   */
  private @SafeText String documentNumber;

  /**
   * Identifier.
   */
  @SafeId
  @Size(max = 100)
  private String identificationId;

  /**
   * Type of identification information used to identify the company in a country
   * or internationally.
   */
  private @SafeText String identificationType;

  /**
   * Authority which has issued the identifier (chamber of commerce...).
   */
  private @SafeText String issuingAuthority;

  /**
   * Date at which the identifier was issued.
   */
  private OffsetDateTime issuingDate;

  private @Valid TimePeriod validFor;
}