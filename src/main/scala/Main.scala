package com.brunolemus.lox4s

import algebras.Scanner

import cats.effect.{ExitCode, IO, IOApp}
import fs2.io.file.{Files, Path}
import fs2.text

object Main extends IOApp:

  private val scanner: Scanner[IO] = ???

  override def run(args: List[String]): IO[ExitCode] = args match
    case head :: Nil => runFile(Path(head)) as ExitCode.Success
    case Nil         => runPrompt() as ExitCode.Success
    case _           => IO.println("Usage: slox [script]") as ExitCode(64)

  private def runFile(path: Path): IO[Unit] =
    Files[IO]
      .readAll(path)
      .through(text.utf8.decode)
      .compile
      .string
      .flatMap(runProgram)

  private def runPrompt(): IO[Unit] =
    (for
      _    <- IO.print("> ")
      line <- IO.readLine
    yield line)
      .flatMap: line =>
        if line != null
        then runProgram(line)
        else IO.unit

  private def runProgram(source: String): IO[Unit] =
    scanner.scanTokens(source).evalMap(IO.println).compile.drain

end Main
