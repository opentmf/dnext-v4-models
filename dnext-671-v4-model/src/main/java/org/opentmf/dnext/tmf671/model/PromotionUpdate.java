package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf671.model.IPromotionUpdate;

/**
 * The Promotion to be updated.
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
    defaultImpl = PromotionUpdate.class
)
public class PromotionUpdate extends NamedEntity implements IPromotionUpdate {

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Details about the purpose of this promotion.
   */
  private @SafeText String description;

  /**
   * Latest update date of promotion.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Value of promotion status. Our suggestion would be:
   * draft/test/waitForApproval/release/suspend/retirement.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Type of promotion. The basic type are Award/Discount/Reduction.
   */
  private @SafeText String promotionType;

  /**
   * The period for which the promotion is valid.
   */
  private @Valid TimePeriod validFor;
}