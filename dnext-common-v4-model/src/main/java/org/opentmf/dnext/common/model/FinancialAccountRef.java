package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IFinancialAccountRef;

/**
 * AccountReceivable reference. An account of money owed by a party to another
 * entity in exchange for goods or services that have been delivered or used. An
 * account receivable aggregates the amounts of one or more party accounts
 * (billing or settlement) owned by a given party.
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
    defaultImpl = FinancialAccountRef.class
)
public class FinancialAccountRef extends EntityRef implements IFinancialAccountRef {

  /**
   * An account balance (AccountBalance). Balances linked to the account.
   */
  private @Valid AccountBalance accountBalance;
}