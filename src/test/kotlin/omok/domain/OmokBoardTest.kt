package omok.domain
//
// import org.assertj.core.api.Assertions.assertThat
// import org.junit.jupiter.api.BeforeEach
// import org.junit.jupiter.api.Test
// import org.junit.jupiter.api.assertThrows
//
// class OmokBoardTest {
//    private lateinit var omokBoard: OmokBoard
//
//    @BeforeEach
//    fun setUp() {
//        omokBoard = OmokBoard()
//    }
//
//    @Test
//    fun `좌표와 돌 상태를 받으면 해당 위치에 돌을 놓는다`() {
//        // given
//        val row = 1
//        val col = 2
//        // when
//        omokBoard.putStone(Position(row, col), StoneState.BLACK)
//        // then
//        assertThat(omokBoard.positions[row][col]).isEqualTo(StoneState.BLACK)
//    }
//
//    @Test
//    fun `좌표에 이미 돌이 있으면 예외를 던진다`() {
//        // given
//        val row = 1
//        val col = 2
//        // when
//        omokBoard.putStone(Position(row, col), StoneState.BLACK)
//        // then
//        assertThrows<IllegalStateException> {
//            omokBoard.canPlace(Position(row, col))
//        }
//    }
// }
