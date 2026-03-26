package org.opentmf.dnext.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.general.model.IGeographicSubAddress;

/**
 * Representation of a GeographicSubAddress It is used for addressing within a
 * property in an urban area (country properties are often defined differently).
 * It may refer to a building, a building cluster, or a floor of a multistory
 * building.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-673: Geographic Address Management API</li>
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
    defaultImpl = GeographicSubAddress.class
)
public class GeographicSubAddress extends NamedEntity implements IGeographicSubAddress {

  /**
   * allows for buildings that have well-known names.
   */
  private @SafeText String buildingName;

  /**
   * used where a level type may be repeated e.g. BASEMENT 1, BASEMENT 2.
   */
  private @SafeText String levelNumber;

  /**
   * describes level types within a building.
   */
  private @SafeText String levelType;

  /**
   * private streets internal to a property (e.g. a university) may have internal
   * names that are not recorded by the land title office.
   */
  private @SafeText String privateStreetName;

  /**
   * private streets numbers internal to a private street.
   */
  private @SafeText String privateStreetNumber;

  /**
   * Type of subAddress : it can be a subunit or a private street.
   */
  private @SafeText String subAddressType;

  /**
   * the discriminator used for the subunit often just a simple number e.g. FLAT
   * 5, may also be a range.
   */
  private @SafeText String subUnitNumber;

  /**
   * the type of subunit e.g.BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT, WHARF.
   */
  private @SafeText String subUnitType;
}