package org.opentmf.dnext.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.EntityRef;
import org.opentmf.dnext.common.model.EventBase;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.general.model.IEvent;

/**
 * event with common attributes.
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
    defaultImpl = Event.class
)
public class Event extends EventBase implements IEvent {

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("analyticCharacteristic")
  private List<@Valid Characteristic> analyticCharacteristics;

  private Object event;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  private @Valid EntityRef reportingSystem;

  private @Valid EntityRef source;
}