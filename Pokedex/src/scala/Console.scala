package com.pokemon.db

import monix.eval.Task

object Console {
  def readline(): Task[String] =
    Task(scala.io.StdIn.readLine())

  def write[A](obj: A): Task[Unit] =
    Task(print(obj.toString))

  def writeLine[A](obj: A): Task[Unit] =
    Task(println(obj.toString))

  def writeList[A](list: List[A]): Task[Unit] =
    Task.sequence(
      list.map(writeLine) // List[Task[Unit]]
      // List[Task[Unit]] => Task[List[Unit]] => Task[Unit]
    )
    .map(_ => ())
}
