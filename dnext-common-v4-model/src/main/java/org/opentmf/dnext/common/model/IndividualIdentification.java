package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IIndividualIdentification;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents our registration of information used as proof of identity by an
 * individual (passport, national identity card, drivers license, social
 * security number, birth certificate).
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
    defaultImpl = IndividualIdentification.class
)
@Required(fields = {"identificationType", "identificationId"})
public class IndividualIdentification extends Extensible implements IIndividualIdentification {

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
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Identifier.
   */
  @SafeId
  @Size(max = 100)
  private String identificationId;

  /**
   * Identification type (passport, national identity card, drivers license,
   * social security number, birth certificate).
   */
  private @SafeText String identificationType;

  /**
   * Authority which has issued the identifier, such as: social security, town
   * hall.
   */
  private @SafeText String issuingAuthority;

  /**
   * Country which has issued the identifier.
   */
  private @SafeText String issuingCountry;

  /**
   * Date at which the identifier was issued.
   */
  private OffsetDateTime issuingDate;

  private @Valid TimePeriod validFor;
}