package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.AccountBalance;
import org.opentmf.dnext.partner.model.PartyAccountUpdateBase;
import org.opentmf.tmf666.model.IFinancialAccountUpdate;

/**
 * The FinancialAccount to be updated.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = FinancialAccountUpdate.class
)
@Required(fields = {"name"})
public class FinancialAccountUpdate extends PartyAccountUpdateBase implements IFinancialAccountUpdate {

  /**
   * Balances linked to the account.
   */
  @JsonProperty("accountBalance")
  private List<@Valid AccountBalance> accountBalances;

  /**
   * A list of account tax exemptions (AccountTaxExemption [*]). Proof of freedom
   * from taxes imposed by a taxing jurisdiction.
   */
  @JsonProperty("taxExemption")
  private List<@Valid AccountTaxExemption> taxExemptions;
}