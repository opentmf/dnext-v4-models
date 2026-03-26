package org.opentmf.dnext.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.customer.model.CreateBase;

/**
 * A cash method of payment. It has no additional data, but it could be extended
 * to add information e.g.: the cashier who took the payment, the person who
 * paid, etc.
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
    defaultImpl = CashCreate.class
)
@Required(fields = {"atType"})
public class CashCreate extends CreateBase {

  /**
   * Reference to the customer or party that owns that payment method or can use
   * it.
   */
  private @Valid RelatedParty relatedParty;
}