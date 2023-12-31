package com.example.demo.repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Define custom queries or methods if needed
}
