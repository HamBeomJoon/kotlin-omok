package omok.domain.player

import omok.domain.Position
import omok.domain.lib.OmokRule

abstract class Player {
    protected abstract val stonesBacking: MutableList<Position>
    val stones: List<Position> get() = stonesBacking.toList()

    protected abstract val rule: OmokRule

    fun addStone(position: Position) {
        stonesBacking.add(position)
    }

//    fun checkWin(startPosition: Position): Boolean {
//        return rule.checkSerialSameStonesBiDirection(stonesBacking, startPosition, WIN_STANDARD)
//    }

    // ㅇㄴㅁㅁㄴ

    abstract fun isViolation(
        otherStones: List<Position>,
        startPosition: Position,
    )

    companion object {
        private const val WIN_STANDARD = 5

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
    }
}
