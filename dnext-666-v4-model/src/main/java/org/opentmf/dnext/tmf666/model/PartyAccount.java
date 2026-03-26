package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.FinancialAccountRef;
import org.opentmf.dnext.common.model.PaymentMethodRef;
import org.opentmf.tmf666.model.IPartyAccount;

/**
 * Account used for billing or for settlement purposes concerning a given party
 * (an organization or an individual). It is a specialization of entity Account.
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
    defaultImpl = PartyAccount.class
)
@Required(fields = {"name", "relatedParty"})
public class PartyAccount extends FinancialAccount implements IPartyAccount {

  /**
   * The structure of the bill for party accounts.
   */
  private @Valid BillStructure billStructure;

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
   * List of: Defines a plan for payment (when a party wants to spread his
   * payments).
   */
  @JsonProperty("paymentPlan")
  private List<@Valid PaymentPlan> paymentPlans;

  /**
   * The condition of the account, such as due, paid, in arrears.
   */
  private @SafeText String paymentStatus;
}