package org.opentmf.dnext.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.ContactMedium;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.RelatedChannel;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CartItem (663)</li>
 *   <li>ProductOrderItem (622)</li>
 *   <li>QuoteCreate (648)</li>
 *   <li>ShoppingCartUpdate (663)</li>
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
    defaultImpl = CartItemBase.class
)
public abstract class CartItemBase extends Extensible {

  /**
   * List of: Related channel to another entity. May be online web, mobile app,
   * social ,etc.
   */
  @JsonProperty("channel")
  private List<@Valid RelatedChannel> channels;

  /**
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * Hyperlink reference.
   */
  private URI href;

  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * List of: If an immediate payment has been done at the product order
   * submission, the payment information are captured and stored (as a reference)
   * in the order.
   */
  @JsonProperty("payment")
  private List<@Valid PaymentRef> payments;
}