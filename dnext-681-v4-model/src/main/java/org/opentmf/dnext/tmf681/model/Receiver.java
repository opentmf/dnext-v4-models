package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf681.model.IReceiver;

/**
 * Receivers of the communication message.
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
    defaultImpl = Receiver.class
)
public class Receiver extends Sender implements IReceiver {

  /**
   * ID of the mobile app user.
   */
  @SafeId
  @Size(max = 100)
  private String appUserId;

  /**
   * IP address of the receiver.
   */
  private @SafeText String ip;
}