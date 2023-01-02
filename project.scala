//> using lib "org.typelevel::cats-effect::3.4.4"

import cats.IO
import cats.kernel.Resource
import cats.effect.std.Unique

final class SettingKey[A] private (unique: Unique)

sealed abstract class SettingValue[A]

object SettingValue {
  private final case class Eval[A](resource: Resource[IO, A])
  private final case class Map[A, B](sva: SettingValue[A], f: A => SettingValue[B])
}

// final case class Project(settings)
