package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> bundledGroupProductOfferingOption<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = BundledGroupProductOffering.class
)
@Required(fields = {"bundledGroupProductOfferingOption"})
public class BundledGroupProductOffering extends Extensible {

  /**
   * A group of product offerings that can be chosen for instantiation of children
   * of the parent product offering, for example a list of channels for selection
   * under a TV offering. Sometimes known as Selection Group. The group can also
   * hierarchically contain other groups.
   */
  @JsonProperty("bundledGroupProductOffering")
  private List<@Valid BundledGroupProductOffering> bundledGroupProductOfferings;

  /**
   * Defines for a BundledProductOfferingGroup (i.e. a group of multiple child
   * offerings of a parent product offering), how many instances from the child
   * offerings can be chosen in total. For example facilitate the choice of
   * between 2 and 7 channel packs from a list, and cause certain items to be
   * selected by default.
   */
  private @Valid BundledGroupProductOfferingOption bundledGroupProductOfferingOption;

  /**
   * A type of ProductOffering that belongs to a grouping of ProductOfferings made
   * available to the market. It inherits of all attributes of ProductOffering.
   */
  @JsonProperty("bundledProductOffering")
  private List<@Valid BundledProductOffering> bundledProductOfferings;

  /**
   * Locally unique identifier of the group, useful in case the parent product
   * offering or group includes multiple groups.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * The name of the group of child offerings. Required to distinguish several
   * choice groups.
   */
  private @SafeText String name;
}