package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IEventBase;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The manually configured common object for event notification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-common: common</li>
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
    defaultImpl = EventBase.class
)
public class EventBase extends Entity implements IEventBase {

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

  /**
   * The identifier of the notification.
   */
  @SafeId
  @Size(max = 100)
  private String eventId;

  /**
   * Time of the event occurrence.
   */
  private OffsetDateTime eventTime;

  /**
   * The type of the notification.
   */
  private @SafeText String eventType;

  /**
   * A priority.
   */
  private @SafeText String priority;

  /**
   * The time the event occurred.
   */
  @JsonProperty("timeOcurred")
  private OffsetDateTime timeOccurred;

  /**
   * The title of the event.
   */
  private @SafeText String title;
}