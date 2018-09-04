package fundamentals.level03

import fundamentals.level03.OptionExercises2.{HumanId, Job, JobId, findHumanById, findJobById}

/**
  * These exercises mirror the ones from `OptionExercises2.scala`,
  * they are for the purpose of teaching for-comprehension, which is very useful for working with `Option`.
  */
object OptionExercises3 {

  /**
    * scala> findJobIdByHumanIdUsingFor(1)
    * = None
    *
    * scala> findJobIdByHumanIdUsingFor(2)
    * = Some(1)
    */
  def findJobIdByHumanIdUsingFor(humanId: HumanId): Option[JobId] =
    for {
      human <- findHumanById(humanId) // Find a function of type HumanId => Option[Human]
      jobId <- human.optJobId // Find a function of type Human => Option[JobId]
    } yield jobId

  /**
    * scala> findJobByHumanIdUsingFor(2)
    * = Some(Job("Teacher", "Expert in their field"))
    *
    * Hint: Use findJobIdByHumanIdUsingFor
    */
  def findJobByHumanIdUsingFor(humanId: HumanId): Option[Job] =
    for {
      jobId <- findJobIdByHumanIdUsingFor(humanId) // Find a function of type HumanId => Option[JobId]
      job <- findJobById(jobId)   // Find a function of type JobId => Option[Job]
    } yield job

  /**
    * scala> findJobDescriptionByHumanIdUsingFor(2)
    * = Some("Teacher")
    *
    * scala> findJobDescriptionByHumanIdUsingFor(1)
    * = None
    *
    * Hint: Use `findJobByHumanIdUsingFor` and for comprehension
    */
  def findJobNameByHumanIdUsingFor(humanId: HumanId): Option[String] =
//    for {
//      job <- findJobByHumanIdUsingFor(humanId)
//    } yield job.name
    for {
      job <- findJobByHumanIdUsingFor(humanId)
      name = job.name
    } yield name
}
