package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AccessPolicyConstraintData;
import org.opentmf.dnext.common.model.Auth;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.LoyaltyProgramMemberRef;
import org.opentmf.dnext.common.model.LoyaltyProgramPartnerRef;
import org.opentmf.dnext.common.model.LoyaltyProgramProductRef;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.Trace;

/**
 * A loyalty event notification.
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
    defaultImpl = LoyaltyEvent.class
)
public class LoyaltyEvent extends Extensible {

  /**
   * List of: Access policy constraint data.
   */
  @JsonProperty("accessPolicyConstraint")
  private List<@Valid AccessPolicyConstraintData> accessPolicyConstraints;

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Authentication context of the event.
   */
  private @Valid Auth auth;

  /**
   * The correlation id for this event.
   */
  @SafeId
  @Size(max = 100)
  private String correlationId;

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * An explanatory description of the event.
   */
  private @SafeText String description;

  /**
   * The domain of the event.
   */
  private @SafeText String domain;

  private Object event;

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

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  private @Valid LoyaltyProgramMemberRef member;

  /**
   * The member identifier of the loyalty program member.
   */
  @SafeId
  @Size(max = 100)
  private String memberId;

  /**
   * The name of the object related to the event.
   */
  private @SafeText String objectName;

  /**
   * The IP address of the origin of the event.
   */
  private @SafeText String originIp;

  private @Valid LoyaltyProgramPartnerRef partner;

  /**
   * A priority.
   */
  private @SafeText String priority;

  private @Valid LoyaltyProgramProductRef program;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * The time the event occurred.
   */
  private OffsetDateTime timeOccurred;

  /**
   * The title of the event.
   */
  private @SafeText String title;

  /**
   * Trace context of the event.
   */
  private @Valid Trace trace;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}