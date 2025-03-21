package omok.domain

class OmokBoard(val width: Int = DEFAULT_SIZE, val height: Int = DEFAULT_SIZE) {
    val positions: List<Position> = (1..15).flatMap { x -> (1..15).map { y -> Position(x, y) } }



    companion object {
        const val DEFAULT_SIZE: Int = 15
        private const val ERROR_STONE_ALREADY_PUT = "이미 돌이 있습니다."
    }
}
