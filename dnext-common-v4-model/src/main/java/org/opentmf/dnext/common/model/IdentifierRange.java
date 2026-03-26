package org.opentmf.dnext.common.model;

import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> quantity, rangeEnd, rangeStart<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-common: common</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"quantity", "rangeStart", "rangeEnd"})
public class IdentifierRange {

  /**
   * Number of identifiers in the range.
   */
  private Integer quantity;

  /**
   * Ending value of the identifier range.
   */
  private @SafeText String rangeEnd;

  /**
   * Starting value of the identifier range.
   */
  private @SafeText String rangeStart;
}