package example.kotest

class UserService(private val userRepository: UserRepository) {
    fun createMessage(id: Int): String? {
        if (id < 0) return null
        return userRepository.findName(id)?.let { "Hello $it" }
    }
}