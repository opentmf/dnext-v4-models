package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Attachment;
import org.opentmf.dnext.common.model.RefundCreateBase;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf681.model.ICommunicationMessageCreate;

/**
 * The CommunicationMessage to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> content, messageType, receiver, sender<br/>
 * </p>
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
    defaultImpl = CommunicationMessageCreate.class
)
@Required(fields = {"messageType", "receiver", "sender", "content"})
public class CommunicationMessageCreate extends RefundCreateBase implements ICommunicationMessageCreate {

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
   * The content of the communication message.
   */
  private @SafeText String content;

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
   * Status of communication message
   * <br/><p>Recommended values: initial, inProgress, completed, cancelled,
   * failed.
   *
   * @see org.opentmf.dnext.tmf681.model.CommunicationMessageStateType
   */
  private @SafeText String state;

  /**
   * The title of the message, necessary for the email and mobile app push.
   */
  private @SafeText String subject;

  /**
   * How many times do you want to retry the delivery of this message?.
   */
  private Integer tryTimes;
}