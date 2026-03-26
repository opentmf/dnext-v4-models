package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IPartyCreditProfile;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An individual might be evaluated for its worthiness and this evaluation might
 * be based on a credit rating given by a credit agency.
 *
 * <p><br/>
 * <strong>Required:</strong> creditAgencyName, ratingScore<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = PartyCreditProfile.class
)
@Required(fields = {"creditAgencyName", "ratingScore"})
public class PartyCreditProfile extends Entity implements IPartyCreditProfile {

  /**
   * Name of the credit agency giving the score.
   */
  private @SafeText String creditAgencyName;

  /**
   * Type of the credit agency giving the score.
   */
  private @SafeText String creditAgencyType;

  /**
   * Reference corresponding to the credit rating.
   */
  private @SafeText String ratingReference;

  /**
   * A measure of a party’s creditworthiness calculated on the basis of a
   * combination of factors such as their income and credit history.
   */
  private Integer ratingScore;

  private @Valid TimePeriod validFor;
}