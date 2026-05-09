package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.FinancialAccountRef;
import org.opentmf.dnext.common.model.PaymentMethodRef;
import org.opentmf.dnext.partner.model.PartyAccountUpdateBase;
import org.opentmf.tmf666.model.IBillingAccountUpdate;

/**
 * The BillingAccount to be updated.
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
    defaultImpl = BillingAccountUpdate.class
)
@Required(fields = {"name", "relatedParty"})
public class BillingAccountUpdate extends PartyAccountUpdateBase implements IBillingAccountUpdate {

  /**
   * The structure of the bill for party accounts (billing or settlement).
   */
  private @Valid BillStructure billStructure;

  /**
   * A medium characteristic (MediumCharacteristic). Any additional
   * characteristic(s) of this contact medium.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * A payment method defines a specific mean of payment (e.g. direct debit).
   */
  private @Valid PaymentMethodRef defaultPaymentMethod;

  /**
   * An account of money owed by a party to another entity in exchange for goods
   * or services that have been delivered or used. An account receivable
   * aggregates the amounts of one or more party accounts (billing or settlement)
   * owned by a given party.
   */
  private @Valid FinancialAccountRef financialAccount;

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
   * The type of the Rating.
   */
  private @SafeText String ratingType;

  /**
   * A list of account tax exemptions (AccountTaxExemption [*]). Proof of freedom
   * from taxes imposed by a taxing jurisdiction.
   */
  @JsonProperty("taxExemption")
  private List<@Valid AccountTaxExemption> taxExemptions;
}