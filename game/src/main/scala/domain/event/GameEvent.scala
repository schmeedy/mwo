package domain.event

import domain.state.GameState

trait GameEvent extends ((GameState) => GameState)
