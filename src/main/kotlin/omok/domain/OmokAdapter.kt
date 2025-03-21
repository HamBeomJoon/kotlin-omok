package omok.domain

import omok.domain.lib.OmokRule

object OmokAdapter {
    fun adaptBoard(board: OmokBoard): List<List<Int>> {
        val adaptedBoard = MutableList(15) { MutableList(15) { 0 } }

        board.positions.forEach { position ->
            val state = when (position.stoneState) {
                StoneState.BLACK -> OmokRule.BLACK_STONE
                StoneState.WHITE -> OmokRule.WHITE_STONE
                else -> OmokRule.EMPTY_STONE
            }
            adaptedBoard[position.x][position.y] = state
        }

        return adaptedBoard
    }

    fun adaptPosition(position: Position): Pair<Int, Int> {
        return position.x to position.y
    }
}