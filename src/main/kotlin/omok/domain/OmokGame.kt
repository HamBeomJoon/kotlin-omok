package omok.domain

import omok.domain.lib.FourFourRule
import omok.domain.lib.ThreeThreeRule
import omok.util.retryInput

class OmokGame(val board: OmokBoard) {
    private val gameManager = GameManager()

    fun playGame(
        onTurnStarted: (List<Position>) -> Unit,
        onSelectPosition: (StoneState, Position?, OmokBoard) -> Position,
    ): OmokResult {
        var latestPosition: Position? = null
        val state = StoneState.BLACK

        while (true) {
            latestPosition = playTurn(state, onTurnStarted, latestPosition, onSelectPosition)
        }
        return OmokResult.DRAW
    }

    private fun playTurn(
        state: StoneState,
        onTurnStarted: (List<Position>) -> Unit,
        latestPosition: Position?,
        onSelectPosition: (StoneState, Position?, OmokBoard) -> Position,
    ): Position {
        onTurnStarted(board.positions)
        val position = getPositionToPlace(state, latestPosition, onSelectPosition)
        val nextTurn = gameManager.changeTurn(state)
        playMove(position, nextTurn)
        return position
    }

    private fun playMove(
        position: Position,
        stoneState: StoneState,
    ) {
        board.putStone(position, stoneState)
    }

    private fun getPositionToPlace(
        state: StoneState,
        latestPosition: Position?,
        onSelectPosition: (StoneState, Position?, OmokBoard) -> Position,
    ): Position {
        return retryInput {
            val position = onSelectPosition(state, latestPosition, board)
            validatePosition(position)
            board.canPlace(position)
            position
        }
    }

    private fun validatePosition(position: Position) {
        val adaptedBoard = OmokConvertor.convertBoard(board)
        val adaptedPosition = OmokConvertor.convertPosition(position)
        if (FourFourRule.validate(adaptedBoard, adaptedPosition)) throw IllegalArgumentException()
        if (ThreeThreeRule.validate(adaptedBoard, adaptedPosition)) throw IllegalArgumentException()
        // 장목 판단
    }
//
//    private fun getOtherPlayer(player: Player): Player {
//        return if (player is BlackPlayer) {
//            whitePlayer
//        } else {
//            blackPlayer
//        }
//    }
//
//    companion object {
//        private const val ERROR_DOUBLE_THREE = "3x3 위치에 놓을 수 없습니다"
//        private const val ERROR_DOUBLE_FOUR = "4x4 위치에 놓을 수 없습니다"
//        private const val ERROR_OVER_LINE = "장목 위치에 놓을 수 없습니다"
//
//        fun dealViolation(violation: Violation): String? {
//            when (violation) {
//                Violation.DOUBLE_THREE -> ERROR_DOUBLE_THREE
//                Violation.DOUBLE_FOUR -> ERROR_DOUBLE_FOUR
//                Violation.OVERLINE -> ERROR_OVER_LINE
//                Violation.NONE -> null
//            }
//        }
//    }
}
