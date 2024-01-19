package observer.log

trait LoggingObserver[Subject, Delta]:
  def update(subject: Subject, delta: Number, timestamp: Long): Unit