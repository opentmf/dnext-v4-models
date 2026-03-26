package org.opentmf.dnext.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.tmf670.model.IPaymentMethodCreate;

/**
 * Defines a specific method of payment (e.g. direct debit with all details
 * associated) Skipped properties: id,href.
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
    defaultImpl = PaymentMethodCreate.class
)
@Required(fields = {"atType"})
public class PaymentMethodCreate extends OtherCreate implements IPaymentMethodCreate {

  /**
   * Hyperlink reference.
   */
  private URI href;
}