package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The CommunicationMessageSpecification to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> messageTemplate, name, receiver, sender, subject<br/>
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
    defaultImpl = CommunicationMessageSpecificationCreate.class
)
@Required(fields = {"receiver", "sender", "subject", "name", "messageTemplate"})
public class CommunicationMessageSpecificationCreate extends CommunicationMessageSpecificationUpdate {

  /**
   * Unique identifier of Entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}