package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.CommunicationMessageTemplateRef;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * The CommunicationMessageSpecification to be updated.
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
    defaultImpl = CommunicationMessageSpecificationUpdate.class
)
public class CommunicationMessageSpecificationUpdate extends Extensible {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Any default characteristic(s) of the related message that may be related to
   * mobile Push or other purposes.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  private @Valid CommunicationMessageTemplateRef messageTemplate;

  /**
   * The type of message, such as: SMS, Email, Mobile app push notification
   * <br/><p>Recommended values: email, sms, applePushNotification,
   * googleFirebaseCloudMessaging.
   *
   * @see org.opentmf.dnext.tmf681.model.CommunicationMessageMessageTypeType
   */
  private @SafeText String messageType;

  /**
   * Name of Entity.
   */
  private @SafeText String name;

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
   * Sender of the communication message.
   */
  private @Valid Sender sender;

  /**
   * State values for CommunicationMessageSpecification
   * <br/><p>Recommended values: working, active, inactive.
   *
   * @see org.opentmf.dnext.tmf681.model.CommunicationMessageSpecificationStateType
   */
  private @SafeText String state;

  /**
   * The subject/title of the message, necessary for the email and mobile app
   * push.
   */
  private @SafeText String subject;

  /**
   * How many times do you want to retry the delivery of this message?.
   */
  private Integer tryTimes;
}