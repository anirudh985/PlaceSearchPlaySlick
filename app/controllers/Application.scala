package controllers

import models.{Location, SearchLocation}
import play.api._
import play.api.libs.json.{JsString, JsValue, JsObject, Json}
import play.api.mvc._
import service.Utilities
import scala.concurrent.ExecutionContext.Implicits.global
import play.mvc.BodyParser

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


  def searchMulti = Action async { implicit request =>
    val jsonValue: JsValue = request.body.asJson.getOrElse(JsString(""))
    val placeQuery: Option[String] = (jsonValue \ "placeQuery").asOpt[String]
    Utilities.searchMulti(placeQuery getOrElse "") map {
      location => Ok(Json.toJson(location))
    }
  }
}
