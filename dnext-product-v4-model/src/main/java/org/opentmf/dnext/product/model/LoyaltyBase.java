package org.opentmf.dnext.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>LoyaltyActionCreate (658)</li>
 *   <li>LoyaltyActionUpdate (658)</li>
 *   <li>LoyaltyRuleCreate (658)</li>
 *   <li>LoyaltyRuleUpdate (658)</li>
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
    defaultImpl = LoyaltyBase.class
)
public abstract class LoyaltyBase extends Extensible {

  /**
   * A user-friendly identifier of the loyalty execution point.
   */
  private @SafeText String commonName;

  /**
   * A free-form description of the loyalty execution point.
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