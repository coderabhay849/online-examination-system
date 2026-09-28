package com.example.onlineexamination.repository;

import com.example.onlineexamination.entity.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {
}