package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ICharacteristicSpecification;
import org.opentmf.commons.validation.constraints.Required;

/**
 * This class defines a characteristic specification.
 *
 * <p><br/>
 * <strong>Required:</strong> name, valueType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-667: Document Management API</li>
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
    defaultImpl = CharacteristicSpecification.class
)
@Required(fields = {"valueType", "name"})
public class CharacteristicSpecification extends CharacteristicBase implements ICharacteristicSpecification {

  /**
   * This (optional) field provides a link to the schema describing the value
   * type.
   */
  @JsonProperty("@valueSchemaLocation")
  private URI atValueSchemaLocation;

  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * An aggregation, migration, substitution, dependency or exclusivity
   * relationship between/among Specification Characteristics.
   */
  @JsonProperty("charSpecRelationship")
  private List<@Valid CharacteristicSpecificationRelationship> charSpecRelationships;

  /**
   * A CharacteristicValueSpecification object is used to define a set of
   * attributes, each of which can be assigned to a corresponding set of
   * attributes in a CharacteristicSpecification object. The values of the
   * attributes in the CharacteristicValueSpecification object describe the values
   * of the attributes that a corresponding Characteristic object can take on.
   */
  @JsonProperty("characteristicValueSpecification")
  private List<@Valid CharacteristicValueSpecification> characteristicValueSpecifications;

  private Boolean visible;
}