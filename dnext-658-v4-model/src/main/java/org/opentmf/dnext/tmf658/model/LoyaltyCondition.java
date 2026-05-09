package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf658.model.ILoyaltyCondition;

/**
 * A condition, comprised of a attribute that will be tested against a value.
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
    defaultImpl = LoyaltyCondition.class
)
public class LoyaltyCondition extends LoyaltyConditionUpdate implements ILoyaltyCondition {

  private @SafeText String baseType;

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

  private URI schemaLocation;

  private @SafeText String type;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}