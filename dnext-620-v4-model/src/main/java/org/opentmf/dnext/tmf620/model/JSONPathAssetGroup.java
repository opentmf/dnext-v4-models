package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = JSONPathAssetGroup.class
)
public class JSONPathAssetGroup extends Extensible {

  /**
   * The JSON Path expression that defines the entities to be exported, format of
   * the filter is as per the JSON Path query parameter filter as defined in
   * TMF630.
   */
  @JsonProperty("JSONPath")
  private @SafeText String jSONPath;

  /**
   * The type of entity in the group, equivalent to {@literal @}type in the
   * <br/>entity definition. Must be a top-level managed entity. The JSON Path
   * <br/>expression is applied to this entity type.
   */
  private @SafeText String entityType;

  private @SafeText String jsonpath;

  public String getJSONPath() {
    return jSONPath;
  }

  public void setJSONPath(String jSONPath) {
    this.jSONPath = jSONPath;
  }

  public String getJsonpath() {
    return jsonpath;
  }

  public void setJsonpath(String jsonpath) {
    this.jsonpath = jsonpath;
  }
}