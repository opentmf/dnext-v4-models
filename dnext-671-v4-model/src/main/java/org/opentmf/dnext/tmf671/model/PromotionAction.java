package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.EntityRef;
import org.opentmf.tmf671.model.IPromotionAction;

/**
 * Action of the promotion. When the customer meets the conditions in the
 * promotion pattern, the customer can be given the benefits in the action.
 *
 * <p><br/>
 * <strong>Required:</strong> actionType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
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
    defaultImpl = PromotionAction.class
)
@Required(fields = {"actionType"})
public class PromotionAction extends Entity implements IPromotionAction {

  /**
   * It refers to the entity which is impacted by the promotion action.  • When
   * the Promotion type is 1: Award, the actionEntityRef is the party account;  •
   * When the Promotion type is 2: Discount, it is the product offering;  • When
   * the Promotion type is 3: Reduction, it is the product offering also.
   */
  private @Valid EntityRef actionEntityRef;

  /**
   * Action type can be one of the following: voice (minute), data (MB), data
   * (GB), SMS, bonus point, physical gift, voucher, promotion code, an existing
   * offering, currency.
   */
  private @SafeText String actionType;

  /**
   * When the Promotion type is 1: Award, it means the amount or value of the
   * awards decided by actionType, such as: Amount of gift, Amount of bonus, Value
   * of discount;  • When the Promotion type is 2: Discount, it means the value of
   * the discount;  • When the Promotion type is 3: reduction, it means the value
   * of the reduced money.
   */
  private @SafeText String actionValue;
}