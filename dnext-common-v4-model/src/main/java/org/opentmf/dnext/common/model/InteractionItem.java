package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IInteractionItem;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-683: Party Interaction Management API</li>
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
    defaultImpl = InteractionItem.class
)
public class InteractionItem extends Entity implements IInteractionItem {

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Where the interaction took place (e.g.: web, mobile app, store, kiosk, etc.).
   */
  @JsonProperty("channel")
  private List<@Valid RelatedChannel> channels;

  /**
   * Date when the interaction item is created in the system.
   */
  private OffsetDateTime creationDate;

  /**
   * RelatedEntity defines a reference to any entity. It uses polymorphism in
   * order to let the API client know how to treat the element, as the entity type
   * is not known beforehand.
   */
  private @Valid RelatedEntityRefOrValue item;

  /**
   * Moment this item is referred.
   */
  private @Valid TimePeriod itemDate;

  /**
   * Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Reason why this item is referred.
   */
  private @SafeText String reason;

  /**
   * Related Entity reference. A related party defines party or party role linked
   * to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Resolution of the interaction item.
   */
  private @SafeText String resolution;
}