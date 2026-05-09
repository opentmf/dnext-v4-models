package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IQuoteItemRelationship;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Used to describe relationship between quote item. These relationship could
 * have an impact on pricing and conditions.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
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
    defaultImpl = QuoteItemRelationship.class
)
public class QuoteItemRelationship extends Extensible implements IQuoteItemRelationship {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * ID of the related order item (must be in the same quote).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Relationship type as relies on, bundles, etc...
   */
  private @SafeText String relationshipType;
}