package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>ProductOrderCreate (622)</li>
 *   <li>QuoteUpdate (648)</li>
 *   <li>ResourceOrderUpdate (652)</li>
 *   <li>ServiceOrderCreate (641)</li>
 *   <li>ServiceOrderUpdate (641)</li>
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
    defaultImpl = QuoteUpdateBase.class
)
public abstract class QuoteUpdateBase extends Extensible {

  /**
   * Description of the product order.
   */
  private @SafeText String description;

  /**
   * ID given by the consumer and only understandable by him (to facilitate his
   * searches afterwards).
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of a product Order entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  private @SafeText String state;
}