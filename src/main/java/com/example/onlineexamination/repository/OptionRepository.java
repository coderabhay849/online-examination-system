package com.example.onlineexamination.repository;

import com.example.onlineexamination.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}