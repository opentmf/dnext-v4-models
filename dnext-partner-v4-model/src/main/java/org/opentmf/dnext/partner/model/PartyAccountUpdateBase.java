package org.opentmf.dnext.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AccountRelationship;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.BillPresentationMediaUpdate;
import org.opentmf.dnext.common.model.Contact;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>BillingAccountUpdate (666)</li>
 *   <li>FinancialAccountUpdate (666)</li>
 *   <li>PartyAccountUpdate (666)</li>
 *   <li>SettlementAccountUpdate (666)</li>
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
    defaultImpl = PartyAccountUpdateBase.class
)
public abstract class PartyAccountUpdateBase extends BillPresentationMediaUpdate {

  /**
   * . Significant connection between accounts. For instance an aggregating
   * account for a list of shop branches each having its own billing account.
   */
  @JsonProperty("accountRelationship")
  private List<@Valid AccountRelationship> accountRelationships;

  /**
   * A categorization of an account, such as individual, joint, and so forth,
   * whose instances share some of the same characteristics. Note: for flexibility
   * we use a String here but an implementation may use an enumeration with a
   * limited list of valid values.
   */
  private @SafeText String accountType;

  /**
   * A list of attachment references.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * An individual or an organization used as a contact point for a given account
   * and accessed via some contact medium.
   */
  @JsonProperty("contact")
  private List<@Valid Contact> contacts;

  /**
   * The maximum amount of money that may be charged on an account.
   */
  private @Valid Money creditLimit;

  /**
   * A list of external references.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Date of last modification of the account.
   */
  private OffsetDateTime lastModified;

  /**
   * Related Entity reference. A related party defines party or party role linked
   * to a billing account.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Contains the lifecycle state such as: Active, Closed, Suspended and so on.
   */
  private @SafeText String state;

  /**
   * Status reason for above status.
   */
  private @SafeText String statusReason;
}