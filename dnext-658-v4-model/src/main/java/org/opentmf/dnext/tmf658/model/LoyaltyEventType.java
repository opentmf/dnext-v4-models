package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Addressable;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf658.model.ILoyaltyEventType;

/**
 * An event type used to match filter incoming loyalty events.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class LoyaltyEventType extends Addressable implements ILoyaltyEventType {

  /**
   * When subclassing, this defines the super-class.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * When subclassing, this defines the subclass Extensible name.
   */
  @JsonProperty("@type")
  private @SafeText String atType;

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  private @SafeText String baseType;

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * The topic to which the event type relates.
   */
  private @SafeText String eventTopic;

  /**
   * The type of loyalty event expected to trigger the loyalty rule evaluation,
   * e.g. a CustomerOrder or an Invoice. The eventType should be unique to prevent
   * existing resources not being reused. An eventType that already exists will
   * result in a 422 error.
   */
  private @SafeText String eventType;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  private URI schemaLocation;

  private @SafeText String type;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}