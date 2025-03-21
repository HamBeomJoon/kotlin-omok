package omok.domain

class GameManager {
    fun changeTurn(state: StoneState): StoneState {
        return StoneState.getNextTurn(state)
    }
}
