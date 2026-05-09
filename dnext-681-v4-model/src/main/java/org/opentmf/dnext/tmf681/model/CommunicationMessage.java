package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf681.model.ICommunicationMessage;

/**
 * Communication message means a notification approach in the format of a
 * message which can be dispatched (sent) to the certain user by the system with
 * the content which can be felt and understood by the recipient. The user can
 * be either a final customer or a customer service agent. The message can reach
 * the customer in different interaction channels, including: email, short
 * message, mobile app notification (push).
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
    defaultImpl = CommunicationMessage.class
)
public class CommunicationMessage extends CommunicationMessageUpdate implements ICommunicationMessage {

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
   * Status of communication message
   * <br/><p>Recommended values: initial, inProgress, completed, cancelled,
   * failed.
   *
   * @see org.opentmf.dnext.tmf681.model.CommunicationMessageStateType
   */
  private @SafeText String state;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}