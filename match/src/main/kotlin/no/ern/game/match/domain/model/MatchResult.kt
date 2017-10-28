package no.ern.game.match.domain.model

import org.hibernate.validator.constraints.NotBlank
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Entity
data class MatchResult(

        @get: NotBlank @get:Size(max = 32)
        var attackerUsername: String,
        @get: NotBlank @get:Size(max = 32)
        var defenderUsername: String,

        @get:Min(0)
        var attackerHealth: Long,
        @get:Min(0)
        var defenderHealth: Long,

        @get:Min(0)
        var attackerTotalDamage: Long,
        @get:Min(0)
        var defenderTotalDamage: Long,

        // can be negative
        var attackerRemainingHealth: Long,
        var defenderRemainingHealth: Long,

        var winnerName: String? = null,

        @get:Id @get:GeneratedValue
        var id: Long? = null
) {
    //TODO: no args (dependency kotlin-maven-noarg)
    //need empty constructor for jpa and JSON -parsing
    constructor():this("","",0,0,0,0,0,0,"")
}