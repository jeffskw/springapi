package io.github.jeffskw.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import io.github.jeffskw.domain.entity.Address;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface Adresses extends JpaRepository<Address, Integer> {


    //   List<Address> filterByStreetLike (String streetName);
}
