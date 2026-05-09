package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAccountRelationship;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Significant connection between accounts. For instance an aggregating account
 * for a list of shop branches each having its own billing account.
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = AccountRelationship.class
)
@Required(fields = {"relationshipType", "validFor"})
public class AccountRelationship extends InteractionRelationship implements IAccountRelationship {

  /**
   * Account reference. An account may be a party account or a financial account.
   */
  private @Valid AccountRef account;

  /**
   * Validity period of that relationship.
   */
  private @Valid TimePeriod validFor;
}