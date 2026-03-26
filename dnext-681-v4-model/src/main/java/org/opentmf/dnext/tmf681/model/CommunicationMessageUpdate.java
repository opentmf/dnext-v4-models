package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Attachment;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * The CommunicationMessage to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-681: Communication Management API</li>
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
    defaultImpl = CommunicationMessageUpdate.class
)
public class CommunicationMessageUpdate extends Extensible {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Any attachment associated with this message.
   */
  @JsonProperty("attachment")
  private List<@Valid Attachment> attachments;

  /**
   * Any additional characteristic(s) of this message.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * The content of the communication message.
   */
  private @SafeText String content;

  /**
   * Description for the whole object.
   */
  private @SafeText String description;

  private Boolean logFlag;

  /**
   * The type of message, such as: SMS, Email, Mobile app push notification
   * <br/><p>Recommended values: email, sms, applePushNotification,
   * googleFirebaseCloudMessaging.
   *
   * @see org.opentmf.dnext.tmf681.model.CommunicationMessageMessageTypeType
   */
  private @SafeText String messageType;

  /**
   * The priority of the communication message. Small number means higher
   * priority.
   */
  private @SafeText String priority;

  /**
   * The receiver(s) of this message.
   */
  @JsonProperty("receiver")
  private List<@Valid Receiver> receivers;

  /**
   * The scheduled time for sending the communication message.
   */
  private OffsetDateTime scheduledSendTime;

  /**
   * The time of sending communication message.
   */
  private OffsetDateTime sendTime;

  /**
   * The time of completion of sending communication message.
   */
  private OffsetDateTime sendTimeComplete;

  /**
   * The sender of this message.
   */
  private @Valid Sender sender;

  /**
   * The title of the message, necessary for the email and mobile app push.
   */
  private @SafeText String subject;

  /**
   * How many times do you want to retry the delivery of this message?.
   */
  private Integer tryTimes;
}