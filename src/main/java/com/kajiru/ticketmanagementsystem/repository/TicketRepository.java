package com.kajiru.ticketmanagementsystem.repository;

import com.kajiru.ticketmanagementsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
