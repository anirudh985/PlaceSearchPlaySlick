package dao

import TableDef.LocationTableDef
import models.SearchLocation
import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
//import slick.driver.MySQLDriver.api._
import slick.driver.PostgresDriver.api._
import slick.lifted.TableQuery
import scala.concurrent.Future

/**
  * Created by anirudh on 1/3/16.
  */
object LocationDao {
    // Getting the DB Config from application.conf
    val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

    // Getting the Location object mapped to table
    val locations = TableQuery[LocationTableDef]

    val getListofPlaces: Future[Seq[SearchLocation]] = {
      dbConfig.db.run(locations.result)
    }

    val getCount: Future[Int] = dbConfig.db.run(locations.length.result)

    def searchMulti(placeQuery: String) : Future[Seq[SearchLocation]] = {
        dbConfig.db.run(locations.
          filter(x => (x.category.toLowerCase.indexOf(placeQuery.toLowerCase) >= 0)
                         || (x.locName.toLowerCase.indexOf(placeQuery.toLowerCase) >= 0))
                .result)
    }
}
