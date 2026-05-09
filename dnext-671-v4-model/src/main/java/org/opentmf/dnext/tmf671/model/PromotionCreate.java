package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.tmf671.model.IPromotionCreate;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
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
    defaultImpl = PromotionCreate.class
)
@Required(fields = {"name"})
public class PromotionCreate extends PromotionUpdate implements IPromotionCreate {

  /**
   * List of: Contains the conditions and benefits of the promotion toan eligible
   * party.
   */
  @JsonProperty("pattern")
  private List<@Valid PromotionPattern> patterns;
}