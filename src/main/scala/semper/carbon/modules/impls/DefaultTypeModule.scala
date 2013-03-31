package semper.carbon.modules.impls

import semper.carbon.modules.TypeModule
import semper.sil.{ast => sil}
import semper.carbon.boogie._
import semper.carbon.verifier.Verifier

/**
 * The default implementation of a [[semper.carbon.modules.StmtModule]].
 *
 * @author Stefan Heule
 */
class DefaultTypeModule(val verifier: Verifier) extends TypeModule {

  import verifier._
  import heapModule._
  import domainModule._

  def name = "Type module"
  override def translateType(t: sil.Type): Type = {
    t match {
      case sil.Bool =>
        Bool
      case sil.Int =>
        Int
      case sil.Ref =>
        refType
      case sil.Perm =>
        ???
      case sil.Pred =>
        ???
      case sil.TypeVar(name) =>
        TypeVar(name)
      case t@sil.DomainType(domain, typVarsMap) =>
        translateDomainTyp(t)
    }
  }
}
