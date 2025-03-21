package omok.domain

enum class StoneState {
    BLACK,
    WHITE,
    BLANK,
    ;

    companion object {
        fun getNextTurn(state: StoneState): StoneState {
            return when (state) {
                BLACK -> WHITE
                WHITE -> BLACK
                else -> throw IllegalStateException()
            }
        }
    }
}
