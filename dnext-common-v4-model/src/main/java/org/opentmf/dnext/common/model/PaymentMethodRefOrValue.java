package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IPaymentMethodRefOrValue;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * link to the resource that holds information about the payment mean used to
 * complete the operation.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-676: Payment Management API</li>
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
    defaultImpl = PaymentMethodRefOrValue.class
)
@Required(fields = {"atType", "name"})
public class PaymentMethodRefOrValue extends PaymentMethod implements IPaymentMethodRefOrValue {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  private Boolean preferred;
}