package service

import dao.LocationDao
import models.SearchLocation
import slick.lifted.Rep

import scala.concurrent.Future

/**
  * Created by anirudh on 1/3/16.
  */
object Utilities {
  def getListofPlaces: Future[Seq[SearchLocation]] = {
    LocationDao.getListofPlaces
  }

  def getCount: Future[Int] = LocationDao.getCount

  def searchMulti(placeQuery: String): Future[Seq[SearchLocation]] = {
    LocationDao.searchMulti(placeQuery)
  }
}
