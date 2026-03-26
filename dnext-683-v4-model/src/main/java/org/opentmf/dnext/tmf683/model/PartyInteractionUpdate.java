package org.opentmf.dnext.tmf683.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.InteractionItem;
import org.opentmf.dnext.common.model.InteractionRelationship;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.RelatedChannel;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TimePeriod;

/**
 * The PartyInteraction to be updated.
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
    defaultImpl = PartyInteractionUpdate.class
)
public class PartyInteractionUpdate extends Extensible {

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Where the interaction took place (e.g. web, mobile app, store, kiosk, etc.).
   */
  @JsonProperty("channel")
  private List<@Valid RelatedChannel> channels;

  /**
   * Date when the interaction is created in the system.
   */
  private OffsetDateTime creationDate;

  /**
   * Description of the interaction.
   */
  private @SafeText String description;

  /**
   * The period during which the interaction took place. Start and end will be
   * different in case of a call or a store visit. They will be the same (or only
   * one will appear) in case of a message or other momentary interactions.
   */
  private @Valid TimePeriod interactionDate;

  /**
   * A list of interaction items.
   */
  @JsonProperty("interactionItem")
  private List<@Valid InteractionItem> interactionItems;

  /**
   * A list of interaction relationships.
   */
  @JsonProperty("interactionRelationship")
  private List<@Valid InteractionRelationship> interactionRelationships;

  /**
   * Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Reason why the interaction happened.
   */
  private @SafeText String reason;

  /**
   * Related Entity reference. A related party defines party or party role linked
   * to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Status of the interaction (opened, inProgress, completed).
   */
  private @SafeText String status;

  /**
   * Last time the status changed.
   */
  private OffsetDateTime statusChangeDate;
}