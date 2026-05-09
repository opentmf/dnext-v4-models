package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IFeatureSpecificationCharacteristic;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Configuration feature characteristic specification.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = FeatureSpecificationCharacteristic.class
)
@Required(fields = {"name"})
public class FeatureSpecificationCharacteristic extends CharacteristicValueSpecificationBase implements IFeatureSpecificationCharacteristic {

  /**
   * This (optional) field provides a link to the schema describing the value
   * type.
   */
  @JsonProperty("@valueSchemaLocation")
  private URI atValueSchemaLocation;

  /**
   * If true, the Boolean indicates that the target Characteristic is
   * configurable.
   */
  private Boolean configurable;

  /**
   * A narrative that explains the CharacteristicSpecification.
   */
  private @SafeText String description;

  /**
   * An indicator that specifies that the values for the characteristic can be
   * extended by adding new values when instantiating a characteristic for a
   * resource.
   */
  private Boolean extensible;

  /**
   * An aggregation, migration, substitution, dependency or exclusivity
   * relationship between/among feature characteristics.
   */
  @JsonProperty("featureSpecCharRelationship")
  private List<@Valid FeatureSpecificationCharacteristicRelationship> featureSpecCharRelationships;

  /**
   * Used to define a set of attributes, each of which can be assigned to a
   * corresponding set of attributes in a FeatureCharacteristic object.
   */
  @JsonProperty("featureSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> featureSpecCharacteristicValues;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique ID for the characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * An indicator that specifies if a value is unique for the specification.
   * Possible values are; "unique while value is in effect" and "unique whether
   * value is in effect or not".
   */
  private Boolean isUnique;

  /**
   * The maximum number of instances a CharacteristicValue can take on. For
   * example, zero to five phone numbers in a group calling plan, where five is
   * the value for the maxCardinality.
   */
  private Integer maxCardinality;

  /**
   * The minimum number of instances a CharacteristicValue can take on. For
   * example, zero to five phone numbers in a group calling plan, where zero is
   * the value for the minCardinality.
   */
  private Integer minCardinality;

  /**
   * A word, term, or phrase by which this characteristic specification is known
   * and distinguished from other characteristic specifications.
   */
  private @SafeText String name;
}