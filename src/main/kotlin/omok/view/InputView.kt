package omok.view

import omok.domain.OmokBoard
import omok.domain.Position
import omok.domain.StoneState

private fun StoneState.getDisplayColor(): String {
    return when (this) {
        StoneState.BLACK -> "흑"
        StoneState.WHITE -> "백"
        else -> throw IllegalArgumentException()
    }
}

class InputView {
    fun getPoint(
        state: StoneState,
        latestPosition: Position?,
        board: OmokBoard,
    ): Position {
        print(MESSAGE_TURN.format(state.getDisplayColor()))
        if (latestPosition != null) print(MESSAGE_LATEST_POSITION.format(convertToString(latestPosition)))
        print(MESSAGE_POSITION_GUIDE)
        val rawInput = readln().trim()

        return parsingInput(rawInput, board) ?: getPoint(state, latestPosition, board)
    }

    companion object {
        private const val MESSAGE_TURN: String = "\n%s의 차례입니다."
        private const val MESSAGE_LATEST_POSITION: String = "(마지막 돌의 위치: %s)"
        private const val MESSAGE_POSITION_GUIDE: String = "\n위치를 입력하세요: "

        private fun convertToString(position: Position): String {
            val letter = 'A' + position.x - 1
            return letter + (position.y).toString()
        }

        private fun parsingInput(
            rawInput: String,
            grid: OmokBoard,
        ): Position? {
            if (rawInput.isEmpty()) return null

            val rawRow = rawInput.substring(1)
            val rawCol = rawInput.substring(0, 1)

            val row = validateRow(rawRow, grid.height) ?: return null
            val col = validateCol(rawCol, grid.width) ?: return null
            return Position(row, col)
        }

        private fun validateRow(
            rawRow: String,
            height: Int,
        ): Int? {
            if (rawRow.toIntOrNull() == null) return null
            if (rawRow.toInt() !in 1..height) return null
            return rawRow.toInt()
        }

        private fun validateCol(
            rawCol: String,
            width: Int,
        ): Int? {
            val convertedCol = convertLetter(rawCol)
            if (convertedCol !in 1..width) return null
            return convertedCol
        }

        private fun convertLetter(letter: String): Int {
            return letter[0] - 'A' + 1
        }
    }
}
