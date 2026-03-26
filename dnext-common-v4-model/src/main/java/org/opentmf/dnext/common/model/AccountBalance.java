package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAccountBalance;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Balances linked to the account.
 *
 * <p><br/>
 * <strong>Required:</strong> amount, balanceType, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = AccountBalance.class
)
@Required(fields = {"amount", "balanceType", "validFor"})
public class AccountBalance extends Entity implements IAccountBalance {

  /**
   * Balance amount.
   */
  private @Valid Money amount;

  /**
   * Type of the balance : deposit balance, disputed balance, loyalty balance,
   * receivable balance...
   */
  private @SafeText String balanceType;

  /**
   * Balance validity period.
   */
  private @Valid TimePeriod validFor;
}