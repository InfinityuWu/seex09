package observer.log

import scala.collection.mutable.Set as mSet

trait Loggable[Subject, Delta]:
  val observers: mSet[LoggingObserver[Subject, Delta]] = mSet.empty

  def addObserver(observer : LoggingObserver): void
    observers.add(observer);

  def removeObserver(observer: LoggingObserver): void
    observers.remove(observer);

  def notifyObservers(sub: Sub, delta: Delta): Unit =
    timestamp: Long = System.currentTimeMillis();
    for (observer <- observers)
      observer.update(sub, delta, timestamp)
