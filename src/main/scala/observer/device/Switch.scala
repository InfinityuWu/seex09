package observer.device

import observer.log.{Entity, EntityChange, Loggable}

case class Switch(name: String) extends Control with Loggable[Entity, EntityChange]:
  private var state: Boolean = false

  override def currentState: Int = if state then 1 else 0

  override def set(state: Int): Boolean =
    if (this.state)
      if (state <= 0)
        this.state = false
        val str : String = currentState.toString;
        notifyObservers(this, currentState)
        true
      else
        false
    else
      if (state > 0)
        this.state = true
        notifyObservers(this, currentState)
        true
      else
        false
