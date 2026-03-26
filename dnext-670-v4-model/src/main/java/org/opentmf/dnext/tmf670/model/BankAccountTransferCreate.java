package org.opentmf.dnext.tmf670.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A bank transfer method of payment.
 *
 * <p><br/>
 * <strong>Required:</strong> @type<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-670: Payment Method Management API</li>
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
    defaultImpl = BankAccountTransferCreate.class
)
@Required(fields = {"atType"})
public class BankAccountTransferCreate extends OtherCreate {

  /**
   * The Business Identifier Code/Swift code of the financial institution where
   * the account is located.
   */
  @JsonProperty("BIC")
  private @SafeText String bIC;

  /**
   * The bank account number, this could refer to the iban or swift number.
   */
  private @SafeText String accountNumber;

  /**
   * The type of account number (e.g.: IBAN, SWIFT, ...).
   */
  private @SafeText String accountNumberType;

  /**
   * The display name of the bank.
   */
  private @SafeText String bank;

  /**
   * The owner of the bank account. This is also the account name.
   */
  private @SafeText String owner;
}