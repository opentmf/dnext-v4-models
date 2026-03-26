package org.opentmf.dnext.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.AgreementSpecificationRef;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.ProductBase;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.partner.model.IAgreement;

/**
 * An agreement represents a contract or arrangement, either written or verbal
 * and sometimes enforceable by law, such as a service level agreement or a
 * customer price agreement. An agreement involves a number of other business
 * entities, such as products, services, and resources and/or their
 * specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> agreementItem, agreementType, engagedParty, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = Agreement.class
)
@Required(fields = {"agreementType", "name", "agreementItem", "engagedParty"})
public class Agreement extends ProductBase implements IAgreement {

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  /**
   * List of: A business participant that is responsible for approving the
   * agreement.
   */
  @JsonProperty("agreementAuthorization")
  private List<@Valid AgreementAuthorization> agreementAuthorizations;

  /**
   * List of: A part of the agreement expressed in terms of a product offering and
   * possibly including specific terms and conditions.
   */
  @JsonProperty("agreementItem")
  private List<@Valid AgreementItem> agreementItems;

  private @Valid TimePeriod agreementPeriod;

  /**
   * AgreementSpecification reference. An AgreementSpecification represents a
   * template of an agreement that can be used when establishing partnerships.
   */
  private @Valid AgreementSpecificationRef agreementSpecification;

  /**
   * The type of the agreement. For example commercial.
   */
  private @SafeText String agreementType;

  @JsonProperty("associatedAgreement")
  private List<@Valid AgreementRef> associatedAgreements;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  private @Valid TimePeriod completionDate;

  /**
   * Narrative that explains the agreement and details about it, such as why the
   * agreement is taking place.
   */
  private @SafeText String description;

  /**
   * A reference number assigned to an Agreement that follows a prescribed
   * numbering system.
   */
  private Integer documentNumber;

  @JsonProperty("engagedParty")
  private List<@Valid RelatedParty> engagedParties;

  /**
   * A list of external references.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Date at which the agreement was initialized.
   */
  private OffsetDateTime initialDate;

  /**
   * An overview and goals of the Agreement.
   */
  private @SafeText String statementOfIntent;

  /**
   * A string identifying the version of the agreement.
   */
  private @SafeText String version;
}