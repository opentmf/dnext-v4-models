package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.CharacteristicBase;
import org.opentmf.dnext.common.model.CharacteristicValueSpecification;
import org.opentmf.resource.model.IResourceSpecificationCharacteristic;

/**
 * This class defines the characteristic features of a resource specification.
 * Every ResourceSpecification has a variety of important attributes, methods,
 * constraints, and relationships, which distinguish a resource specification
 * from other resource specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = ResourceSpecificationCharacteristic.class
)
@Required(fields = {"name"})
public class ResourceSpecificationCharacteristic extends CharacteristicBase implements IResourceSpecificationCharacteristic {

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
  @JsonProperty("resourceSpecCharRelationship")
  private List<@Valid ResourceSpecificationCharacteristicRelationship> resourceSpecCharRelationships;

  /**
   * A ResourceSpecificationCharacteristicValue object is used to define a set of
   * attributes, each of which can be assigned to a corresponding set of
   * attributes in a ResourceSpecificationCharacteristic object. The values of the
   * attributes in the ResourceSpecificationCharacteristicValue object describe
   * the values of the attributes that a corresponding
   * ResourceSpecificationCharacteristic object can take on.
   */
  @JsonProperty("resourceSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> resourceSpecCharacteristicValues;
}