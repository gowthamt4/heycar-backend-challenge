package com.heycar.vehicle.challenge;

public interface QueryConstants {
  
  String GET_VEHICLES_BY_MAKE = 
      "select V from Vehicle as V " 
          + "where V.make LIKE CONCAT('%',:make,'%')";
  
  String GET_VEHICLES_BY_MODEL = 
      "select V from Vehicle as V " 
          + "where V.model LIKE CONCAT('%',:model,'%')";
  
  String GET_VEHICLES_BY_YEAR = 
      "select V from Vehicle as V " 
          + "where V.year = :year";
  
  String GET_VEHICLES_BY_COLOR = 
      "select V from Vehicle as V " 
          + "where V.color LIKE CONCAT('%',:color,'%')";
  
  String GET_VEHICLES_BY_MAKE_MODEL = 
      "select V from Vehicle as V " 
          + "where V.make LIKE CONCAT('%',:make,'%') "
          + "and V.model LIKE CONCAT('%',:model,'%')";

  String GET_VEHICLES_BY_MODEL_YEAR = 
      "select V from Vehicle as V " 
          + "where V.model LIKE CONCAT('%',:model,'%') "
          + "and V.year = :year";

  String GET_VEHICLES_BY_MAKE_YEAR = 
      "select V from Vehicle as V " 
          + "where V.make LIKE CONCAT('%',:make,'%') "
          + "and V.year = :year";

  String GET_VEHICLES_BY_MAKE_COLOR = 
      "select V from Vehicle as V " 
          + "where V.make LIKE CONCAT('%',:make,'%') "
          + "and V.color LIKE CONCAT('%',:color,'%')";

  String GET_VEHICLES_BY_MODEL_COLOR = 
      "select V from Vehicle as V " 
          + "where V.model LIKE CONCAT('%',:model,'%') "
          + "and V.color LIKE CONCAT('%',:color,'%')";
  
  String GET_VEHICLES_BY_YEAR_COLOR = 
      "select V from Vehicle as V " 
          + "where V.year = :year "
          + "and V.color LIKE CONCAT('%',:color,'%')";
  
  String GET_VEHICLES_BY_MAKE_MODEL_YEAR = 
      "select V from Vehicle as V " 
          + "where V.year = :year "
          + "and V.make LIKE CONCAT('%',:make,'%') "
          + "and V.model LIKE CONCAT('%',:model,'%')";
  
  String GET_VEHICLES_BY_MAKE_MODEL_COLOR = 
      "select V from Vehicle as V " 
          + "where V.color LIKE CONCAT('%',:color,'%') "
          + "and V.make LIKE CONCAT('%',:make,'%') "
          + "and V.model LIKE CONCAT('%',:model,'%')";
  
  String GET_VEHICLES_BY_MAKE_YEAR_COLOR = 
      "select V from Vehicle as V " 
          + "where V.year = :year "
          + "and V.color LIKE CONCAT('%',:color,'%') "
          + "and V.make LIKE CONCAT('%',:make,'%')";
  
  String GET_VEHICLES_BY_MODEL_YEAR_COLOR = 
      "select V from Vehicle as V " 
          + "where V.color LIKE CONCAT('%',:color,'%') "
          + "and V.year = :year "
          + "and V.model LIKE CONCAT('%',:model,'%')";
  
  String GET_VEHICLES_BY_MAKE_MODEL_YEAR_COLOR = 
      "select V from Vehicle as V " 
          + "where V.color LIKE CONCAT('%',:color,'%') "
          + "and V.year = :year "
          + "and V.make LIKE CONCAT('%',:make,'%') "
          + "and V.model LIKE CONCAT('%',:model,'%')";
  
  String GET_ALL_VEHICLES = 
      "select V from Vehicle as V";
}
