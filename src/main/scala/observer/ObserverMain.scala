package observer

import observer.device.{BrightnessSensor, Switch}
import observer.log.{LoggingObserver, TerminalLogger}

import javax.swing.text.html.parser.Entity

@main def ObserverMain(): Unit =
  val sensor = new BrightnessSensor;
  val switch = new Switch;
  val logger = new TerminalLogger;

  sensor.addObserver(logger);
  switch.addObserver(logger);

  sensor.remeasure()
  sensor.remeasure()
  switch.set(1)
  switch.set(0)