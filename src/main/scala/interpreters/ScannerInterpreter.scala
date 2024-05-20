package com.brunolemus.lox4s
package interpreters

import algebras.Scanner
import interpreters.ScannerInterpreter.{ScannerState, UnexpectedCharacter}
import models.Token
import models.Token.TokenType

import cats.Monad
import cats.data.StateT
import cats.syntax.all.*

class ScannerInterpreter[F[_]: Monad] extends Scanner[F]:

  override def scanTokens(source: String): fs2.Stream[F, Token] =
    fs2.Stream.unfold(ScannerState(0, 0, 0, source)): scannerState =>
      val next      = scannerState.current + 1
      val tokenType = scannerState.source.charAt(next) match
        case '('   => Right(TokenType.LeftParen)
        case ')'   => Right(TokenType.RightParen)
        case '{'   => Right(TokenType.LeftParen)
        case '}'   => Right(TokenType.RightParen)
        case ','   => Right(TokenType.Comma)
        case '.'   => Right(TokenType.Dot)
        case '-'   => Right(TokenType.Minus)
        case '+'   => Right(TokenType.Plus)
        case ';'   => Right(TokenType.Semicolon)
        case '*'   => Right(TokenType.Star)
        case other => Left(UnexpectedCharacter(scannerState.line, other))
      Some((Token(), scannerState.copy(current = next)))

end ScannerInterpreter

object ScannerInterpreter:

  case class ScannerState(start: Int, current: Int, line: Int, source: String):
    def getChar(index: Int): Char = source.charAt(index)
  end ScannerState

  case class UnexpectedCharacter(line: Int, char: Char)

end ScannerInterpreter
