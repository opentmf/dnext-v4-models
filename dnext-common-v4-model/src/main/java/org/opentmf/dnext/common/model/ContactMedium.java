package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IContactMedium;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Indicates the contact medium that could be used to contact the party.
 *
 * <p><br/>
 * <strong>Required:</strong> characteristic, mediumType<br/>
 * </p>
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
    defaultImpl = ContactMedium.class
)
@Required(fields = {"mediumType", "characteristic"})
public class ContactMedium extends Entity implements IContactMedium {

  /**
   * Any additional characteristic(s) of this contact medium.
   */
  private @Valid MediumCharacteristic characteristic;

  /**
   * Type of the contact medium, such as: email address, telephone number, postal
   * address.
   */
  private @SafeText String mediumType;

  /**
   * If true, indicates that is the preferred contact medium.
   */
  private Boolean preferred;

  /**
   * The time period that the contact medium is valid for.
   */
  private @Valid TimePeriod validFor;
}