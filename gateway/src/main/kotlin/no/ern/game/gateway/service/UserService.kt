package no.ern.game.gateway.service

import no.ern.game.gateway.domain.model.User
import no.ern.game.gateway.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService{


    @Autowired
    private lateinit var repo: UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    fun createUserWithHashedPassword(username: String, password: String, roles: Set<String> = setOf()) : Boolean {
        try {
            val hash = passwordEncoder.encode(password)

            if (repo.findUserByUsername(username)!=null) {
                return false
            }

            val user = User(username, hash, roles.map{"ROLE_$it"}.toSet())

            repo.save(user)

            return true
        } catch (e: Exception){
            return false
        }
    }
}