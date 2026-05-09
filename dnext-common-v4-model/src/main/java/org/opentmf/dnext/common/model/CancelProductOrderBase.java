package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CancelProductOrder (622)</li>
 *   <li>CancelResourceOrder (652)</li>
 *   <li>CancelServiceOrder (641)</li>
 *   <li>InflightOrderChange (622, 641, 652)</li>
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
    defaultImpl = CancelProductOrderBase.class
)
public abstract class CancelProductOrderBase extends Entity {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  private @SafeText String state;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}