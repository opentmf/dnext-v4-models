package org.opentmf.dnext.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A digital wallet method of payment.
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
    defaultImpl = DigitalWalletCreate.class
)
@Required(fields = {"atType"})
public class DigitalWalletCreate extends OtherCreate {

  /**
   * Organization, platform or currency backing the wallet (e.g.: PayPal, Yandex,
   * BitCoin…).
   */
  private @SafeText String service;

  /**
   * Account identifier in that service.
   */
  @SafeId
  @Size(max = 100)
  private String walletId;

  /**
   * URI pointing at the digital wallet (e.g.: //paypal.me/johndoe).
   */
  private URI walletUrl;
}