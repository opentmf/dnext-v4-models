package org.opentmf.dnext.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A bank card method of payment.
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
    defaultImpl = BankCardCreate.class
)
@Required(fields = {"atType"})
public class BankCardCreate extends OtherCreate {

  /**
   * The bank that issued the card.
   */
  private @SafeText String bank;

  /**
   * The card brand.
   */
  private @SafeText String brand;

  /**
   * The bank card number.
   */
  private @SafeText String cardNumber;

  /**
   * The type of card e.g. Credit, debit etc.
   */
  private @SafeText String cardType;

  /**
   * The security code (e.g.: CVV, CVV2) of the card.
   */
  private @SafeText String cvv;

  /**
   * Expiration date of the bank card.
   */
  private OffsetDateTime expirationDate;

  /**
   * The last four digits of the credit card.
   */
  private @SafeText String lastFourDigits;

  /**
   * The name on the card.
   */
  private @SafeText String nameOnCard;
}