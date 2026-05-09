package org.opentmf.dnext.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.PaymentMethodUpdate;

/**
 * A check method of payment.
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
    defaultImpl = CheckCreate.class
)
@Required(fields = {"atType"})
public class CheckCreate extends PaymentMethodUpdate {

  /**
   * Bank performing the payment of the check.
   */
  private @SafeText String bank;

  /**
   * Unique identifier of the check.
   */
  @SafeId
  @Size(max = 100)
  private String checkId;

  /**
   * Person or entity writing the check.
   */
  private @SafeText String drawer;

  /**
   * Person or entity the check is addressed to.
   */
  private @SafeText String payee;

  /**
   * Date when the check was signed.
   */
  private OffsetDateTime signedDate;
}