package com.brunolemus.lox4s
package models

import models.Token.TokenType

case class Token(
    tokenType: TokenType,
    lexeme: String,
    literal: Option[Any],
    line: Int
)

object Token:

    enum TokenType:
        case LeftParen, RightParen, LeftBrace, RightBrace, Comma, Dot, Minus,
            Plus, Semicolon, Slash, Star
        case Bang, BangEqual, Equal, EqualEqual, Greater, GreaterEqual, Less,
            LessEqual
        case Identifier, String, Number
        case And, Class, Else, False, Fun, For, If, Nil, Or, Print, Return,
            Super, This, True, Var, While
        case EndOfFile
    end TokenType

end Token
