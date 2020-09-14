package com.bbynum.lightappserver.repository;

import com.bbynum.lightappserver.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightRepository extends JpaRepository<Light, Long> {
}
