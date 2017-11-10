package no.ern.game.schema.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable
import java.time.ZonedDateTime
import javax.validation.constraints.NotNull

@ApiModel("MatchResult representation. Data transfer object represents match result")
data class MatchResultDto(

        @ApiModelProperty("Attacker info")
        var attacker: PlayerDto? = null,

        @ApiModelProperty("Defender info")
        var defender: PlayerDto? = null,

        @ApiModelProperty("Winner name of the match")
        var winnerName: String?= null,

        @ApiModelProperty("When the match result was created")
        var creationTime: ZonedDateTime? = null,

        @ApiModelProperty("MatchResult id")
        var id: String?=null
): Serializable

data class PlayerDto(
        @ApiModelProperty("Username")
        var username: String?=null,
        @ApiModelProperty("Total health")
        var health: Long?=null,
        @ApiModelProperty("Total damage")
        var damage: Long?=null,
        @ApiModelProperty("Remaining health, when match is finished")
        var remainingHealth: Long?=null
): Serializable

/**
 * example
      {
         "attacker":
         {
             "username":"u1",
             "health": 30,
             "damage": 28,
             "remainingHealth": 15
         },
         "defender":{
             "username":"u2",
              "health": 25,
              "damage": 15,
              "remainingHealth": -3
         },
        "winnerName": "u1"
      }
 */