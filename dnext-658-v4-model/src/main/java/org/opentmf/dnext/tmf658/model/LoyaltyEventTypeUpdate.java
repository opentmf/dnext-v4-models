package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf658.model.ILoyaltyEventTypeUpdate;

/**
 * The LoyaltyEventType to be updated.
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
    defaultImpl = LoyaltyEventTypeUpdate.class
)
public class LoyaltyEventTypeUpdate extends Entity implements ILoyaltyEventTypeUpdate {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * The topic to which the event type relates.
   */
  private @SafeText String eventTopic;

  /**
   * The type of loyalty event expected to trigger the loyalty rule evaluation,
   * e.g. a CustomerOrder or an Invoice. The eventType should be unique to prevent
   * existing resources not being reused. An eventType that already exists will
   * result in a 422 error.
   */
  private @SafeText String eventType;
}