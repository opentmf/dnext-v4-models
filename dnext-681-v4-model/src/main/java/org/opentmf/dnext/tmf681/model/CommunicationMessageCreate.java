package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

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
public class CommunicationMessageCreate extends CommunicationMessageUpdate {

  /**
   * Status of communication message
   * <br/><p>Recommended values: initial, inProgress, completed, cancelled,
   * failed.
   *
   * @see org.opentmf.dnext.tmf681.model.CommunicationMessageStateType
   */
  private @SafeText String state;
}