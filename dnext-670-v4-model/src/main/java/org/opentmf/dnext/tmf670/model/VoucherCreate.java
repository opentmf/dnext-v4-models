package org.opentmf.dnext.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.PaymentMethodUpdate;
import org.opentmf.dnext.common.model.Quantity;

/**
 * A voucher method of payment.
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
    defaultImpl = VoucherCreate.class
)
@Required(fields = {"atType"})
public class VoucherCreate extends PaymentMethodUpdate {

  /**
   * Campaign this voucher belongs to.
   */
  private @SafeText String campaign;

  /**
   * Code that identifies the voucher.
   */
  private @SafeText String code;

  /**
   * The discount that the voucher applies when it's a discount voucher.
   */
  private @SafeText String discount;

  /**
   * The voucher's expiration date.
   */
  private OffsetDateTime expirationDate;

  /**
   * The value of the voucher.
   */
  private @Valid Quantity value;
}