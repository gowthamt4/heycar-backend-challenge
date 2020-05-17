package com.heycar.vehicle.challenge.dao;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.heycar.vehicle.challenge.model.DealerVehicleId;
import com.heycar.vehicle.challenge.model.Vehicle;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, DealerVehicleId>, PagingAndSortingRepository<Vehicle, DealerVehicleId> {
  
  @Query(name = "from Vehicle P where P.make LIKE CONCAT('%',:make,'%')")
  public Page<Vehicle> findAllByMake(@Param("make") final String make, Pageable pageable);
  
  @Query(name = "from Vehicle P where P.model LIKE CONCAT('%',:model,'%')")
  public Page<Vehicle> findAllByModel(@Param("model") final String model, Pageable pageable);
  
  @Query(name = "from Vehicle P where P.year LIKE CONCAT('%',:year,'%')")
  public Page<Vehicle> findAllByYear(@Param("year") final String model, Pageable pageable);

  @Query(name = "from Vehicle P where P.color LIKE CONCAT('%',:color,'%')")
  public Page<Vehicle> findAllByColor(String color, Pageable pageable);

  
}
