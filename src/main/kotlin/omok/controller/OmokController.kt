package omok.controller

import omok.domain.OmokBoard
import omok.domain.OmokGame
import omok.domain.OmokResult
import omok.domain.StoneState
import omok.view.InputView
import omok.view.OutputView

class OmokController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun play() {
        val omokGame = initGame()
        val result =
            omokGame.playGame(
                onTurnStarted = { outputView.printBoardState(omokGame.board) },
                onSelectPosition = { _, _, _ ->
                    inputView.getPoint(
                        StoneState.BLACK,
                        null,
                        omokGame.board,
                    )
                },
            )
        printWinner(result, omokGame)
    }

    private fun initGame(): OmokGame {
        outputView.printStartMessage()
        return OmokGame(OmokBoard())
    }

    private fun printWinner(
        omokResult: OmokResult,
        omokGame: OmokGame,
    ) {
        outputView.printBoardState(omokGame.board)
        outputView.printWinner(omokResult)
    }
}
