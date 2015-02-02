package domain.state.meta

import domain.state.common.Enum

object ActionType extends Enum[ActionType] {
  QuickAction; FullAction
}
sealed trait ActionType extends ActionType.Value
case object QuickAction extends ActionType
case object FullAction extends ActionType