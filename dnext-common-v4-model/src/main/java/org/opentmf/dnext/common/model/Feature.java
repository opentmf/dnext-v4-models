package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IFeature;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Configuration feature.
 *
 * <p><br/>
 * <strong>Required:</strong> featureCharacteristic, id, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = Feature.class
)
@Required(fields = {"featureCharacteristic", "name", "id"})
public class Feature extends NamedEntity implements IFeature {

  /**
   * This is a list of feature constraints.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Bundled feature specification.
   */
  @JsonProperty("featureBundle")
  private List<@Valid FeatureBundle> featureBundles;

  /**
   * This is a list of Characteristics for a particular feature.
   */
  @JsonProperty("featureCharacteristic")
  private @Size(min = 1) List<@Valid Characteristic> featureCharacteristics;

  /**
   * List of: Configuration feature.
   */
  @JsonProperty("featureRelationship")
  private List<@Valid FeatureRelationship> featureRelationships;

  /**
   * True if this is a feature group. Default is false.
   */
  private Boolean isBundle;

  /**
   * True if this feature is enabled. Default is true.
   */
  private Boolean isEnabled;
}