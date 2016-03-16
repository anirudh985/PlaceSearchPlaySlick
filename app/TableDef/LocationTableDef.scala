package TableDef

import models.SearchLocation
import slick.lifted.Tag
import slick.driver.MySQLDriver.api._

/**
  * Created by anirudh on 1/3/16.
  */
class LocationTableDef(tag: Tag) extends Table[SearchLocation](tag, "location") {

  def intRowId = column[Long]("int_row_id", O.PrimaryKey, O.AutoInc)

  def locName = column[String]("loc_name")

  def category = column[String]("category")

  def rating = column[Double]("rating")

  def latitude = column[Double]("latitude")

  def longitude = column[Double]("longitude")

  override def * =
    (intRowId, locName, category, rating, latitude, longitude) <> ((SearchLocation.apply _).tupled , SearchLocation.unapply _)
}

//  def * = intRowId ~ locName ~ category ~ rating ~ latitude ~ longitude <> (
//    (intRowId: Long, locName: String, category: String, rating: Double, latitude: Double, longitude: Double)
//        => SearchLocation(intRowId, locName, category, rating, latitude, longitude),
//    (location: SearchLocation)
//        => Some((location.intRowId, location.locName, location.category, location.rating, location.latitude, location.longitude)
