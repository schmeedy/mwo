package domain.state.meta

import domain.state.common.Enum

object ActionType extends Enum[ActionType]
sealed trait ActionType extends ActionType.Value
case object QuickAction extends ActionType
case object FullAction extends ActionType