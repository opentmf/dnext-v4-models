package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

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
@Required(fields = {"name"})
public class PromotionCreate extends PromotionUpdate {

  /**
   * The base type for use in polymorphic collections.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * A link to the schema describing a resource (for type extension).
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * The class type of the actual resource (for type extension).
   */
  @JsonProperty("@type")
  private @SafeText String atType;

  /**
   * A unique identifier for the activity record.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * List of: Contains the conditions and benefits of the promotion toan eligible
   * party.
   */
  @JsonProperty("pattern")
  private List<@Valid PromotionPattern> patterns;
}