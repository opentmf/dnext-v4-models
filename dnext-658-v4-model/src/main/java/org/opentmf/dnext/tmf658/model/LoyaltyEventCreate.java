package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.LoyaltyProgramMemberRef;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * The LoyaltyEvent to be created.
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
    defaultImpl = LoyaltyEventCreate.class
)
public class LoyaltyEventCreate extends Extensible {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * The correlation id for this event.
   */
  @SafeId
  @Size(max = 100)
  private String correlationId;

  /**
   * An explanatory description of the event.
   */
  private @SafeText String description;

  /**
   * The domain of the event.
   */
  private @SafeText String domain;

  private @SafeText String event;

  /**
   * The identifier of the notification.
   */
  @SafeId
  @Size(max = 100)
  private String eventId;

  /**
   * The time that the event was received.
   */
  private @SafeText String eventTime;

  /**
   * The incoming loyalty event type.
   */
  private @SafeText String eventType;

  private @Valid LoyaltyProgramMemberRef member;

  /**
   * The member identifier of the loyalty program member.
   */
  @SafeId
  @Size(max = 100)
  private String memberId;

  private @Valid LoyaltyProgramPartnerRef partner;

  /**
   * A priority.
   */
  private @SafeText String priority;

  private @Valid LoyaltyProgramProductRef program;

  /**
   * The time the event occurred.
   */
  private OffsetDateTime timeOccurred;

  /**
   * The title of the event.
   */
  private @SafeText String title;
}