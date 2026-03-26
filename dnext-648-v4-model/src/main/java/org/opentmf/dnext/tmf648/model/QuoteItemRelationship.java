package org.opentmf.dnext.tmf648.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.tmf648.model.IQuoteItemRelationship;

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
public class QuoteItemRelationship extends Entity implements IQuoteItemRelationship {

  /**
   * Relationship type as relies on, bundles, etc...
   */
  private @SafeText String relationshipType;
}