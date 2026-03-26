package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IMediumCharacteristic;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Describes the contact medium characteristics that could be used to contact a
 * party (an individual or an organization).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-666: Account Management API</li>
 *   <li>TMF-668: Partnership Type</li>
 *   <li>TMF-669: Party Role Management API</li>
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
    defaultImpl = MediumCharacteristic.class
)
public class MediumCharacteristic extends Entity implements IMediumCharacteristic {

  /**
   * The street number of the building. e.g. 25.
   */
  private @SafeText String buildingNumber;

  /**
   * The city.
   */
  private @SafeText String city;

  /**
   * The type of contact, for example: phone number such as mobile, fixed home,
   * fixed office. postal address such as shipping installation….
   */
  private @SafeText String contactType;

  /**
   * The country.
   */
  private @SafeText String country;

  /**
   * Full email address in standard format.
   */
  private @SafeText String emailAddress;

  /**
   * The fax number of the contact.
   */
  private @SafeText String faxNumber;

  /**
   * Neighborhood, village or other locality. e.g. Gencosman Mah.
   */
  private @SafeText String locality;

  /**
   * The primary phone number of the contact.
   */
  private @SafeText String phoneNumber;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity.
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRef> places;

  /**
   * Postcode.
   */
  private @SafeText String postCode;

  /**
   * Identifier as a member of a social network.
   */
  @SafeId
  @Size(max = 100)
  private String socialNetworkId;

  /**
   * State or province.
   */
  private @SafeText String stateOrProvince;

  /**
   * Describes the street.
   */
  private @SafeText String street1;

  /**
   * Complementary street description.
   */
  private @SafeText String street2;

  /**
   * The town. A town is a compactly settled area usually larger than a village
   * but smaller than a city (Turkey: Ilce) e.g. Pendik.
   */
  private @SafeText String town;

  /**
   * Number of the interior unit within a building, such as a flat, apartment or
   * office number. e.g. Daire:8.
   */
  private @SafeText String unitNumber;
}