package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
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
public class CommunicationMessage extends CommunicationMessageCreate implements ICommunicationMessage {

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * Hypertext Reference of the Communication Message.
   */
  private URI href;

  /**
   * Unique identifier of Communication Message.
   */
  @SafeId
  @Size(max = 100)
  private String id;

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