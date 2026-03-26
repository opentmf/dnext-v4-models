package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AccountRelationship;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Contact;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.FinancialAccountRef;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.dnext.common.model.PaymentMethodRef;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * The SettlementAccount to be updated.
 *
 * <p><br/>
 * <strong>Required:</strong> name, relatedParty<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = SettlementAccountUpdate.class
)
@Required(fields = {"name", "relatedParty"})
public class SettlementAccountUpdate extends BillPresentationMediaUpdate {

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
   * The structure of the bill for party accounts (billing or settlement).
   */
  private @Valid BillStructure billStructure;

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
   * A payment method defines a specific mean of payment (e.g. direct debit).
   */
  private @Valid PaymentMethodRef defaultPaymentMethod;

  /**
   * A list of external references.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * An account of money owed by a party to another entity in exchange for goods
   * or services that have been delivered or used. An account receivable
   * aggregates the amounts of one or more party accounts (billing or settlement)
   * owned by a given party.
   */
  private @Valid FinancialAccountRef financialAccount;

  /**
   * Date of last modification of the account.
   */
  private OffsetDateTime lastModified;

  /**
   * Defines a plan for payment (when a party wants to spread his payments).
   */
  @JsonProperty("paymentPlan")
  private List<@Valid PaymentPlan> paymentPlans;

  /**
   * The condition of the account, such as due, paid, in arrears.
   */
  private @SafeText String paymentStatus;

  /**
   * Related Entity reference. A related party defines party or party role linked
   * to a settlement account.
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

  /**
   * A list of account tax exemptions (AccountTaxExemption [*]). Proof of freedom
   * from taxes imposed by a taxing jurisdiction.
   */
  @JsonProperty("taxExemption")
  private List<@Valid AccountTaxExemption> taxExemptions;
}