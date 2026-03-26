package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ITaxDefinition;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Reference of a tax definition. A tax is levied by an authorized tax
 * jurisdiction. There are many different types of tax (Federal Tax levied by
 * the US Government, State Tax levied by the State of California,…).
 *
 * <p><br/>
 * <strong>Required:</strong> id, taxType<br/>
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
    defaultImpl = TaxDefinition.class
)
@Required(fields = {"id", "taxType"})
public class TaxDefinition extends EntityRef implements ITaxDefinition {

  /**
   * Level of the jurisdiction that levies the tax.
   */
  private @SafeText String jurisdictionLevel;

  /**
   * Name of the jurisdiction that levies the tax.
   */
  private @SafeText String jurisdictionName;

  /**
   * Type of the tax.
   */
  private @SafeText String taxType;

  /**
   * The period of time for which the tax applies, might be set for example if it
   * is known that the jurisdiction will cease to apply the tax after a certain
   * date.
   */
  private @Valid TimePeriod validFor;
}