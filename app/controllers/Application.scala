package controllers

import models.{Location, SearchLocation}
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import service.Utilities
import scala.concurrent.ExecutionContext.Implicits.global

class Application extends Controller {

  def index = Action {
      Ok(views.html.index("Place Lookup")("Hello Anirudh"))
  }

  def getList = Action async{
      Utilities.getListofPlaces map {
        location => Ok(Json.toJson(location))
      }
  }

  def getCount = Action async{
      Utilities.getCount map(count => Ok(Json.toJson(count)))
  }

  def search = TODO

  def searchMulti = TODO
}
