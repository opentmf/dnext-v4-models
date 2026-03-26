package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IRelatedPlaceRefOrValue;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Related Entity reference. A related place defines a place described by
 * reference or by value linked to a specific entity. The polymorphic attributes
 * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
 * not the RelatedPlaceRefOrValue class itself.
 *
 * <p><br/>
 * <strong>Required:</strong> role<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
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
    defaultImpl = RelatedPlaceRefOrValue.class
)
@Required(fields = {"role"})
public class RelatedPlaceRefOrValue extends RelatedEntityRefOrValue implements IRelatedPlaceRefOrValue {

  /**
   * City that the address is in.
   */
  private @SafeText String city;

  /**
   * Country that the address is in.
   */
  private @SafeText String country;

  /**
   * External reference of the shopping cart or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * An area of defined or undefined boundaries within a local authority or other
   * legislatively defined area, usually rural or semi rural in nature.
   * [ANZLIC-STREET], or a suburb, a bounded locality within a city, town or shire
   * principally of urban character [ANZLICSTREET].
   */
  private @SafeText String locality;

  /**
   * descriptor for a postal delivery area, used to speed and simplify the
   * delivery of mail (also known as zipcode).
   */
  private @SafeText String postcode;

  /**
   * the State or Province that the address is in.
   */
  private @SafeText String stateOrProvince;

  /**
   * Name of the street or other street type.
   */
  private @SafeText String streetName;

  /**
   * Number identifying a specific property on a public street. It may be combined
   * with streetNrLast for ranged addresses.
   */
  private @SafeText String streetNr;

  /**
   * Last number in a range of street numbers allocated to a property.
   */
  private @SafeText String streetNrLast;

  /**
   * Last street number suffix for a ranged address.
   */
  private @SafeText String streetNrLastSuffix;

  /**
   * the first street number suffix.
   */
  private @SafeText String streetNrSuffix;

  /**
   * A modifier denoting a relative direction.
   */
  private @SafeText String streetSuffix;

  /**
   * alley, avenue, boulevard, brae, crescent, drive, highway, lane, terrace,
   * parade, place, tarn, way, wharf.
   */
  private @SafeText String streetType;
}