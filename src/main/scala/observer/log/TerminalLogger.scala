package observer.log

class TerminalLogger extends LoggingObserver[Entity, EntityChange] {
  def update(entity: Entity, delta: Number, timestamp: Long): Unit = 
    val identifier : String = entity.identifier
    val pretty : String = delta.toString;
    println(s"""$timestamp;$identifier;$pretty""")
}
