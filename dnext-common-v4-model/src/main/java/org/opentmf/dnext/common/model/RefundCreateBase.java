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
 * Synthesized abstract parent for 5 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AgreementUpdate (651)</li>
 *   <li>CommunicationMessageCreate (681)</li>
 *   <li>CommunicationMessageUpdate (681)</li>
 *   <li>PaymentCreate (676)</li>
 *   <li>RefundCreate (676)</li>
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
    defaultImpl = RefundCreateBase.class
)
public abstract class RefundCreateBase extends Extensible {

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * Narrative that explains the agreement and details about it, such as why the
   * agreement is taking place.
   */
  private @SafeText String description;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}