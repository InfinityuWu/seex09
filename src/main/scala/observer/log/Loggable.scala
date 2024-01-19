package observer.log

import scala.collection.mutable.Set as mSet

trait Loggable[Subject, Delta]:
  val observers: mSet[LoggingObserver[Subject, Delta]] = mSet.empty

  def addObserver(observer : LoggingObserver[Subject, Delta]): Unit =
    observers.add(observer);

  def removeObserver(observer: LoggingObserver[Subject, Delta]): Unit =
    observers.remove(observer);

  def notifyObservers(sub: Subject, delta: Number): Unit =
    val timestamp: Long = System.currentTimeMillis();
    for (observer <- observers)
      observer.update(sub, delta, timestamp)
