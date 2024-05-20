package com.brunolemus.lox4s
package algebras

import models.Token

import fs2.Pipe

trait Scanner[F[_]]:

    def scanTokens(source: String): fs2.Stream[F, Token]

end Scanner
