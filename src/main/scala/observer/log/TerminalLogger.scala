package observer.log

class TerminalLogger extends LoggingObserver[Entity, EntityChange] {
  def update(entity: Entity, delta: EntityChange, timestamp: Long): Unit = 
    indetifier = entity.identifier
    pretty = delta.pretty
    println(s"""$timestamp;$identifier;$pretty""")
}
