package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IPayment;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The Payment resource represents a performed payment. It contains both
 * information about the payment and the payment method used to perform it.
 *
 * <p><br/>
 * <strong>Required:</strong> account, paymentMethod, totalAmount<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = Payment.class
)
@Required(fields = {"totalAmount", "paymentMethod", "account"})
public class Payment extends PaymentCreate implements IPayment {

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * POI consists of hardware and software which enables a Cardholder and/or an
   * Acceptor to perform a Local Card transaction. This is also referred to as a
   * Physical/EMV Terminal. It may be Attended or Unattended.
   */
  private @Valid PointOfInteraction pointOfInteraction;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}