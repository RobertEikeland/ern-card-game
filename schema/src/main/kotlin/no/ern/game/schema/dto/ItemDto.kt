package no.ern.game.schema.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable


@ApiModel("DTO for item. It represent an item entity")
data class ItemDto(

        @ApiModelProperty("The name of the item")
        var name: String?=null,

        @ApiModelProperty("Description of the item")
        var description: String?=null,

        @ApiModelProperty("What type the items is (Weapon/Armor)")
        var type: String?=null,

        @ApiModelProperty("How much extra damage this item gives")
        var damageBonus: Int?=null,

        @ApiModelProperty("How much extra health this item gives")
        var healthBonus: Int?=null,

        @ApiModelProperty("How much this items costs to buy (ie. in a shop)")
        var price: Int?=null,

        @ApiModelProperty("How high level a user needs to be to use this item")
        var levelRequirement: Int?=null,

        @ApiModelProperty("Item id")
        var id: String?=null
) : Serializable

