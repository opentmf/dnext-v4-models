package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf632.model.IOtherNameIndividual;

/**
 * Keeps track of other names, for example the old name of a woman before
 * marriage or an artist name.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = OtherNameIndividual.class
)
public class OtherNameIndividual extends Entity implements IOtherNameIndividual {

  /**
   * e.g. Baron, Graf, Earl,….
   */
  private @SafeText String aristocraticTitle;

  /**
   * Contains the non-chosen or inherited name. Also known as last name in the
   * Western context.
   */
  private @SafeText String familyName;

  /**
   * Family name prefix.
   */
  private @SafeText String familyNamePrefix;

  /**
   * . A fully formatted name in one string with all of its pieces in their proper
   * place and all of the necessary punctuation. Useful for specific contexts
   * (Chinese, Japanese, Korean,…).
   */
  private @SafeText String formattedName;

  /**
   * Full name flatten (first, middle, and last names).
   */
  private @SafeText String fullName;

  /**
   * e.g. Sr, Jr….
   */
  private @SafeText String generation;

  /**
   * First name.
   */
  private @SafeText String givenName;

  /**
   * Legal name or birth name (name one has for official purposes).
   */
  private @SafeText String legalName;

  /**
   * Middle name or initial.
   */
  private @SafeText String middleName;

  /**
   * Contains the chosen name by which the person prefers to be addressed. Note:
   * This name may be a name other than a given name, such as a nickname.
   */
  private @SafeText String preferredGivenName;

  /**
   * Use for titles (aristocratic, social, ...): Pr, Dr, Sir,....
   */
  private @SafeText String title;

  private @Valid TimePeriod validFor;
}