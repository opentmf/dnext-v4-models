package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf658.model.ILoyaltyEarn;

/**
 * A specialised event to process direct loyalty points earnings.
 *
 * <p><br/>
 * <strong>Required:</strong> description, loyaltyProgramMember, loyaltyProgramProduct, quantity<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = LoyaltyEarn.class
)
@Required(fields = {"quantity", "loyaltyProgramProduct", "loyaltyProgramMember", "description"})
public class LoyaltyEarn extends LoyaltyEarnCreate implements ILoyaltyEarn {

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

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